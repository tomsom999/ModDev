package com.tomsom999.testmod.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes 
{	
	
	public static void init()
	{
		GameRegistry.addSmelting(Items.REDSTONE, new ItemStack(ModItems.MOLTEN_REDSTONE, 1), 1.5f);	
		GameRegistry.addSmelting(ModBlocks.DRAGONITE_ORE, new ItemStack(ModItems.DRAGONITE_INGOT, 1), 4.5f);	
		GameRegistry.addSmelting(ModBlocks.COPPER_ORE, new ItemStack(ModItems.COPPER_INGOT, 1), 0.5f);
	}
	
}
