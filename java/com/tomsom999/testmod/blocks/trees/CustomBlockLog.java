package com.tomsom999.testmod.blocks.trees;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.tomsom999.testmod.Main;
import com.tomsom999.testmod.init.ModBlocks;
import com.tomsom999.testmod.init.ModItems;
import com.tomsom999.testmod.util.IHasModel;
import com.tomsom999.testmod.util.handelers.EnumHandeler;
import com.tomsom999.testmod.util.interfaces.IMetaName;

import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class CustomBlockLog extends BlockLog implements IMetaName
{
	
	public static final PropertyEnum<EnumHandeler.EnumType> VARIANT = PropertyEnum.<EnumHandeler.EnumType>create("variant", EnumHandeler.EnumType.class, new Predicate<EnumHandeler.EnumType>()                 
	{
		public boolean apply(@Nullable EnumHandeler.EnumType apply)
		{
			return apply.getMeta() < 1;
		}
	});
	

	
	public CustomBlockLog(String name) 
	{	
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.WOOD);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandeler.EnumType.SILVER).withProperty(LOG_AXIS, EnumAxis.Y));
		setCreativeTab(Main.modtab);
	}
	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) 
	{
		for(EnumHandeler.EnumType enumhandeler$enumtype : EnumHandeler.EnumType.values())
		{
			items.add(new ItemStack(this, 1, enumhandeler$enumtype.getMeta()));
		}
	}
	
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		IBlockState state = this.getDefaultState().withProperty(VARIANT, EnumHandeler.EnumType.byMetadata(meta));
		
		switch(meta & 6)
		{
			case 0:
				state = state.withProperty(LOG_AXIS, EnumAxis.Y);
				break;
			
			case 1:
				state = state.withProperty(LOG_AXIS, EnumAxis.X);
				break;
			
			case 2:
				state = state.withProperty(LOG_AXIS, EnumAxis.Z);
				break;
			
			default:
				state = state.withProperty(LOG_AXIS, EnumAxis.NONE);
		}
		
		return state;
	}
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		int i = 0;
		i = i | ((EnumHandeler.EnumType)state.getValue(VARIANT)).getMeta();
		
		switch((BlockLog.EnumAxis)state.getValue(LOG_AXIS))
		{
		case X:
			i |= 2;
			break;
			
		case Y:
			i |= 4;
			break;
			
		case Z:
			i |= 6;
		}
		
		return i;
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT,LOG_AXIS});
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
}
