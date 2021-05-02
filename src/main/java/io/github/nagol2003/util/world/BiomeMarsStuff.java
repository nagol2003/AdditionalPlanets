package io.github.nagol2003.util.world;

import java.util.Random;

import io.github.nagol2003.init.InitBlocks;
import micdoodle8.mods.galacticraft.api.prefab.core.BlockMetaPair;
import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import micdoodle8.mods.galacticraft.planets.mars.world.gen.BiomeGenFlatMars;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeMarsStuff extends BiomeGenBaseGC
{
    //public static final Biome marsFlat = new BiomeGenFlatMars(new BiomeProperties("Mars Flat").setBaseHeight(2.5F).setHeightVariation(0.4F).setRainfall(0.0F).setRainDisabled());

    public static final BlockMetaPair BLOCK_TOP = new BlockMetaPair(InitBlocks.POLULOSDIRT, (byte) 5);
    public static final BlockMetaPair BLOCK_FILL = new BlockMetaPair(InitBlocks.POLULOSROCK, (byte) 6);
    public static final BlockMetaPair BLOCK_LOWER = new BlockMetaPair(InitBlocks.POLULOSROCK, (byte) 9);

    @SuppressWarnings("unchecked")
    BiomeMarsStuff(BiomeProperties properties)
    {
        super(properties, true);
    }

    @Override
    public float getSpawningChance()
    {
        return 0.01F;
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {
        this.fillerBlock = BLOCK_LOWER.getBlockState();
        this.topBlock = BLOCK_TOP.getBlockState();
        super.genTerrainBlocks(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }
}
