package com.tomsom999.testmod.util.handelers;

import com.tomsom999.testmod.init.ModBlocks;
import com.tomsom999.testmod.init.ModItems;
import com.tomsom999.testmod.util.IHasModel;
import com.tomsom999.testmod.world.gen.SilverTreeGen;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandeler {

	 @SubscribeEvent
	 public static void onItemRegister(RegistryEvent.Register<Item> event)
	 {
		 event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	 }
	 
	 @SubscribeEvent
	 public static void onBlockRegister(RegistryEvent.Register<Block> event)
	 {
		 event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
		 ModBlocks.init();
		 ModBlocks.register();
		 ModBlocks.RegisterRenders();
	 }

	 
	 @SubscribeEvent
	 public static void onModelRegister(ModelRegistryEvent event)
	 {
		 for(Item item : ModItems.ITEMS)
		 {
			 if(item instanceof IHasModel) 
			 {
				 ((IHasModel)item).registerModels();
			 }
		 }
		 

		 for(Block block : ModBlocks.BLOCKS)
		 {
			 if(block instanceof IHasModel) 
			 {
				 ((IHasModel)block).registerModels();
			 }
		 }

	 }
}
