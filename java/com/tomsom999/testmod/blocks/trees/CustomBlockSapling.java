package com.tomsom999.testmod.blocks.trees;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.tomsom999.testmod.Main;
import com.tomsom999.testmod.init.ModBlocks;
import com.tomsom999.testmod.init.ModItems;
import com.tomsom999.testmod.util.IHasModel;
import com.tomsom999.testmod.util.handelers.EnumHandeler;
import com.tomsom999.testmod.util.interfaces.IMetaName;
import com.tomsom999.testmod.world.feature.tree.WorldGenSilverTree;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class CustomBlockSapling extends BlockBush implements IGrowable, IMetaName
{	
	 public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	 protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
	 public static final PropertyEnum<EnumHandeler.EnumType> VARIANT = PropertyEnum.<EnumHandeler.EnumType>create("variant", EnumHandeler.EnumType.class, new Predicate<EnumHandeler.EnumType>()                 
	 {
		public boolean apply(@Nullable EnumHandeler.EnumType apply)
		{
			return apply.getMeta() < 1;
		}
	});   
	 
	 


	public CustomBlockSapling(String name) 
    {
	   	setSoundType(SoundType.PLANT);
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandeler.EnumType.SILVER).withProperty(STAGE, Integer.valueOf(0)));
		setCreativeTab(Main.modtab);
			
	}
	    
    //Sapling Shape	    
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		return SAPLING_AABB;
	}
	
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) 
	{
    	return NULL_AABB;
	}
	    
	   
    @Override
    public boolean isOpaqueCube(IBlockState state) 
    {
    	return false;
    }
	    
    @Override
    public boolean isFullCube(IBlockState state) 
    {
    	return false;
    }
	    
    //Variants   
    @Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) 
	{
		for(EnumHandeler.EnumType customblockplanks$enumtype : EnumHandeler.EnumType.values())
		{
			items.add(new ItemStack(this, 1, customblockplanks$enumtype.getMeta()));
		}
	}

	@Override
	public int damageDropped(IBlockState state) 
	{
		return ((EnumHandeler.EnumType)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public String getSpecialName(ItemStack stack)
	{
		return EnumHandeler.EnumType.values()[stack.getItemDamage()].getName();
	}
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		return this.getDefaultState().withProperty(VARIANT, EnumHandeler.EnumType.byMetadata(meta & 0)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		int i = 0;
		i = i | ((EnumHandeler.EnumType)state.getValue(VARIANT)).getMeta();
		i= i | ((Integer)state.getValue(STAGE)).intValue() << 3;
		return i;
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT,STAGE});
	}
	
	
	
	//Tree Code
	
	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		if(((Integer)state.getValue(STAGE)).intValue() == 0)
		{
			worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
		}
		else
		{
			generateTree(worldIn, rand, pos, state);
		}
	}
	
	public void generateTree(World world, Random rand, BlockPos pos, IBlockState state)
	{
		if(TerrainGen.saplingGrowTree(world, rand, pos)) return;
		WorldGenerator gen = (WorldGenerator)(rand.nextInt(10) == 0 ? new WorldGenBigTree(false) : new WorldGenTrees(false));
		int i = 0, j = 0;
		boolean flag = false;
		
		switch((EnumHandeler.EnumType)state.getValue(VARIANT))
		{
		case SILVER:
			gen = new WorldGenSilverTree();
			break;
		}
		
		IBlockState iblockstate = Blocks.AIR.getDefaultState();
		if(flag)
		{
			world.setBlockState(pos.add(0, 0, 0), iblockstate, 4);
			world.setBlockState(pos.add(1, 0, 0), iblockstate, 4);
			world.setBlockState(pos.add(0, 0, 1), iblockstate, 4);
			world.setBlockState(pos.add(1, 0, 1), iblockstate, 4);
		}
		else
		{
			world.setBlockState(pos, iblockstate, 4);
		}
		
		if(!gen.generate(world, rand, pos))
		{
			if(flag)
			{
				world.setBlockState(pos.add(0, 0, 0), iblockstate, 4);
				world.setBlockState(pos.add(1, 0, 0), iblockstate, 4);
				world.setBlockState(pos.add(0, 0, 1), iblockstate, 4);
				world.setBlockState(pos.add(1, 0, 1), iblockstate, 4);
			}
			else
			{
				world.setBlockState(pos, iblockstate, 4);
			}
		}
	}
	
	
	
	
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) 
	{
		return true;
	}
	
	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		return (double)worldIn.rand.nextFloat() < 0.45D;
	}
	
	protected boolean canSustainBush(IBlockState state)
    {
        return state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.FARMLAND;
    }
   
}
