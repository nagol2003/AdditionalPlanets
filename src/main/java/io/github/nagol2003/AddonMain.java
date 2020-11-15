package io.github.nagol2003;

import asmodeuscore.core.astronomy.BodiesRegistry;
import io.github.nagol2003.celestial.AddonCelestialBodies;
import io.github.nagol2003.celestial.AddonDimensions;
import io.github.nagol2003.celestial.NewGalaxy;
import io.github.nagol2003.init.InitBlocks;
import io.github.nagol2003.init.InitItems;
import io.github.nagol2003.init.Recipes;
import io.github.nagol2003.proxy.ServerProxy;
import io.github.nagol2003.registry.APRegistry;
import io.github.nagol2003.util.Logging;
import io.github.nagol2003.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
		
		BodiesRegistry.setMaxTier(1);
		NewGalaxy.init();
		AddonCelestialBodies.init();
		
		proxy.preInit(registry, event);
		
	}

	@EventHandler
	public void init(final FMLInitializationEvent event) {
		proxy.init(registry,event);
		Recipes.init();

	}

	@EventHandler
	public void receiveIMC(final IMCEvent event) {
		proxy.receiveIMC(event);
	}

	@EventHandler
	public void postInit(final FMLPostInitializationEvent event) {
		// Register addons dimensions used by planets/moonds/etc.. in postInit
		AddonDimensions.init();
		proxy.postInit(registry,event);
	}
}

//Shift + U is undo
//Control + Y is redo