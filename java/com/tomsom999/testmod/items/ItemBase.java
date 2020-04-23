package com.tomsom999.testmod.items;

import com.tomsom999.testmod.Main;
import com.tomsom999.testmod.init.ModItems;
import com.tomsom999.testmod.tabs.ModTab;
import com.tomsom999.testmod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
	
	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.modtab);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this,  0, "inventory");
	}

}
