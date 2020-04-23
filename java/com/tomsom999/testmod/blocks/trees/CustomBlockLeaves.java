package com.tomsom999.testmod.blocks.trees;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.tomsom999.testmod.Main;
import com.tomsom999.testmod.init.ModBlocks;
import com.tomsom999.testmod.init.ModItems;
import com.tomsom999.testmod.util.IHasModel;
import com.tomsom999.testmod.util.handelers.EnumHandeler;
import com.tomsom999.testmod.util.interfaces.IMetaName;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CustomBlockLeaves extends BlockLeaves implements IMetaName
{
	public static final PropertyEnum<EnumHandeler.EnumType> VARIANT = PropertyEnum.<EnumHandeler.EnumType>create("variant", EnumHandeler.EnumType.class, new Predicate<EnumHandeler.EnumType>()                 
	{
		public boolean apply(@Nullable EnumHandeler.EnumType apply)
		{
			return apply.getMeta() < 1;
		}
	});
	
	
	public CustomBlockLeaves(String name) 
	{	
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.PLANT);
		setCreativeTab(Main.modtab);
		setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
	}
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, EnumHandeler.EnumType.byMetadata(meta % 1));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		int i = ((EnumHandeler.EnumType)state.getValue(VARIANT)).getMeta();
		if(!((Boolean)state.getValue(DECAYABLE)).booleanValue()) 
			{
				i |= 2;
			}
		if(!((Boolean)state.getValue(CHECK_DECAY)).booleanValue()) 
			{
				i|= 4;
			}
		return i;
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) 
	{
		for(EnumHandeler.EnumType customblockplanks$enumtype : EnumHandeler.EnumType.values())
		{
			items.add(new ItemStack(this, 1, customblockplanks$enumtype.getMeta()));
		}
	}

	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) 
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, ((EnumHandeler.EnumType)state.getValue(VARIANT)).getMeta());
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
	protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) {return;}
	
	@Override
	protected int getSaplingDropChance(IBlockState state) {return 30;}
	
	@Override
	public EnumType getWoodType(int meta){return null;}
	
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) 
	{
		return NonNullList.withSize(1, new ItemStack(this, 1, world.getBlockState(pos).getValue(VARIANT).getMeta()));
	}
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT,DECAYABLE,CHECK_DECAY});
	}
	@Override
	public boolean isOpaqueCube(IBlockState state) { return false;}
	
	@Override
	public BlockRenderLayer getBlockLayer() { return BlockRenderLayer.TRANSLUCENT;}
}
