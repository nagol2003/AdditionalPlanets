package io.github.nagol2003.util;

import net.minecraft.world.biome.Biome;

public abstract class BiomeBase extends Biome {

	public BiomeBase(BiomeProperties properties) {
		super(properties);
	}

	public void registerTypes() {
	}

}
