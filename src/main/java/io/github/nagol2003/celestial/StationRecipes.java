package io.github.nagol2003.celestial;

import java.util.HashMap;

import io.github.nagol2003.AddonConfig;
import io.github.nagol2003.AddonMain;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.SpaceStationRecipe;
import micdoodle8.mods.galacticraft.api.world.SpaceStationType;
import net.minecraft.init.Items;

public class StationRecipes {
	
	public static void register() {
		HashMap<Object, Integer> iMap;
		
		iMap = new HashMap<Object, Integer>();
		iMap.put(Items.DIAMOND, 5);
		iMap.put(Items.IRON_INGOT, 20);
		iMap.put(Items.GLOWSTONE_DUST, 10);
		iMap.put(Items.BED, 2);
		addStationRecipe(AddonConfig.addon_spacestation_settings.polulosOrbitDimID, AddonConfig.addon_dimension.idPolulos, iMap);
	}
	

	private static void addStationRecipe(int spaceStationID, int planetID, HashMap<Object, Integer> obj) {
		SpaceStationType newType = new SpaceStationType(spaceStationID, planetID, new SpaceStationRecipe(obj));
		for (SpaceStationType type1 : GalacticraftRegistry.getSpaceStationData())
        {
            if (type1.getWorldToOrbitID() == newType.getWorldToOrbitID())
            {
            	AddonMain.LOGGER.error("You have a double version of the same space station, station for planet ID: " + newType.getWorldToOrbitID() + " | Instead of crashing the players game and making them restart every damn time. We simply just print this error. Unlike some code we may know");
                //throw new RuntimeException("You have a double version of the same space station, station for planet ID: " + newType.getWorldToOrbitID() + " You will most likely fix this by checking out compatibility guide over at https://docs.mjrlegends.com/ExtraPlanets/1.12.2compact/");
            }
        }
		GalacticraftRegistry.registerSpaceStation(newType);
	}
}
