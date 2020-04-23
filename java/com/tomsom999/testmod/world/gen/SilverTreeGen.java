package com.tomsom999.testmod.world.gen;

import java.util.ArrayList;
import java.util.Random;

import com.mojang.realmsclient.dto.RealmsServer.WorldType;
import com.tomsom999.testmod.world.feature.tree.WorldGenSilverTree;

import net.minecraft.block.Block;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;
import scala.actors.threadpool.Arrays;

public class SilverTreeGen implements IWorldGenerator
{
	private final WorldGenerator SILVER = new WorldGenSilverTree();
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.getDimension())
		{
		case 1: 
			
			break;
		case 0: 
			runGenerator(SILVER, world, random, chunkX, chunkZ, 3, -1, 0, BiomePlains.class);
			
			break;
			
		case -1:
			
		}
	}
	
	private void runGenerator (WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, double chancesToSpawn, int minHeight, int MaxHeight, Class<?>... classes)
	{
		if(chancesToSpawn < 1)
		{
			if(random.nextDouble() < chancesToSpawn) chancesToSpawn = 1;
		}
		
		ArrayList<Class<?>> classeslist = new ArrayList<Class<?>>(Arrays.asList(classes));
		int heightDiff = MaxHeight - minHeight +1;
		
		for(int i = 0; i < chancesToSpawn; i++)
		{
			BlockPos pos = new BlockPos(chunkX * 16 + 10 + random.nextInt(15),  minHeight + random.nextInt(heightDiff), chunkZ * 16 + 10 + random.nextInt(15));
			if(minHeight < 0)pos = world.getHeight(pos);
			Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
			if(classeslist.contains(biome)|| classes.length == 0) generator.generate(world, random, pos);  
		}
	}
}