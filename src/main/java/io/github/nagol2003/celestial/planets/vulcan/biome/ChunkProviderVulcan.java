package io.github.nagol2003.celestial.planets.vulcan.biome;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import io.github.nagol2003.init.InitBlocks;
import io.github.nagol2003.util.world.MapGenAddonCaveGen;
import io.github.nagol2003.util.world.MapGenAddonRavinGen;
import io.github.nagol2003.util.world.MapGenBaseMeta;
import io.github.nagol2003.util.world.chunk.ChunkProviderAP;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;

public class ChunkProviderVulcan extends ChunkProviderAP {

    private final BiomeDecoratorVulcan decorator = new BiomeDecoratorVulcan();
    private final MapGenAddonRavinGen ravineGenerator = new MapGenAddonRavinGen();
    private final MapGenAddonCaveGen caveGenerator = new MapGenAddonCaveGen(Blocks.DIAMOND_BLOCK.getDefaultState(), Blocks.LAVA.getDefaultState(),
            Sets.newHashSet(Blocks.HARDENED_CLAY, Blocks.BLACK_GLAZED_TERRACOTTA));
    
    private static IBlockState stoneBlockState = InitBlocks.VULCANROCKBURNT.getDefaultState();

    public ChunkProviderVulcan(World par1World, long seed, boolean mapFeaturesEnabled) {
        super(par1World, seed, mapFeaturesEnabled);
        this.stoneBlock = stoneBlockState;
        this.waterBlock =Blocks.LAVA.getDefaultState();
        this.seaLevel = 65;
    }

    @Override
    protected List<MapGenBaseMeta> getWorldGenerators() {
        List<MapGenBaseMeta> generators = Lists.newArrayList();
        generators.add(this.caveGenerator);
        return generators;
    }

    @Override
    public int getCraterProbability() {
        return 2000;
    }

    @Override
    public void onChunkProvide(int cX, int cZ, ChunkPrimer primer) {
        this.ravineGenerator.generate(this.worldObj, cX, cZ, primer);
    }

    @Override
    public void onPopulate(int cX, int cZ) {

    }

    @Override
    public void recreateStructures(Chunk chunk, int x, int z) {
    }

    @Override
    protected void decoratePlanet(World world, Random rand, int x, int z) {
        this.decorator.decorate(this.worldObj, rand, x, z);
    }
    
    public static IBlockState getStoneBlockState() {
    	return stoneBlockState;
    }
}