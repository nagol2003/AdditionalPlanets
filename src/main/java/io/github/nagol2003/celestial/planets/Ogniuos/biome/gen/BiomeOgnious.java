package io.github.nagol2003.celestial.planets.Ogniuos.biome.gen;

import io.github.nagol2003.celestial.planets.Ogniuos.biome.OgniousBiomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

public class BiomeOgnious extends OgniousBiomes {

	public BiomeOgnious(BiomeProperties properties) {
		super(properties);
        this.topBlock = Blocks.GRASS.getDefaultState(); //TODO change this
        this.fillerBlock = Blocks.STONE.getDefaultState(); //TODO change this
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
	}

	@Override
	public void registerTypes(Biome b) {
            BiomeDictionary.addTypes(b, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);

	}
}
