package io.github.nagol2003.celestial.planets.ognious.biome.gen;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public abstract class GenLayerOgnious extends GenLayer {
	public GenLayerOgnious(long l) {
		super(l);
	}

	public static GenLayer[] createWorld(long l) {
		GenLayer biomes = new GenLayerOgniousBiomes(l);
		biomes = new GenLayerZoom(1000L, biomes);
		biomes = new GenLayerZoom(1001L, biomes);
		biomes = new GenLayerZoom(1002L, biomes);
		biomes = new GenLayerZoom(1003L, biomes);
		biomes = new GenLayerZoom(1004L, biomes);
		biomes = new GenLayerZoom(1005L, biomes);
		biomes = new GenLayerZoom(1006L, biomes);
		biomes = new GenLayerZoom(1007L, biomes);
		GenLayer genLayerVeronoiZoom = new GenLayerVoronoiZoom(10L, biomes);
		biomes.initWorldGenSeed(l);
		genLayerVeronoiZoom.initWorldGenSeed(l);

		return new GenLayer[] { biomes, genLayerVeronoiZoom };
	}
}