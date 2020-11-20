package io.github.nagol2003.celestial.moons.ammon.biome;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import net.minecraft.world.World;

public class BiomeDecoratorAmmon extends BiomeDecoratorSpace {

    private World currentWorld;


    public BiomeDecoratorAmmon() {
    }

    @Override
    protected void setCurrentWorld(World world) {
        this.currentWorld = world;
    }

    @Override
    protected World getCurrentWorld() {
        return this.currentWorld;
    }

    @Override
    protected void decorate() {
    }
}
