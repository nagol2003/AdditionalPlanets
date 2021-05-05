package io.github.nagol2003.world;

import java.util.ArrayList;
import java.util.Random;

import io.github.nagol2003.celestial.planets.Ognious.biome.gen.BiomeOgnious;
import io.github.nagol2003.celestial.planets.denia.biome.gen.BiomeDenia;
import io.github.nagol2003.init.InitBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeDesert;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import scala.actors.threadpool.Arrays;

public class WorldGenCustomStructures implements IWorldGenerator
{
	public static final WorldGenStructure HOME = new WorldGenStructure("home");
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		System.out.println("XDDD:" + world.provider.getDimension());
		System.out.println("XDDD:" + world.provider.getDimension());
		System.out.println("XDDD:" + world.provider.getDimension());
		System.out.println("XDDD:" + world.provider.getDimension());
		System.out.println("XDDD:" + world.provider.getDimension());
		System.out.println("XDDD:" + world.provider.getDimension());
		System.out.println("XDDD:" + world.provider.getDimension());
		System.out.println("XDDD:" + world.provider.getDimension());
		System.out.println("XDDD:" + world.provider.getDimension());
		System.out.println("XDDD:" + world.provider.getDimension());
		System.out.println("XDDD:" + world.provider.getDimension());
		System.out.println("XDDD:" + world.provider.getDimension());
		switch(world.provider.getDimension())
		{
		//case 2 is custom dimension
		case 2:
			System.out.println("case: 2");
			System.out.println("case: 2");
			System.out.println("case: 2");
			System.out.println("case: 2");
			System.out.println("case: 2");
			System.out.println("case: 2");
			System.out.println("case: 2");
			System.out.println("case: 2");
			System.out.println("case: 2");
			System.out.println("case: 2");
			generateStructure(HOME, world, random, chunkX, chunkZ, 25, InitBlocks.FROZENCO2, BiomeDenia.class);
			
			break;
			
		case 1:
			System.out.println("case: 1");
			System.out.println("case: 1");
			System.out.println("case: 1");
			System.out.println("case: 1");
			System.out.println("case: 1");
			System.out.println("case: 1");
			System.out.println("case: 1");
			System.out.println("case: 1");
			System.out.println("case: 1");
			System.out.println("case: 1");
			System.out.println("case: 1");
			System.out.println("case: 1");
			System.out.println("case: 1");
			break;
			//case 0 is overworld; cases refer to dimensions
		case 0:
			System.out.println("case: 0");
			System.out.println("case: 0");
			System.out.println("case: 0");
			System.out.println("case: 0");
			System.out.println("case: 0");
			System.out.println("case: 0");
			System.out.println("case: 0");
			System.out.println("case: 0");
			System.out.println("case: 0");
			System.out.println("case: 0");
			System.out.println("case: 0");
			System.out.println("case: 0");
			System.out.println("case: 0");
			System.out.println("case: 0");
			generateStructure(HOME, world, random, chunkX, chunkZ, 25, Blocks.GRASS, BiomePlains.class);
			break;
			
		case -1:
			System.out.println("case: -1");
			System.out.println("case: -1");
			System.out.println("case: -1");
			System.out.println("case: -1");
			System.out.println("case: -1");
			System.out.println("case: -1");
			System.out.println("case: -1");
			System.out.println("case: -1");
			System.out.println("case: -1");
			System.out.println("case: -1");
			System.out.println("case: -1");
			System.out.println("case: -1");
			System.out.println("case: -1");
			break;
		}
	}
	
	private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes)
	{
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));
		
		int x = (chunkX * 16) + random.nextInt(15);
		int z = (chunkZ * 16) + random.nextInt(15);
		int y = calculateGenerationHeight(world, x, z, topBlock);
		BlockPos pos = new BlockPos(x,y,z);
		
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		
		if(world.getWorldType() != WorldType.FLAT)
		{
			if(classesList.contains(biome))
			{
				if(random.nextInt(chance) == 0)
				{
					generator.generate(world, random, pos);
				}
			}
		}
	}
	
	private static int calculateGenerationHeight(World world, int x, int z, Block topBlock)
	{
		int y = world.getHeight();
		boolean foundGround = false;
		
		while(!foundGround && y-- >= 0)
		{
			Block block = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundGround = block == topBlock;
		}
		
		return y;
	}
}