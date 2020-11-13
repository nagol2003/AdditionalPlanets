package io.github.nagol2003.celestial;

import io.github.nagol2003.AddonConfig;
import io.github.nagol2003.AddonConfig.Dimension;
import io.github.nagol2003.AddonConfig.PlanetSettings;
import io.github.nagol2003.Const;
import io.github.nagol2003.celestial.planets.Ognious.WorldProviderOgnious;
import io.github.nagol2003.celestial.planets.Ognious.biome.OgniousBiomes;
import io.github.nagol2003.celestial.planets.Polulos.WorldProviderPolulos;
import io.github.nagol2003.celestial.planets.Polulos.biome.PolulosBiomes;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.AtmosphereInfo;
import micdoodle8.mods.galacticraft.api.world.EnumAtmosphericGas;
import micdoodle8.mods.galacticraft.core.dimension.TeleportTypeMoon;
import micdoodle8.mods.galacticraft.core.dimension.TeleportTypeOrbit;
import micdoodle8.mods.galacticraft.core.dimension.TeleportTypeOverworld;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedEnderman;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import micdoodle8.mods.galacticraft.planets.mars.dimension.TeleportTypeMars;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome.SpawnListEntry;

;


/**
 * Class AddonCelestialBodies
 * 
 * This is where we will store the public static Fields for all of our
 * CelestalObjects: - SolarSystems - Planets - Moons - SpaceStations (aka:
 * Satellites)
 * 
 * Each field can be called from other classes directly
 * 
 */
public class AddonCelestialBodies {

	// Systems
	public static SolarSystem AlphaCentauri;
	public static SolarSystem Zakir;
	public static SolarSystem unknown;
	public static SolarSystem Garphina;
	public static SolarSystem Test;

	// Planets
	public static Planet ProximaCentauriB;
	public static Planet ZakirPrime;
	public static Planet AlphaCentauriV;
	public static Planet AlphaCentaurfour;
	public static Planet AlphaCentaurone;
	public static Planet AlphaCentaurtwo;
	public static Planet unknownplanet;
	public static Planet mother;
	public static Planet Polulos;
	public static Planet Shayan;
	public static Planet Denia;
	public static Planet Ognious;
	public static Planet Queran;
	public static Planet Vermon;
	public static Planet Dark;

	// Moons
    public static Moon planetOneMoon;
	public static Moon AlphaCentauroneA;
	public static Moon Erink;
	public static Moon Blastopy;
	public static Moon Keyian;
	public static Moon Junsin;
	public static Moon Xareious;
	public static Moon Ammon;
	public static Moon Terrin;

	/**
	 * These are used to keep the building method parameters shorter when calling
	 * the config options value
	 * 
	 */
	static Dimension dim = AddonConfig.addon_dimension;
	static PlanetSettings pl = AddonConfig.addon_planet_settings;

	/**
	 * this is our initialization method that will be called in the mods main class
	 * to build our celestial bodies
	 * 
	 * the order these are in are an important part of this compiling correctly
	 */
	public static void init() {
		// we need to register a custom solar system first
		registerSolarSystems_1st_Task();
		// so our custom planets can be placed into that system
		registerPlanets_2nd_Task();
		// whatever planet the moons orbit need to be build first
		registerMoon_3rd_Task();
		// same goes for space station
		registerSpaceStation_4th_Task();

		registerAll();
		setTeleportsAndGuis();
	}

