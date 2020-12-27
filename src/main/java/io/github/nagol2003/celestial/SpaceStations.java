package io.github.nagol2003.celestial;

import io.github.nagol2003.AddonConfig;
import io.github.nagol2003.AddonConfig.SpaceStationSettings;
import io.github.nagol2003.celestial.planets.Polulos.station.APSatTeleportType;
import io.github.nagol2003.celestial.planets.Polulos.station.WorldProviderPolulosOrbit;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Satellite;
import micdoodle8.mods.galacticraft.core.world.gen.BiomeOrbit;
import net.minecraft.util.ResourceLocation;

public class SpaceStations {

	public static Satellite polulosOrbit;
	static SpaceStationSettings satDim = AddonConfig.addon_spacestation_settings;
	
	public SpaceStations() {
		registerAll();
	}
	
	private static void registerAll() {
		
		polulosOrbit = new Satellite("space_station.polulos").setParentBody(Planets.polulos);
		polulosOrbit.setRelativeSize(0.2667F);
		polulosOrbit.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
		polulosOrbit.setRelativeOrbitTime(20.0F);
		polulosOrbit.setTierRequired(Planets.polulos.getTierRequirement());
		polulosOrbit.setDimensionInfo(satDim.polulosOrbitDimID, satDim.polulosOrbitDimID_static, WorldProviderPolulosOrbit.class);
		polulosOrbit.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/space_station.png"));
		polulosOrbit.addChecklistKeys("equip_oxygen_suit");
		polulosOrbit.setBiomeInfo(BiomeOrbit.space);
		GalacticraftRegistry.registerTeleportType(WorldProviderPolulosOrbit.class, new APSatTeleportType());
		GalaxyRegistry.registerSatellite(polulosOrbit);
	}
	
}
