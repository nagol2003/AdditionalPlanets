package io.github.nagol2003.celestial.planets.ognious.biome;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import io.github.nagol2003.init.InitBlocks;
import io.github.nagol2003.util.world.MapGenAddonCaveGen;
import io.github.nagol2003.util.world.MapGenAddonRavinGen;
import io.github.nagol2003.util.world.MapGenBaseMeta;
import io.github.nagol2003.world.chunk.ChunkProviderClassicFlat;
import io.github.nagol2003.world.chunk.ChunkProviderMultiBiome;
import io.github.nagol2003.world.gen.ore.AddonPlanetOreGenerator;
import io.github.nagol2003.world.gen.ore.WorldGenMineableOres;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;

public class ChunkProviderOgnious extends ChunkProviderClassicFlat {

	private final MapGenAddonRavinGen ravineGenerator = new MapGenAddonRavinGen();
	private final MapGenAddonCaveGen caveGenerator = new MapGenAddonCaveGen(Blocks.DIAMOND_BLOCK.getDefaultState(), Blocks.LAVA.getDefaultState(),
			Sets.newHashSet(Blocks.HARDENED_CLAY, Blocks.BLACK_GLAZED_TERRACOTTA));

	private static IBlockState stoneBlockState = InitBlocks.OGNIOUSSTONE.getDefaultState();

	// Example Ore Generators
	private WorldGenerator ore1 = new WorldGenMineableOres(InitBlocks.DENIAFERMINIUMORE, 20, 18, 5, 120, stoneBlockState, InitBlocks.OGNIOUSROCK.getDefaultState());
	private WorldGenerator ore2 = new WorldGenMineableOres(Blocks.IRON_ORE, 25, 9, 20, 70, stoneBlockState, InitBlocks.OGNIOUSROCK.getDefaultState());


	public ChunkProviderOgnious(World par1World, long seed, boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);
		this.stoneBlock = stoneBlockState;
		this.waterBlock = Blocks.WATER.getDefaultState();
	}

	@Override
	protected AddonPlanetOreGenerator getOreGenerator() {
		return new AddonPlanetOreGenerator(ore1, ore2);
	}

	@Override
	protected List<MapGenBaseMeta> getWorldGenerators() {
		List<MapGenBaseMeta> generators = Lists.newArrayList();
		generators.add(this.caveGenerator);
		return generators;
	}

	@Override
	public void onChunkProvide(int cX, int cZ, ChunkPrimer primer) {
		this.ravineGenerator.generate(this.worldObj, cX, cZ, primer);
	}

	@Override
	public void recreateStructures(Chunk chunk, int x, int z) {
	}

	@Override
	protected void decoratePlanet(World world, Random rand, int x, int z) {
	}

	public static IBlockState getStoneBlockState() {

		return stoneBlockState;
	}
}