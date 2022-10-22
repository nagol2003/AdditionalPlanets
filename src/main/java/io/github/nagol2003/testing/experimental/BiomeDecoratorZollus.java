/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package io.github.nagol2003.testing.experimental;

import java.util.Random;

import io.github.nagol2003.init.InitBlocks;
import io.github.nagol2003.util.world.biome.BiomeSpace;
import net.minecraft.block.Block;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDecoratorZollus extends BiomeDecoratorZG {
	
	private static final Block COBBLE = InitBlocks.POLULOSROCK;
	private static final Block ROCK_BRICKS = InitBlocks.POLULOSROCK;
	private static final Block STONE = InitBlocks.POLULOSROCK;
	
	private WorldGenerator dirtGen;
	private WorldGenerator packedIceGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator tinGen;
	private WorldGenerator copperGen;
	private WorldGenerator heartiumGen;
	private WorldGenerator coalGen;
	
	public int zolCrystalsPerChunk = 2;
	public int tunnelsPerChunk = 3;
	public int cratersPerChunk = 6;
	public int battleTowersPerChunk = 2;
	
	public boolean generateCrystals = true;
	public boolean generateIceSpikes = true;
	public boolean generateTunnels = true;
	public boolean generateTallGrass = false;
	public boolean generateCraters = true;
	public boolean generateBattleTowers = true;
	
	private WorldGenerator battleTowerGen = new WorldGenBattleTower(COBBLE.getDefaultState(), ROCK_BRICKS.getDefaultState());
	
	public BiomeDecoratorZollus() {
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		ChunkPos forgeChunkPos = new ChunkPos(this.chunkPos);
		
		int genY = 128;
		int y = genY;
		
		if (biome instanceof BiomeSpace) {
			BiomeSpace spaceBiome = (BiomeSpace) biome;
			genY = spaceBiome.getBiomeHeight();
		}
		
		
		// Battle Towers
		if (this.generateBattleTowers && this.battleTowersPerChunk > 0) {
			 
				for (int i = 0; i < this.battleTowersPerChunk; ++i) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					if (y >= 60 && y < 80) {
						this.battleTowerGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			
		}
		
	}
}