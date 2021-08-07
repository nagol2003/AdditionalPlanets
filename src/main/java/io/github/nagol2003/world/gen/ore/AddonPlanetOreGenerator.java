package io.github.nagol2003.world.gen.ore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class AddonPlanetOreGenerator implements IWorldGenerator {

	private final List<WorldGenerator> generators = new ArrayList<>();

	public AddonPlanetOreGenerator(WorldGenerator generator) {
		this.generators.add(generator);
	}

	public AddonPlanetOreGenerator(WorldGenerator... generators) {
		this.generators.addAll(Lists.newArrayList(generators));
	}

	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z,
			int chancesToSpawn, int minHeight, int maxHeight) {
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i++) {
			int x = chunk_X * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunk_Z * 16 + rand.nextInt(16);
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		generators.forEach(generator -> {
			if(generator instanceof WorldGenMineableOres) {
				WorldGenMineableOres oreGen = (WorldGenMineableOres) generator;
				runGenerator(oreGen, world, random, chunkX, chunkZ, oreGen.veinsPerChunk, oreGen.minY, oreGen.maxY);
			}
		});
	}
}
