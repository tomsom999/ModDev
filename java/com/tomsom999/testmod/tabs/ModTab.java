
package com.tomsom999.testmod.tabs;

import com.tomsom999.testmod.init.ModBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ModTab extends CreativeTabs{

	public ModTab(String label) 
	{
		super("modtab");		
		this.setBackgroundImageName("modtab.png");
	}
	
	public ItemStack getTabIconItem() { return new ItemStack(ModBlocks.REDSTONE_ALLOY_BLOCK);}
	
}
