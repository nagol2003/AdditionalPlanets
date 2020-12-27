package io.github.nagol2003.celestial;

import io.github.nagol2003.AddonConfig;
import io.github.nagol2003.AddonConfig.Dimension;
import io.github.nagol2003.Const;
import io.github.nagol2003.celestial.planets.Ognious.WorldProviderOgnious;
import io.github.nagol2003.celestial.planets.Ognious.biome.OgniousBiomes;
import io.github.nagol2003.celestial.planets.Polulos.WorldProviderPolulos;
import io.github.nagol2003.celestial.planets.Polulos.biome.PolulosBiomes;
import io.github.nagol2003.celestial.planets.denia.WorldProviderDenia;
import io.github.nagol2003.celestial.planets.denia.biome.DeniaBiomes;
import io.github.nagol2003.celestial.planets.vulcan.WorldProviderVulcan;
import io.github.nagol2003.celestial.planets.vulcan.biome.VulcanBiomes;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.world.AtmosphereInfo;
import micdoodle8.mods.galacticraft.api.world.EnumAtmosphericGas;
import micdoodle8.mods.galacticraft.core.dimension.TeleportTypeMoon;
import net.minecraft.util.ResourceLocation;

public class Planets {
	
	public static Planet ognious;
	public static Planet polulos;
	public static Planet denia;
	public static Planet vulcan;

	public static Planet ProximaCentauriB;
	public static Planet ZakirPrime;
	public static Planet AlphaCentauriV;
	public static Planet AlphaCentaurfour;
	public static Planet AlphaCentaurone;
	public static Planet AlphaCentaurtwo;
	public static Planet unknownplanet;
	public static Planet mother;
	public static Planet Shayan;
	public static Planet Queran;
	public static Planet Vermon;
	public static Planet Dark;
	public static Planet Kepler452b;
	public static Planet J1407b;
	public static Planet BarbanI;
	public static Planet BarbanII;
	public static Planet BarbanIII;
	public static Planet BarbanIV;
	public static Planet KOI4878b;
	public static Planet ThesiusOmega;
	
	// TODO Move these to their own class when implemented,
	// put here to keep from having to go into every single class
	
	public static Moon planetOneMoon;
	public static Moon AlphaCentauroneA;
	public static Moon Erink;
	public static Moon Blastopy;
	public static Moon Keyian;
	public static Moon Junsin;
	public static Moon Xareious;
	public static Moon Ammon;
	public static Moon Terrin;
	public static Moon BarbanIVa;
	public static Moon Chiona;
	
	static Dimension dim = AddonConfig.addon_dimension;

	
	public Planets() {
		registerAll();
	}
	
	private static void registerAll() {
		
		ognious = new Planet("Ognious").setParentSolarSystem(Systems.garphina);
		ognious.setTierRequired(6);
		ognious.setRingColorRGB(0.1F, 0.9F, 0.6F);
		ognious.setPhaseShift(1.30F);
		ognious.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.35F, 1.35F));
		ognious.setRelativeOrbitTime(2.0F);
		ognious.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/ognious.png"));
		ognious.setBiomeInfo(OgniousBiomes.Ognious);
		ognious.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		ognious.setDimensionInfo(dim.idOgnious, WorldProviderOgnious.class);
		ognious.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		GalacticraftRegistry.registerTeleportType(WorldProviderOgnious.class, new TeleportTypeMoon());
		GalaxyRegistry.registerPlanet(ognious);
		
		polulos = new Planet("Polulos").setParentSolarSystem(Systems.garphina);
		polulos.setTierRequired(6);
		polulos.setRingColorRGB(0.1F, 0.9F, 0.6F);
		polulos.setPhaseShift(1.30F);
		polulos.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.25F, 0.25F));
		polulos.setRelativeOrbitTime(2.0F);
		polulos.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/polulos.png"));
		polulos.setBiomeInfo(PolulosBiomes.PolulosSavanna, PolulosBiomes.PolulosDesert);
		polulos.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		polulos.setDimensionInfo(dim.idPolulos, WorldProviderPolulos.class);
		polulos.atmosphereComponent(EnumAtmosphericGas.METHANE);
		GalacticraftRegistry.registerTeleportType(WorldProviderPolulos.class, new TeleportTypeMoon());
		GalaxyRegistry.registerPlanet(polulos);
		
		denia = new Planet("denia").setParentSolarSystem(Systems.garphina);
		denia.setTierRequired(6);
		denia.setRingColorRGB(0.1F, 0.9F, 0.6F);
		denia.setPhaseShift(1.30F);
		denia.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.05F, 1.05F));
		denia.setRelativeOrbitTime(2.0F);
		denia.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/denia.png"));
		denia.setBiomeInfo(DeniaBiomes.Denia);
		denia.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		denia.setDimensionInfo(dim.idDenia, WorldProviderDenia.class);
		denia.atmosphereComponent(EnumAtmosphericGas.METHANE);
		GalacticraftRegistry.registerTeleportType(WorldProviderDenia.class, new TeleportTypeMoon());
		GalaxyRegistry.registerPlanet(denia);
		
		vulcan = new Planet("Vulcan").setParentSolarSystem(Systems.aa);
		vulcan.setTierRequired(6);
		vulcan.setRingColorRGB(0.8F, 0.1F, 0.6F);
		vulcan.setPhaseShift(1.30F);
		vulcan.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.5F, 0.5F));
		vulcan.setRelativeOrbitTime(12.0F);
		vulcan.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/vulcan.png"));
		vulcan.setBiomeInfo(VulcanBiomes.VulcanHell);
		vulcan.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		vulcan.setDimensionInfo(dim.idVulcan, WorldProviderVulcan.class);
		vulcan.atmosphereComponent(EnumAtmosphericGas.METHANE);
		GalacticraftRegistry.registerTeleportType(WorldProviderVulcan.class, new TeleportTypeMoon());
		GalaxyRegistry.registerPlanet(vulcan);
	}
}