	/**
	 * Register solar systems.
	 * 
	 * These must be created first so we can add our planets to the new system. If
	 * these are not created first then we will get a NullPointExemption crash when
	 * loading gets to the planets since it cannot find a system that has not been
	 * created yet.
	 * 
	 */
	private static void registerSolarSystems_1st_Task() {

		// Build our custom solar system, we set "milky_way" so our solar system shows
		// up on the normal celestial map screen

		// its also important to always have the 3rd Vector3 float set to 0.0F, so the
		// solar system zoom actually zooms in on the system
		AlphaCentauri = new SolarSystem("AlphaCentauri", "milky_way").setMapPosition(new Vector3(-1.0F, 1.0F, 0.0F));
		Star starSol3 = (Star) new Star("AlphaCentauri").setParentSolarSystem(AlphaCentauri).setTierRequired(-1);
		starSol3.setBodyIcon(new ResourceLocation("galacticraftcore", "textures/gui/celestialbodies/sun.png"));
		AlphaCentauri.setMainStar(starSol3);
		
		Zakir = new SolarSystem("Zakir", "milky_way").setMapPosition(new Vector3(1.0F, -1.0F, 0.0F));
		Star starSol4 = (Star) new Star("ZakirStar").setParentSolarSystem(Zakir).setTierRequired(-1);
		starSol4.setBodyIcon(new ResourceLocation("galacticraftcore", "textures/gui/celestialbodies/sun.png"));
		Zakir.setMainStar(starSol4);
		
		unknown = new SolarSystem("unknown", "milky_way").setMapPosition(new Vector3(-1.0F, -1.0F, 0.0F));
		Star starSol5 = (Star) new Star("unknown").setParentSolarSystem(unknown).setTierRequired(-1);
		starSol5.setBodyIcon(new ResourceLocation("galacticraftcore", "textures/gui/celestialbodies/sun.png"));
		unknown.setMainStar(starSol5);
		
		Garphina = new SolarSystem("Garphina", "milky_way").setMapPosition(new Vector3(1.0F, 1.0F, 0.0F));
		Star starSol6 = (Star) new Star("Radon").setParentSolarSystem(Garphina).setTierRequired(-1);
		starSol6.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/radonstar.png"));
		Garphina.setMainStar(starSol6);
		
		Test = new SolarSystem("Test", "milky_way").setMapPosition(new Vector3(0.5F, -1.0F, 0.0F));
		Star starSol7 = (Star) new Star("Radon").setParentSolarSystem(Test).setTierRequired(-1);
		starSol7.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/radonstar.png"));
		Test.setMainStar(starSol7);
	}

