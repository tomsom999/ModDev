package com.tomsom999.testmod.blocks.trees;

import com.tomsom999.testmod.Main;
import com.tomsom999.testmod.init.ModBlocks;
import com.tomsom999.testmod.init.ModItems;
import com.tomsom999.testmod.util.IHasModel;
import com.tomsom999.testmod.util.handelers.EnumHandeler;
import com.tomsom999.testmod.util.interfaces.IMetaName;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class CustomBlockPlanks extends Block implements IMetaName
{
	public static final PropertyEnum<EnumHandeler.EnumType> VARIANT = PropertyEnum.<EnumHandeler.EnumType>create("variant", EnumHandeler.EnumType.class);
	
	
	public CustomBlockPlanks(String name) 
	{
		super(Material.WOOD);
		
		setCreativeTab(Main.modtab);
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.WOOD);		
		setHardness(5.0f);
		setResistance(8.0f);
		setHarvestLevel("pickaxe", 1);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandeler.EnumType.SILVER));
	}
	
	@Override
	public int damageDropped(IBlockState state) 
	{
		return ((EnumHandeler.EnumType)state.getValue(VARIANT)).getMeta();
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
	public IBlockState getStateFromMeta(int meta) 
	{
		return this.getDefaultState().withProperty(VARIANT, EnumHandeler.EnumType.byMetadata(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((EnumHandeler.EnumType)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) 
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, (int)(getMetaFromState(world.getBlockState(pos))));
	}
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT});	
	}	
	
	public String getSpecialName(ItemStack stack)
	{
		return EnumHandeler.EnumType.values()[stack.getItemDamage()].getName();
	}
	
}