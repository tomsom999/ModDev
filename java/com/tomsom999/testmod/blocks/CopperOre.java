package com.tomsom999.testmod.blocks;

import java.util.Random;

import com.tomsom999.testmod.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class CopperOre extends BlockBase
{
	
	public CopperOre(String name, Material material) 
	{
		super(name, material);
		
		setSoundType(SoundType.STONE);
		setHardness(4.0f);
		setResistance(7.0f);
		setHarvestLevel("pickaxe", 2);
		//setLightLevel(0.5f);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}
//	@Override
//	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
//		return ModItems.COPPER_INGOT;
//	}
//	
//	
//	@Override
//	public int quantityDropped(Random rand) {
//		int max = 1;
//		int min = 1;
//		return rand.nextInt(max) + min;
//	}
}
