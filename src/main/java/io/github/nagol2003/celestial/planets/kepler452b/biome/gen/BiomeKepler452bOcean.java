package io.github.nagol2003.celestial.planets.kepler452b.biome.gen;

import java.util.Random;

import io.github.nagol2003.celestial.planets.kepler452b.biome.ChunkProviderKepler452b;
import io.github.nagol2003.celestial.planets.kepler452b.biome.Kepler452bBiomes;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraftforge.common.BiomeDictionary;

public class BiomeKepler452bOcean extends Kepler452bBiomes {

	public BiomeKepler452bOcean(BiomeProperties properties) {
		super(properties);
        this.topBlock = Blocks.DIRT.getDefaultState(); //TODO change this
        this.fillerBlock = Blocks.SAND.getDefaultState(); //TODO change this
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
	}

	@Override
	public void registerTypes(Biome b) {
            BiomeDictionary.addTypes(b, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);

	}
	@Override
	public void generateBiomeSurface(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z,
			double noiseVal) {
		int i = worldIn.getSeaLevel();
		IBlockState stoneBlockState = ChunkProviderKepler452b.getStoneBlockState();
		IBlockState topState = this.topBlock;
		IBlockState fillState = this.fillerBlock;
		int j = -1;
		int k = (int) ((noiseVal / 3.0D) + 3.0D + (rand.nextDouble() * 0.45D));
		int l = x & 15;
		int i1 = z & 15;

		for (int j1 = 255; j1 >= 0; --j1) {
			if (j1 == 0) {
				chunkPrimerIn.setBlockState(i1, j1, l, BEDROCK);
			} else {
				IBlockState iblockstate2 = chunkPrimerIn.getBlockState(i1, j1, l);

				if (iblockstate2.getMaterial() == Material.AIR) {
					j = -1;
				} else if (iblockstate2.getBlock() == stoneBlockState.getBlock()) {
					if (j == -1) {
						if (k <= 0) {
							topState = AIR;
							fillState = STONE;
						} else if ((j1 >= (i - 4)) && (j1 <= (i + 1))) {
							topState = this.topBlock;
							fillState = this.fillerBlock;
						}

						if ((j1 < i) && ((topState == null) || (topState.getMaterial() == Material.AIR))) {
							topState = ICE;
						}

						j = k;

						if (j1 >= (i - 1)) {
							chunkPrimerIn.setBlockState(i1, j1, l, topState);
						} else if (j1 < (i - 7 - k)) {
							topState = AIR;
							fillState = STONE;
							chunkPrimerIn.setBlockState(i1, j1, l, GRAVEL);
						} else {
							chunkPrimerIn.setBlockState(i1, j1, l, fillState);
						}
					} else if (j > 0) {
						--j;
						chunkPrimerIn.setBlockState(i1, j1, l, fillState);
					}
				}
			}
		}
	}
}