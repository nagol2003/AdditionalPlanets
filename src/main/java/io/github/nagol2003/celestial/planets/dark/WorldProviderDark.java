package io.github.nagol2003.celestial.planets.dark;

import java.util.LinkedList;
import java.util.List;

import io.github.nagol2003.celestial.Dimensions;
import io.github.nagol2003.celestial.Planets;
import io.github.nagol2003.celestial.planets.dark.biome.BiomeProviderDark;
import io.github.nagol2003.celestial.planets.dark.biome.ChunkProviderDark;
import io.github.nagol2003.init.InitBlocks;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeAdaptive;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldProviderDark extends WorldProviderSpace implements ISolarLevel {

    @Override
    public Vector3 getSkyColor() {
        return new Vector3(1, .2, .1);
    }

    @Override
    public float getSolarSize() {
        return 0.1F;
    }

    @Override
    public boolean hasSunset() {
        return false;
    }

    @Override
    public long getDayLength() {
        return 35000L;
    }

    @Override
    public Class<? extends IChunkGenerator> getChunkProviderClass() {
        return ChunkProviderDark.class;
    }

    @Override
    public Class<? extends BiomeProvider> getBiomeProviderClass() {
        BiomeAdaptive.setBodyMultiBiome(Planets.Dark);
        return BiomeProviderDark.class;
    }

    @Override
    public double getHorizon() {
        return 44.0D;
    }

    @Override
    public int getAverageGroundLevel() {
        return 44;
    }

    @Override
    public boolean canCoordinateBeSpawn(int var1, int var2) {
        return true;
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
        return tier >=3;
    }

    @Override
    public float getFallDamageModifier() {
        return 0.38F;

    }

    @Override
    public CelestialBody getCelestialBody() {
        return Planets.Dark;
    }

    @Override
    public float getThermalLevelModifier() {
        return 5.0F;
    }

    @Override
    public double getSolarEnergyMultiplier() {
        return 3.5D;
    }

    @Override
    public DimensionType getDimensionType() {
        return Dimensions.dimDark;
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
        list.add(InitBlocks.POLULOSROCK);
        list.add(Blocks.COBBLESTONE_WALL);
        list.add(Blocks.MOSSY_COBBLESTONE);
        list.add(Blocks.GRAVEL);
        return list;
    }

    @Override
    public Vector3 getFogColor() {
        return new Vector3(1, .3, .3);
    }
    
    public int getCloudColor() {
    	return 0;
    }
}
