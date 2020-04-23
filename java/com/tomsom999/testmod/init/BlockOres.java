package com.tomsom999.testmod.init;

import com.tomsom999.testmod.Main;
import com.tomsom999.testmod.util.IHasModel;
import com.tomsom999.testmod.util.handelers.EnumHandeler;
import com.tomsom999.testmod.util.interfaces.IMetaName;

import net.minecraft.block.Block;
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

public class BlockOres extends Block implements IHasModel, IMetaName
{
	public static final PropertyEnum<EnumHandeler.EnumType> VARIANT = PropertyEnum.<EnumHandeler.EnumType>create("variant", EnumHandeler.EnumType.class);
	
	private String name, dimension;
	
	public BlockOres(String name, String dimension)
	{
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.modtab);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandeler.EnumType.SILVER));
		this.name = name;
		this.dimension = dimension;
		
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		ModBlocks.BLOCKS.add(this);
	}
	
	@Override
	public int damageDropped(IBlockState state) 
	{
		return ((EnumHandeler.EnumType)state.getValue(VARIANT)).getMeta();
	}
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return ((EnumHandeler.EnumType)state.getValue(VARIANT)).getMeta();
	}
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{	
		return this.getDefaultState().withProperty(VARIANT, EnumHandeler.EnumType.byMetadata(meta));
	}
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) 
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
		for(EnumHandeler.EnumType variant : EnumHandeler.EnumType.values())
		{
			items.add(new ItemStack(this, 1, variant.getMeta()));
		}
	}
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT});	
	}
	
	@Override
	public String getSpecialName(ItemStack stack) 
	{
		return EnumHandeler.EnumType.values()[stack.getItemDamage()].getName();
	}
	
	@Override
	public void registerModels() 
	{
		for(int i = 0; i < EnumHandeler.EnumType.values().length; i++)
		{
			Main.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "ore_" + this.dimension + "_" + EnumHandeler.EnumType.values()[i].getName(), "inventory");
		}
	}

}
