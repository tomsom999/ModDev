package com.tomsom999.testmod;

import com.tomsom999.testmod.init.ModRecipes;
import com.tomsom999.testmod.proxy.CommonProxy;
import com.tomsom999.testmod.tabs.ModTab;
import com.tomsom999.testmod.util.reference;
import com.tomsom999.testmod.util.handelers.RegistryHandeler;
import com.tomsom999.testmod.world.ModWorldGen;
import com.tomsom999.testmod.world.feature.tree.WorldGenSilverTree;
import com.tomsom999.testmod.world.gen.SilverTreeGen;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = reference.MOD_ID, name =reference.MOD_ID, version = reference.VERSION)
public class Main {

	@Instance
	public static Main instance;
	
	public static final CreativeTabs modtab = new ModTab("modtab");
	
	@SidedProxy(clientSide = reference.CLIENT_PROXY_CLASS,  serverSide = reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
		GameRegistry.registerWorldGenerator(new SilverTreeGen(), 0);
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		ModRecipes.init();
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event)
	{
		
	}
}
