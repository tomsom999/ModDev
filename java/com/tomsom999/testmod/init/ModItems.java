package com.tomsom999.testmod.init;

import java.util.ArrayList;
import java.util.List;

import com.tomsom999.testmod.items.ItemBase;
import com.tomsom999.testmod.items.armor.ArmorBase;
import com.tomsom999.testmod.items.food.FoodBase;
import com.tomsom999.testmod.items.food.FoodEffectBase;
import com.tomsom999.testmod.items.tools.ToolAxe;
import com.tomsom999.testmod.items.tools.ToolHoe;
import com.tomsom999.testmod.items.tools.ToolPickaxe;
import com.tomsom999.testmod.items.tools.ToolSpade;
import com.tomsom999.testmod.items.tools.ToolSword;
import com.tomsom999.testmod.util.reference;

import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Materials
	public static final ToolMaterial MATERIAL_REDSTONE_ALLOY = EnumHelper.addToolMaterial("material_redstone_alloy", 2, 1600, 7.5f, 2.7f, 25);
	public static final ArmorMaterial  ARMOR_MATERIAL_REDSTONE_ALLOY = EnumHelper.addArmorMaterial("armor_material_redstone_alloy", reference.MOD_ID + ":redstone_alloy", 15, 
			new int[] {3, 5, 7, 3}, 17, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0f);
	
	public static final ToolMaterial MATERIAL_DRAGONITE = EnumHelper.addToolMaterial("material_dragonite", 4, 2600, 9f, 4, 30);
	public static final ArmorMaterial  ARMOR_MATERIAL_DRAGONITE = EnumHelper.addArmorMaterial("armor_material_dragonite", reference.MOD_ID + ":dragonite", 25, 
			new int[] {5, 8, 10, 6}, 25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0f);
	
	public static final ToolMaterial MATERIAL_COPPER = EnumHelper.addToolMaterial("material_copper", 2, 1000, 2f, 1.5f, 15);
	public static final ArmorMaterial  ARMOR_MATERIAL_COPPER = EnumHelper.addArmorMaterial("armor_material_copper", reference.MOD_ID + ":copper", 7, 
			new int[] {3, 4, 6, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f);
	
	public static final ArmorMaterial  MATERIAL_REDSTONE_BLOCK_HEAD = EnumHelper.addArmorMaterial("head_redstone_block", reference.MOD_ID + ":redstone_block", 99999, 
			new int[] {1, 0, 0, 0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f);
	public static final ArmorMaterial  MATERIAL_CREEPER_HEAD = EnumHelper.addArmorMaterial("head_creeper", reference.MOD_ID + ":cheeper", 99999, 
			new int[] {1, 0, 0, 0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f);
	public static final ArmorMaterial  MATERIAL_SHEEP_HEAD = EnumHelper.addArmorMaterial("head_sheep", reference.MOD_ID + ":sheep", 99999, 
			new int[] {1, 0, 0, 0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f);
	public static final ArmorMaterial  MATERIAL_CHICKEN_HEAD = EnumHelper.addArmorMaterial("head_chicken", reference.MOD_ID + ":chicken", 99999, 
			new int[] {1, 0, 0, 0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f);
	
	//Items
	public static final Item REDSTONE_ALLOY = new ItemBase("redstone_alloy");	
	public static final Item MOLTEN_REDSTONE = new ItemBase("molten_redstone");
	public static final Item DRAGONITE_INGOT = new ItemBase("dragonite_ingot");
	public static final Item COPPER_INGOT = new ItemBase("copper_ingot");
	
	
	//Tools
	public static final ItemSword REDSTONE_SWORD = new ToolSword("redstone_sword", MATERIAL_REDSTONE_ALLOY);
	public static final ItemSpade REDSTONE_SHOVEL = new ToolSpade("redstone_shovel", MATERIAL_REDSTONE_ALLOY);
	public static final ItemPickaxe REDSTONE_PICKAXE = new ToolPickaxe("redstone_pickaxe", MATERIAL_REDSTONE_ALLOY);
	public static final ItemAxe REDSTONE_AXE = new ToolAxe("redstone_axe", MATERIAL_REDSTONE_ALLOY);
	public static final ItemHoe REDSTONE_HOE = new ToolHoe("redstone_hoe", MATERIAL_REDSTONE_ALLOY);
	
	public static final ItemSword DRAGONITE_SWORD = new ToolSword("dragonite_sword", MATERIAL_DRAGONITE);
	public static final ItemSpade DRAGONITE_SHOVEL = new ToolSpade("dragonite_shovel", MATERIAL_DRAGONITE);
	public static final ItemPickaxe DRAGONITE_PICKAXE = new ToolPickaxe("dragonite_pickaxe", MATERIAL_DRAGONITE);
	public static final ItemAxe DRAGONITE_AXE = new ToolAxe("dragonite_axe", MATERIAL_DRAGONITE);
	public static final ItemHoe DRAGONITE_HOE = new ToolHoe("dragonite_hoe", MATERIAL_DRAGONITE);
	
	public static final ItemSword COPPER_SWORD = new ToolSword("copper_sword", MATERIAL_COPPER);
	public static final ItemSpade COPPER_SHOVEL = new ToolSpade("copper_shovel", MATERIAL_COPPER);
	public static final ItemPickaxe COPPER_PICKAXE = new ToolPickaxe("copper_pickaxe", MATERIAL_COPPER);
	public static final ItemAxe COPPER_AXE = new ToolAxe("copper_axe", MATERIAL_COPPER);
	public static final ItemHoe COPPER_HOE = new ToolHoe("copper_hoe", MATERIAL_COPPER);
	
	//Armor
	public static final Item REDSTONE_HELMET = new ArmorBase("redstone_helmet", ARMOR_MATERIAL_REDSTONE_ALLOY, 1, EntityEquipmentSlot.HEAD);
	public static final Item REDSTONE_CHESTPLATE = new ArmorBase("redstone_chestplate", ARMOR_MATERIAL_REDSTONE_ALLOY, 1, EntityEquipmentSlot.CHEST);
	public static final Item REDSTONE_LEGGINGS = new ArmorBase("redstone_leggings", ARMOR_MATERIAL_REDSTONE_ALLOY, 2, EntityEquipmentSlot.LEGS);
	public static final Item REDSTONE_BOOTS = new ArmorBase("redstone_boots", ARMOR_MATERIAL_REDSTONE_ALLOY, 1, EntityEquipmentSlot.FEET);
	
	public static final Item DRAGONITE_HELMET = new ArmorBase("dragonite_helmet", ARMOR_MATERIAL_DRAGONITE, 1, EntityEquipmentSlot.HEAD);
	public static final Item DRAGONITE_CHESTPLATE = new ArmorBase("dragonite_chestplate", ARMOR_MATERIAL_DRAGONITE, 1, EntityEquipmentSlot.CHEST);
	public static final Item DRAGONITE_LEGGINGS = new ArmorBase("dragonite_leggings", ARMOR_MATERIAL_DRAGONITE, 2, EntityEquipmentSlot.LEGS);
	public static final Item DRAGONITE_BOOTS = new ArmorBase("dragonite_boots", ARMOR_MATERIAL_DRAGONITE, 1, EntityEquipmentSlot.FEET);
	
	public static final Item COPPER_HELMET = new ArmorBase("copper_helmet", ARMOR_MATERIAL_COPPER, 1, EntityEquipmentSlot.HEAD);
	public static final Item COPPER_CHESTPLATE = new ArmorBase("copper_chestplate", ARMOR_MATERIAL_COPPER, 1, EntityEquipmentSlot.CHEST);
	public static final Item COPPER_LEGGINGS = new ArmorBase("copper_leggings", ARMOR_MATERIAL_COPPER, 2, EntityEquipmentSlot.LEGS);
	public static final Item COPPER_BOOTS = new ArmorBase("copper_boots", ARMOR_MATERIAL_COPPER, 1, EntityEquipmentSlot.FEET);
	
	//Heads
	public static final Item REDSTONE_BLOCK_HEAD = new ArmorBase("redstone_block_head", MATERIAL_REDSTONE_BLOCK_HEAD, 1, EntityEquipmentSlot.HEAD);
	public static final Item SHEEP_HEAD = new ArmorBase("sheep_head", MATERIAL_SHEEP_HEAD, 1, EntityEquipmentSlot.HEAD);
	public static final Item CREEPER_HEAD = new ArmorBase("creeper_head", MATERIAL_CREEPER_HEAD, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHICKEN_HEAD = new ArmorBase("chicken_head", MATERIAL_CHICKEN_HEAD, 1, EntityEquipmentSlot.HEAD);
	
	//Food
	//public static final Item POISONED_APPLE = new FoodBase("poisoned_apple", 5, 2.5f, false);
	 public static final Item POISONED_APPLE = new FoodEffectBase("poisoned_apple", 5, 2.5f, false, new PotionEffect(MobEffects.POISON, (15 * 20), 1, false, false));
	
}