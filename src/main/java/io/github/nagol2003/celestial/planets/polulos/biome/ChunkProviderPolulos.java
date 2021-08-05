package io.github.nagol2003.celestial.planets.polulos.biome;

import com.google.common.collect.Lists;

import io.github.nagol2003.util.world.BiomeMarsStuff;
import io.github.nagol2003.util.world.chunk.ChunkProviderSpaceYes;
import micdoodle8.mods.galacticraft.api.prefab.core.BlockMetaPair;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeAdaptive;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.ChunkProviderSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import micdoodle8.mods.galacticraft.planets.mars.blocks.BlockBasicMars;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import micdoodle8.mods.galacticraft.planets.mars.world.gen.BiomeMars;
import micdoodle8.mods.galacticraft.planets.mars.world.gen.MapGenCaveMars;
import micdoodle8.mods.galacticraft.planets.mars.world.gen.MapGenCavernMars;
import micdoodle8.mods.galacticraft.planets.mars.world.gen.MapGenDungeonMars;
import micdoodle8.mods.galacticraft.planets.mars.world.gen.RoomBossMars;
import micdoodle8.mods.galacticraft.planets.mars.world.gen.RoomTreasureMars;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;

import java.util.List;

public class ChunkProviderPolulos extends ChunkProviderSpaceYes
{
    private final BiomeDecoratorPolulos marsBiomeDecorator = new BiomeDecoratorPolulos();
    private final MapGenCavernMars caveGenerator = new MapGenCavernMars();
    private final MapGenCaveMars cavernGenerator = new MapGenCaveMars(); 

   // private final MapGenDungeon dungeonGenerator = new MapGenDungeonMars(new DungeonConfiguration(MarsBlocks.marsBlock.getDefaultState().withProperty(BlockBasicMars.BASIC_TYPE, BlockBasicMars.EnumBlockBasic.DUNGEON_BRICK), 30, 8, 16, 7, 7, RoomBossMars.class, RoomTreasureMars.class));

    public ChunkProviderPolulos(World par1World, long seed, boolean mapFeaturesEnabled)
    {
        super(par1World, seed, mapFeaturesEnabled);
    }

    @Override
    protected BiomeDecoratorSpace getBiomeGenerator()
    {
        return this.marsBiomeDecorator;
    }

    @Override
    protected Biome[] getBiomesForGeneration()
    {
        return new Biome[] { BiomeAdaptive.biomeDefault };
    }

    @Override
    protected int getSeaLevel()
    {
        return 93;
    }

    @Override
    protected List<io.github.nagol2003.celestial.planets.ognious.biome.MapGenBaseMeta> getWorldGenerators()
    {
        List<io.github.nagol2003.celestial.planets.ognious.biome.MapGenBaseMeta> generators = Lists.newArrayList();
       // generators.add(this.caveGenerator);
       // generators.add(this.cavernGenerator);
        return generators;
    }

    @Override
    protected BlockMetaPair getGrassBlock()
    {
        return BiomeMarsStuff.BLOCK_TOP;
    }

    @Override
    protected BlockMetaPair getDirtBlock()
    {
        return BiomeMarsStuff.BLOCK_FILL;
    }

    @Override
    protected BlockMetaPair getStoneBlock()
    {
        return BiomeMarsStuff.BLOCK_LOWER;
    }

    @Override
    public double getHeightModifier()
    {
        return 24;
    }

    @Override
    public double getSmallFeatureHeightModifier()
    {
        return 26;
    }

    @Override
    public double getMountainHeightModifier()
    {
        return 150;
    }

    @Override
    public double getValleyHeightModifier()
    {
        return 150;
    }

    @Override
    public int getCraterProbability()
    {
        return 2000;
    }

    @Override
    public void onChunkProvide(int cX, int cZ, ChunkPrimer primer)
    {
    //    this.dungeonGenerator.generate(this.world, cX, cZ, primer);
    }

    @Override
    public void onPopulate(int cX, int cZ)
    {
      //  this.dungeonGenerator.generateStructure(this.world, this.rand, new ChunkPos(cX, cZ));
    }

    @Override
    public void recreateStructures(Chunk chunk, int x, int z)
    {
    //    this.dungeonGenerator.generate(this.world, x, z, null);
    }
}