	/**
	 * Register planets.
	 */
	private static void registerPlanets_2nd_Task() {

		// build planetOne
		ZakirPrime = new Planet("ZakirPrime").setParentSolarSystem(Zakir);
		ZakirPrime.setTierRequired(6);
		ZakirPrime.setRingColorRGB(0.1F, 0.9F, 0.6F);
		ZakirPrime.setPhaseShift(1.45F);
		ZakirPrime.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.0F, 1.0F));
		ZakirPrime.setRelativeOrbitTime(1.0F);
		ZakirPrime.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/zakir.png"));

		ProximaCentauriB = new Planet("ProximaCentauriB").setParentSolarSystem(AlphaCentauri);
		ProximaCentauriB.setTierRequired(6);
		ProximaCentauriB.setRingColorRGB(0.1F, 0.9F, 0.6F);
		ProximaCentauriB.setPhaseShift(1.45F);
		ProximaCentauriB.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.2F, 1.2F));
		ProximaCentauriB.setRelativeOrbitTime(1.0F);
		ProximaCentauriB.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/pcb.png"));

		AlphaCentauriV = new Planet("AlphaCentauriV").setParentSolarSystem(AlphaCentauri);
		AlphaCentauriV.setTierRequired(6);
		AlphaCentauriV.setRingColorRGB(0.1F, 0.9F, 0.6F);
		AlphaCentauriV.setPhaseShift(1.30F);
		AlphaCentauriV.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.0F, 2.0F));
		AlphaCentauriV.setRelativeOrbitTime(2.0F);
		AlphaCentauriV.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/acv.png"));

		AlphaCentaurfour = new Planet("AlphaCentaurfour").setParentSolarSystem(AlphaCentauri);
		AlphaCentaurfour.setTierRequired(6);
		AlphaCentaurfour.setRingColorRGB(0.1F, 0.9F, 0.6F);
		AlphaCentaurfour.setPhaseShift(1.30F);
		AlphaCentaurfour.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.6F, 1.6F));
		AlphaCentaurfour.setRelativeOrbitTime(2.0F);
		AlphaCentaurfour.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/acivd.png"));

		AlphaCentaurtwo = new Planet("AlphaCentaurtwo").setParentSolarSystem(AlphaCentauri);
		AlphaCentaurtwo.setTierRequired(6);
		AlphaCentaurtwo.setRingColorRGB(0.1F, 0.9F, 0.6F);
		AlphaCentaurtwo.setPhaseShift(1.30F);
		AlphaCentaurtwo.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.80F, 0.80F));
		AlphaCentaurtwo.setRelativeOrbitTime(2.0F);
		AlphaCentaurtwo.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/acii.png"));
		
		AlphaCentaurone = new Planet("AlphaCentaurone").setParentSolarSystem(AlphaCentauri);
		AlphaCentaurone.setTierRequired(6);
		AlphaCentaurone.setRingColorRGB(0.1F, 0.9F, 0.6F);
		AlphaCentaurone.setPhaseShift(1.30F);
		AlphaCentaurone.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.40F, 0.40F));
		AlphaCentaurone.setRelativeOrbitTime(2.0F);
		AlphaCentaurone.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/aciia.png"));

		unknownplanet = new Planet("unknownplanet").setParentSolarSystem(unknown);
		unknownplanet.setTierRequired(6);
		unknownplanet.setRingColorRGB(0.1F, 0.9F, 0.6F);
		unknownplanet.setPhaseShift(1.30F);
		unknownplanet.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.80F, 0.80F));
		unknownplanet.setRelativeOrbitTime(2.0F);
		unknownplanet.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/unknown.png"));

		mother = new Planet("mother").setParentSolarSystem(Zakir);
		mother.setTierRequired(6);
	    mother.setRingColorRGB(0.1F, 0.9F, 0.6F);
		mother.setPhaseShift(1.30F);
		mother.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.80F, 1.80F));
		mother.setRelativeOrbitTime(2.0F);
		mother.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/mother.png"));

		Polulos = new Planet("Polulos").setParentSolarSystem(Garphina);
		Polulos.setTierRequired(6);
		Polulos.setRingColorRGB(0.1F, 0.9F, 0.6F);
		Polulos.setPhaseShift(1.30F);
		Polulos.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.25F, 0.25F));
		Polulos.setRelativeOrbitTime(2.0F);
		Polulos.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/polulos.png"));
		Polulos.setBiomeInfo(PolulosBiomes.Polulos, PolulosBiomes.PolulosDry);
		Polulos.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		Polulos.setDimensionInfo(dim.idPolulos, WorldProviderPolulos.class);
		Polulos.atmosphereComponent(EnumAtmosphericGas.METHANE);

		Shayan = new Planet("Shayan").setParentSolarSystem(Garphina);
		Shayan.setTierRequired(6);
		Shayan.setRingColorRGB(0.1F, 0.9F, 0.6F);
		Shayan.setPhaseShift(1.30F);
		Shayan.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.65F, 0.65F));
		Shayan.setRelativeOrbitTime(2.0F);
		Shayan.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/mother.png"));

		Denia = new Planet("Denia").setParentSolarSystem(Garphina);
		Denia.setTierRequired(6);
		Denia.setRingColorRGB(0.1F, 0.9F, 0.6F);
		Denia.setPhaseShift(1.30F);
		Denia.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.05F, 1.05F));
		Denia.setRelativeOrbitTime(2.0F);
		Denia.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/mother.png"));

		Ognious = new Planet("Ognious").setParentSolarSystem(Garphina);
		Ognious.setTierRequired(6);
		Ognious.setRingColorRGB(0.1F, 0.9F, 0.6F);
		Ognious.setPhaseShift(1.30F);
		Ognious.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.35F, 1.35F));
		Ognious.setRelativeOrbitTime(2.0F);
		Ognious.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/ognious.png"));
		Ognious.setBiomeInfo(OgniousBiomes.Ognious);
		Ognious.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		Ognious.setDimensionInfo(dim.idOgnious, WorldProviderOgnious.class);
		Ognious.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);

		Queran = new Planet("Queran").setParentSolarSystem(Garphina);
		Queran.setTierRequired(6);
		Queran.setRingColorRGB(0.1F, 0.9F, 0.6F);
		Queran.setPhaseShift(1.30F);
		Queran.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(3.0F, 3.0F));
		Queran.setRelativeOrbitTime(6.0F);
		Queran.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/mother.png"));

		Vermon = new Planet("Vermon").setParentSolarSystem(Garphina);
		Vermon.setTierRequired(6);
		Vermon.setRingColorRGB(0.8F, 0.1F, 0.6F);
		Vermon.setPhaseShift(1.30F);
		Vermon.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(3.6F, 3.6F));
		Vermon.setRelativeOrbitTime(12.0F);
		Vermon.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/mother.png"));
		
		Dark = new Planet("Dark").setParentSolarSystem(Test);
		Dark.setTierRequired(6);
		Dark.setRingColorRGB(0.8F, 0.1F, 0.6F);
		Dark.setPhaseShift(1.30F);
		Dark.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0F, 0F));
		Dark.setRelativeOrbitTime(12.0F);
		Dark.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/mother.png"));

	}

	/**
	 * Register moon.
	 */
	private static void registerMoon_3rd_Task() {

		AlphaCentauroneA = new Moon("AlphaCentauroneA").setParentPlanet(AlphaCentaurone);
		AlphaCentauroneA.setPhaseShift(2.436F);
    	AlphaCentauroneA.setRingColorRGB(0.1F, 0.1F, 0.6F);
		AlphaCentauroneA.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
		AlphaCentauroneA.setRelativeOrbitTime(75.0F);
		AlphaCentauroneA.setTierRequired(7);
		AlphaCentauroneA.setRelativeSize(0.3867F);
		AlphaCentauroneA.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/aciia.png"));

		Erink = new Moon("Erink").setParentPlanet(Vermon);
		Erink.setPhaseShift(2.436F);
		Erink.setRingColorRGB(0.1F, 0.1F, 0.6F);
		Erink.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(12F, 4F));
		Erink.setRelativeOrbitTime(75.0F);
		Erink.setTierRequired(7);
		Erink.setRelativeSize(0.3867F);
		Erink.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/aciia.png"));

		Blastopy = new Moon("Blastopy").setParentPlanet(Vermon);
		Blastopy.setPhaseShift(2.436F);
		Blastopy.setRingColorRGB(0.1F, 0.1F, 0.6F);
		Blastopy.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(10F, 10F));
		Blastopy.setRelativeOrbitTime(75.0F);
		Blastopy.setTierRequired(7);
		Blastopy.setRelativeSize(0.3867F);
		Blastopy.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/aciia.png"));

		Keyian = new Moon("Keyian").setParentPlanet(Vermon);
		Keyian.setPhaseShift(2.436F);
		Keyian.setRingColorRGB(0.1F, 0.1F, 0.6F);
		Keyian.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8F, 8F));
		Keyian.setRelativeOrbitTime(75.0F);
		Keyian.setTierRequired(7);
		Keyian.setRelativeSize(0.3867F);
		Keyian.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/aciia.png"));

		Junsin = new Moon("Junsin").setParentPlanet(Vermon);
		Junsin.setPhaseShift(2.436F);
		Junsin.setRingColorRGB(0.1F, 0.1F, 0.6F);
		Junsin.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(7F, 7F));
		Junsin.setRelativeOrbitTime(75.0F);
		Junsin.setTierRequired(7);
		Junsin.setRelativeSize(0.3867F);
		Junsin.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/aciia.png"));

		Xareious = new Moon("Xareious").setParentPlanet(Queran);
		Xareious.setPhaseShift(2.436F);
		Xareious.setRingColorRGB(0.1F, 0.1F, 0.6F);
		Xareious.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 5F));
		Xareious.setRelativeOrbitTime(75.0F);
		Xareious.setTierRequired(7);
		Xareious.setRelativeSize(0.3867F);
		Xareious.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/aciia.png"));

		Ammon = new Moon("Ammon").setParentPlanet(Queran);
		Ammon.setPhaseShift(2.436F);
		Ammon.setRingColorRGB(0.1F, 0.1F, 0.6F);
		Ammon.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(6F, 6F));
		Ammon.setRelativeOrbitTime(75.0F);
		Ammon.setTierRequired(7);
		Ammon.setRelativeSize(0.3867F);
		Ammon.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/aciia.png"));

		Terrin = new Moon("Terrin").setParentPlanet(Ognious);
		Terrin.setPhaseShift(2.436F);
		Terrin.setRingColorRGB(0.1F, 0.1F, 0.6F);
		Terrin.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(10F,10F));
		Terrin.setRelativeOrbitTime(75.0F);
		Terrin.setTierRequired(7);
		Terrin.setRelativeSize(0.3867F);
		Terrin.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/aciia.png"));

	}

	/**
	 * Register space station.
	 */
	private static void registerSpaceStation_4th_Task() {
		
//		commenting out but keeping just in case
		

//		planetTwoSpaceStation = new Satellite("space_station.eris").setParentBody(planetTwo);
//		planetTwoSpaceStation.setRelativeSize(0.2667F);
//		planetTwoSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
//		planetTwoSpaceStation.setRelativeOrbitTime(20.0F);
//		planetTwoSpaceStation.setTierRequired(planetTwo.getTierRequirement());
//		planetTwoSpaceStation.setDimensionInfo(dim.idSpaceStation, dim.StaticidSpaceStation, WorldProviderPlanetTwoStation.class);
//		planetTwoSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/space_station.png"));
//		planetTwoSpaceStation.addChecklistKeys("equip_oxygen_suit", "equip_parachute");
//		planetTwoSpaceStation.setBiomeInfo(BiomeOrbit.space);
	}

	private static void setMobInfo(CelestialBody body) {
		body.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
		body.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
		body.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
		body.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
		body.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
	}

	private static void setTeleportsAndGuis() {
		// registerTeleportType is pretty important. If we don't set one for our planets
		// then
		// you will not be able to travel to said planet.
		
		// comment these out for now but keep em to just change the world provider class later

		GalacticraftRegistry.registerTeleportType(WorldProviderPolulos.class, new TeleportTypeMoon());
		GalacticraftRegistry.registerTeleportType(WorldProviderOgnious.class, new TeleportTypeMoon());
//		GalacticraftRegistry.registerTeleportType(WorldProviderPlanetTwo.class, new TeleportTypeMoon());
//		GalacticraftRegistry.registerTeleportType(WorldProviderPlanetTwoStation.class, new TeleportTypeSpaceStation());
//		GalacticraftRegistry.registerTeleportType(WorldProviderPlanetOneMoon.class, new TeleportTypeMars());
	}

	private static void registerAll() {
		// Now we register each Celestial Body after we have created and defined them

		// Solar systems first
		//GalaxyRegistry.registerSolarSystem(AlphaCentauri);
		//GalaxyRegistry.registerSolarSystem(Zakir);
		//GalaxyRegistry.registerSolarSystem(unknown);
		GalaxyRegistry.registerSolarSystem(Garphina);
		//GalaxyRegistry.registerSolarSystem(Test);
		
		// then plants
		//GalaxyRegistry.registerPlanet(ProximaCentauriB);
		//GalaxyRegistry.registerPlanet(AlphaCentauriV);
		//GalaxyRegistry.registerPlanet(AlphaCentaurfour);
		//GalaxyRegistry.registerPlanet(AlphaCentaurone);
		//GalaxyRegistry.registerPlanet(AlphaCentaurtwo);
		//GalaxyRegistry.registerPlanet(ZakirPrime);
		//GalaxyRegistry.registerPlanet(unknownplanet);
		//GalaxyRegistry.registerPlanet(mother);
		GalaxyRegistry.registerPlanet(Polulos);
		//GalaxyRegistry.registerPlanet(Shayan);
		//GalaxyRegistry.registerPlanet(Denia);
		GalaxyRegistry.registerPlanet(Ognious);
		//GalaxyRegistry.registerPlanet(Queran);
		//GalaxyRegistry.registerPlanet(Vermon);
		//GalaxyRegistry.registerPlanet(Dark);
		
		// then moons
		//GalaxyRegistry.registerMoon(AlphaCentauroneA);
		//GalaxyRegistry.registerMoon(Erink);
		//GalaxyRegistry.registerMoon(Blastopy);
		//GalaxyRegistry.registerMoon(Keyian);
		//GalaxyRegistry.registerMoon(Junsin);
		//GalaxyRegistry.registerMoon(Xareious);
		//GalaxyRegistry.registerMoon(Ammon);
		//GalaxyRegistry.registerMoon(Terrin);

	}

}