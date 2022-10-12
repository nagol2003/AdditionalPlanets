package io.github.nagol2003;

import asmodeuscore.core.astronomy.BodiesRegistry;
import io.github.nagol2003.celestial.AddonCelestialBodies;
import io.github.nagol2003.celestial.AddonDimensions;
import io.github.nagol2003.celestial.NewGalaxy;
import io.github.nagol2003.init.EntityInit;
//import io.github.nagol2003.celestial.planets.Polulos.biome.gen.PolulosTreeGen;
import io.github.nagol2003.init.InitBlocks;
import io.github.nagol2003.init.InitItems;
import io.github.nagol2003.init.Recipes;
import io.github.nagol2003.proxy.ServerProxy;
import io.github.nagol2003.registry.APRegistry;
import io.github.nagol2003.testing.CommandPlanetTeleportTwo;

import io.github.nagol2003.util.Logging;
import io.github.nagol2003.util.Utils;
import io.github.nagol2003.util.handlers.RenderHandler;
import io.github.nagol2003.util.handlers.SoundsHandler;
import io.github.nagol2003.world.APWorldGen;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
//import io.github.nagol2003.world.WorldGenCustomStructures;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Const.modID,
	 name = Const.modName,
	 version = Const.modVersion,
	 dependencies = Const.DEPENDENCIES_FORGE + Const.DEPENDENCIES_MODS,
     certificateFingerprint = Const.CERTIFICATEFINGERPRINT)
public class AddonMain {

	public static final Logging LOGGER = new Logging(Const.modID);
	public static final AddonMain INSTANCE = new AddonMain();
	public static APRegistry registry = new APRegistry();

	@SidedProxy(clientSide = "io.github.nagol2003.proxy.ClientProxy", serverSide = "io.github.nagol2003.proxy.ServerProxy")
	private static ServerProxy proxy;

    static
    {
        FluidRegistry.enableUniversalBucket();
    }
   
   
   
    
	@EventHandler
	public static void onFingerprintViolation(final FMLFingerprintViolationEvent event) {
		if (!Utils.isDeobfuscated()) {
			// This complains if jar not signed, even if certificateFingerprint is blank
			// But only when not in our Development Environment
			LOGGER.warn("Invalid Fingerprint");
		}
	}
	
	
	
	
	@EventHandler
	public void preInit(final FMLPreInitializationEvent event) {
		// Sets the Registry object to this mods class
		registry.setMod(this);

		// add the registerAll method in our InitBlocks class to the registry
		registry.addRegistrationHandler(InitBlocks::registerAll, Block.class);
		registry.addRegistrationHandler(InitItems::registerAll, Item.class);
		registry.addRegistrationHandler(EntityInit::registerEntities, EntityEntry.class);
		//GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);

		BodiesRegistry.setMaxTier(1);
		NewGalaxy.init();
		AddonCelestialBodies.init();


		proxy.preInit(registry, event);

		GameRegistry.registerWorldGenerator(new APWorldGen(), 3);

		//GameRegistry.registerWorldGenerator(new PolulosWorldGen(), -4440);

		RenderHandler.registerEntityRenders();
	}
	
	
	@EventHandler
	public void init(final FMLInitializationEvent event) {
		proxy.init(registry,event);
		Recipes.init();
		SoundsHandler.registerSounds();
		Recipes.compressor();
		Recipes.compressor2();
		//Recipes.compressor3();
		
	}

	
	
	@EventHandler
	public void receiveIMC(final IMCEvent event) {
		proxy.receiveIMC(event);
	}

	@EventHandler
	public void postInit(final FMLPostInitializationEvent event) {
		// Register addons dimensions used by planets/moonds/etc.. in postInit
		AddonDimensions.init();
		//PolulosTreeGen.register();
		proxy.postInit(registry,event);
	}
	
	@EventHandler
    public void onServerStarting(FMLServerStartingEvent event) {
    

        event.registerServerCommand(new CommandPlanetTeleportTwo());
    }

}


//Shift + U is undo
//Control + Y is redo
//35 bodies