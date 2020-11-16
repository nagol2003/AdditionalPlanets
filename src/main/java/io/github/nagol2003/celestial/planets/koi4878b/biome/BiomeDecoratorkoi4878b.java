package io.github.nagol2003.celestial.planets.koi4878b.biome;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import net.minecraft.world.World;

public class BiomeDecoratorkoi4878b extends BiomeDecoratorSpace {

    private World currentWorld;


    public BiomeDecoratorkoi4878b() {
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
