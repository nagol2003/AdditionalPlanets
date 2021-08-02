package io.github.nagol2003.world.decorator;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenerator;

public abstract class BiomeDecoratorAP extends BiomeDecorator {

	@Override
	protected void genDecorations(Biome biome, World world, Random rand)
	{
		this.generate(biome, world, rand);
	}

	public void generateOre(WorldGenerator generator, int blockCount, int minHeight, int maxHeight, World world, Random rand)
	{
		if (maxHeight < minHeight)
		{
			int i = minHeight;
			minHeight = maxHeight;
			maxHeight = i;
		}
		else if (maxHeight == minHeight)
		{
			if (minHeight < 255)
			{
				++maxHeight;
			}
			else
			{
				--minHeight;
			}
		}

		for (int j = 0; j < blockCount; ++j)
		{
			BlockPos blockpos = this.chunkPos.add(rand.nextInt(16), rand.nextInt(maxHeight - minHeight) + minHeight, rand.nextInt(16));
			generator.generate(world, rand, blockpos);
		}
	}

	protected abstract void generate(Biome biome, World world, Random rand);
}
