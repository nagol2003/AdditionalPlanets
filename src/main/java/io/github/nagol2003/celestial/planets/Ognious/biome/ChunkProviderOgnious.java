package io.github.nagol2003.celestial.planets.Ognious.biome;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import io.github.nagol2003.init.InitBlocks;
import io.github.nagol2003.util.world.chunk.ChunkProviderAP;
import io.github.nagol2003.util.world.chunk.MapGenAddonCaveGen;
import io.github.nagol2003.util.world.chunk.MapGenAddonRavinGen;
import io.github.nagol2003.util.world.chunk.MapGenBaseMeta;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;

public class ChunkProviderOgnious extends ChunkProviderAP {

    private final BiomeDecoratorOgnious decorator = new BiomeDecoratorOgnious();
    private final MapGenAddonRavinGen ravineGenerator = new MapGenAddonRavinGen();
    private final MapGenAddonCaveGen caveGenerator = new MapGenAddonCaveGen(Blocks.DIAMOND_BLOCK.getDefaultState(), Blocks.LAVA.getDefaultState(),
            Sets.newHashSet(Blocks.HARDENED_CLAY, Blocks.BLACK_GLAZED_TERRACOTTA));
    
    private static IBlockState stoneBlockState = InitBlocks.OGNIOUSSTONE.getDefaultState();

    public ChunkProviderOgnious(World par1World, long seed, boolean mapFeaturesEnabled) {
        super(par1World, seed, mapFeaturesEnabled);
        this.stoneBlock = stoneBlockState;
        this.waterBlock =Blocks.WATER.getDefaultState();
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