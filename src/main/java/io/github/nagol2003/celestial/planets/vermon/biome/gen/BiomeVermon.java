package io.github.nagol2003.celestial.planets.vermon.biome.gen;

import java.util.Random;

import io.github.nagol2003.celestial.planets.vermon.biome.BiomeDecoratorVermon;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeVermon extends BiomeGenBaseGC
{
    public static final Biome Vermon = new BiomeVermon(new BiomeProperties("Vermon2").setBaseHeight(1.5F).setHeightVariation(0.4F).setRainfall(0.0F));

    public BiomeVermon(BiomeProperties properties)
    {
        super(properties, true);
    }

   // @Override
   // public BiomeDecorator createBiomeDecorator()
  //  {
   //     return getModdedBiomeDecorator(new BiomeDecoratorVermon());
   // }

    @Override
    public float getSpawningChance()
    {
        return 0.1F;
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {
        super.genTerrainBlocks(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }
}