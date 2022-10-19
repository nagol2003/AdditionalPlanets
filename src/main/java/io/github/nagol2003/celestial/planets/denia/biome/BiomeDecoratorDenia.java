package io.github.nagol2003.celestial.planets.denia.biome;

import java.util.Random;

import io.github.nagol2003.AddonMain;
import io.github.nagol2003.init.InitBlocks;
import io.github.nagol2003.world.gen.tree.APGenTestTree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;

public class BiomeDecoratorDenia extends BiomeDecorator {
	
	public int testTreePerChunk;

	private boolean isDecorating = false;

	@Override
	protected void genDecorations(Biome biomeIn, World world, Random random) {
		if (isDecorating) {
			return;
		}
		isDecorating = true;

		AddonMain.LOGGER.info("Trees Allowed Per Chunk: {}", this.treesPerChunk);
		for (int i = 0; i < this.treesPerChunk; i++) {
			if (random.nextInt(50) == 1) {
				BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
				blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
				AddonMain.LOGGER.info("Attempting to Generate Tree at: {}", blockpos.toString());
				//new APGenSempervirens(Blocks.LOG, Blocks.LEAVES).setCanGenerateOnSand().generate(world, random, blockpos);
				new APGenTestTree(InitBlocks.OGNIOUSLOG, InitBlocks.OGNIOUSLEAVES, true).generate(world, random, blockpos);
			}
		}
		isDecorating = false;
	}
}
