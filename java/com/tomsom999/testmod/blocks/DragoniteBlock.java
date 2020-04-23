package com.tomsom999.testmod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class DragoniteBlock extends BlockBase
{
	
	public DragoniteBlock(String name, Material material) 
	{
		super(name, material);
		
		setSoundType(SoundType.METAL);
		setHardness(7.0f);
		setResistance(50.0f);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(0.5f);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}
	
}
