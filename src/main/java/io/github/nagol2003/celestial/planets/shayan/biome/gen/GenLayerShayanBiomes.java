package io.github.nagol2003.celestial.planets.shayan.biome.gen;

import io.github.nagol2003.celestial.Planets;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeAdaptive;
import micdoodle8.mods.miccore.IntCache;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerShayanBiomes extends GenLayer {

    private static final Biome[] biomes = BiomeAdaptive.getBiomesListFor(Planets.Shayan).toArray(new Biome[0]);

    public GenLayerShayanBiomes(long l, GenLayer parent) {
        super(l);
        this.parent = parent;
    }

    public GenLayerShayanBiomes(long l) {
        super(l);
    }

    @Override
    public int[] getInts(int x, int z, int width, int depth) {
        int[] dest = IntCache.getIntCache(width * depth);

        for (int k = 0; k < depth; ++k) {
            for (int i = 0; i < width; ++i) {
                initChunkSeed(x + i, z + k);
                dest[i + k * width] = Biome.getIdForBiome(biomes[nextInt(biomes.length)]);
            }
        }

        return dest;
    }
}