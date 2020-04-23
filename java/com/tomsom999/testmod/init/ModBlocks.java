package com.tomsom999.testmod.init;

import java.util.ArrayList;
import java.util.List;

import com.tomsom999.testmod.Main;
import com.tomsom999.testmod.blocks.CopperBlock;
import com.tomsom999.testmod.blocks.CopperOre;
import com.tomsom999.testmod.blocks.DragoniteBlock;
import com.tomsom999.testmod.blocks.DragoniteOre;
import com.tomsom999.testmod.blocks.RedstoneAlloyBlock;
import com.tomsom999.testmod.blocks.item.ItemBlockVariants;
import com.tomsom999.testmod.blocks.trees.CustomBlockLeaves;
import com.tomsom999.testmod.blocks.trees.CustomBlockLog;
import com.tomsom999.testmod.blocks.trees.CustomBlockPlanks;
import com.tomsom999.testmod.blocks.trees.CustomBlockSapling;
import com.tomsom999.testmod.util.reference;
import com.tomsom999.testmod.util.handelers.EnumHandeler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block REDSTONE_ALLOY_BLOCK = new RedstoneAlloyBlock("redstone_alloy_block", Material.IRON);	
	public static final Block DRAGONITE_BLOCK = new DragoniteBlock("dragonite_block", Material.IRON);
	public static final Block COPPER_BLOCK = new CopperBlock("copper_block", Material.IRON);
	public static final Block DRAGONITE_ORE = new DragoniteOre("dragonite_ore", Material.ROCK);
	public static final Block COPPER_ORE = new CopperOre("copper_ore", Material.ROCK);
	

	public static Block planks, leaves, log, sapling;
	
	
	public static void init()
	{
		planks = new CustomBlockPlanks("planks");
		leaves = new CustomBlockLeaves("leaves");
		log = new CustomBlockLog("log");
		sapling = new CustomBlockSapling("sapling");
	}
	
	public static void register()
	{
		RegisterBlockWithVariants(planks, new ItemBlockVariants(planks));
		RegisterBlockWithVariants(leaves, new ItemBlockVariants(leaves));
		RegisterBlockWithVariants(log, new ItemBlockVariants(log));
		RegisterBlockWithVariants(sapling, new ItemBlockVariants(sapling));
	}
	public static void RegisterRenders()
	{
		for(int i = 0; i < EnumHandeler.EnumType.values().length; i++)
		{
			RegisterRender(planks, i, "planks_" + EnumHandeler.EnumType.values()[i].getName());
			RegisterRender(leaves, i, "leaves_" + EnumHandeler.EnumType.values()[i].getName());
			RegisterRender(log, i, "log_" + EnumHandeler.EnumType.values()[i].getName());
			RegisterRender(sapling, i, "sapling_" + EnumHandeler.EnumType.values()[i].getName());
		}
	}
	
    public static void registerBlock(Block block)
    {
		ForgeRegistries.BLOCKS.register(block);
		block.setCreativeTab(Main.modtab);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(item);
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
	public static void registerBlock(Block block, ItemBlock itemblock)
	{
		ForgeRegistries.BLOCKS.register(block);
		block.setCreativeTab(Main.modtab);
		itemblock.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(itemblock);
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
	
	public static void RegisterBlockWithVariants(Block block, ItemBlock itemblock)
	{
		ForgeRegistries.BLOCKS.register(block);
		block.setCreativeTab(Main.modtab);
		itemblock.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(itemblock);
	}
	
	public static void RegisterRender(Block block, int meta, String filename)
	{
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(new ResourceLocation(reference.MOD_ID, filename), "inventory"));
	}
}
