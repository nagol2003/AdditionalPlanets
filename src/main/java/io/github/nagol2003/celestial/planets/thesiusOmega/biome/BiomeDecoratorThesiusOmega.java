package io.github.nagol2003.celestial.planets.thesiusOmega.biome;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import net.minecraft.world.World;

public class BiomeDecoratorThesiusOmega extends BiomeDecoratorSpace {

    private World currentWorld;


    public BiomeDecoratorThesiusOmega() {
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
