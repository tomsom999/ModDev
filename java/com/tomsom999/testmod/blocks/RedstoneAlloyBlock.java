package com.tomsom999.testmod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class RedstoneAlloyBlock extends BlockBase
{
	
	public RedstoneAlloyBlock(String name, Material material) 
	{
		super(name, material);
		
		setSoundType(SoundType.METAL);
		setHardness(5.0f);
		setResistance(20.0f);
		setHarvestLevel("pickaxe", 1);
		//setLightLevel(1f);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}
	
}
