package io.github.nagol2003.celestial.planets.polulos;

import java.util.LinkedList;
import java.util.List;

import io.github.nagol2003.celestial.AddonCelestialBodies;
import io.github.nagol2003.celestial.AddonDimensions;
import io.github.nagol2003.celestial.planets.WorldProviderAddonPlanet;
import io.github.nagol2003.celestial.planets.polulos.biome.BiomeProviderPolulos;
import io.github.nagol2003.celestial.planets.polulos.biome.ChunkProviderPolulos;
import io.github.nagol2003.init.InitBlocks;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeAdaptive;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderPolulos extends WorldProviderAddonPlanet {
	
	public WorldProviderPolulos() {
		this.skyProvider = SkyProviderPolulos.class;
		this.constantSnow = false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getCloudHeight() {
		return 400.0F;
	}
	
    @Override
    public Vector3 getSkyColor() {
        return new Vector3(1, .25, 0);
    }

    @Override
    public float getSolarSize() {
        return 0.1F;
    }

    @Override
    public long getDayLength() {
        return 10000L;
    }

    @Override
    public Class<? extends IChunkGenerator> getChunkProviderClass() {
        return ChunkProviderPolulos.class;
    }

    @Override
    public Class<? extends BiomeProvider> getBiomeProviderClass() {
        BiomeAdaptive.setBodyMultiBiome(AddonCelestialBodies.Polulos);
        return BiomeProviderPolulos.class;
    }

    @Override
    public float getGravity() {
        return 0.015F;
    }

    @Override
    public int getHeight() {
        return 512;
    }

    @Override
    public double getMeteorFrequency() {
        return 9.0D;
    }

    @Override
    public double getFuelUsageMultiplier() {
        return 1.2D;
    }

    @Override
    public boolean canSpaceshipTierPass(int tier) {
        return tier >=9;
    }

    @Override
    public float getFallDamageModifier() {
        return 0.38F;

    }

    @Override
    public CelestialBody getCelestialBody() {
        return AddonCelestialBodies.Polulos;
    }

    @Override
    public float getThermalLevelModifier() {
        return -0.8F;
    }

    @Override
    public double getSolarEnergyMultiplier() {
        return 3.5D;
    }

    @Override
    public DimensionType getDimensionType() {
        return AddonDimensions.dimPolulos;
    }

    @Override
    public int getDungeonSpacing() {
        return 0;
    }

    @Override
    public ResourceLocation getDungeonChestType() {
        return null;
    }

    @Override
    public List<Block> getSurfaceBlocks() {
        List<Block> list = new LinkedList<>();
        list.add(InitBlocks.DENIASTONE);
        list.add(Blocks.COBBLESTONE_WALL);
        list.add(Blocks.MOSSY_COBBLESTONE);
        list.add(Blocks.GRAVEL);
        return list;
    }

    @Override
    public Vector3 getFogColor() {
        return new Vector3(1, .25, 0);
    }
    
    public int getCloudColor() {
    	return 0;
    }

}