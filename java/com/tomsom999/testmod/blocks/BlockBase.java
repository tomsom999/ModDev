package com.tomsom999.testmod.blocks;

import com.tomsom999.testmod.Main;
import com.tomsom999.testmod.init.ModBlocks;
import com.tomsom999.testmod.init.ModItems;
import com.tomsom999.testmod.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel
{
	public BlockBase(String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.modtab);
		
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		ModBlocks.BLOCKS.add(this);
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}
