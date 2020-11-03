package io.github.nagol2003;

import io.github.nagol2003.AddonConfig.Dimension;
import io.github.nagol2003.AddonConfig.PlanetSettings;
import io.github.nagol2003.moon.WorldProviderPlanetOneMoon;
import io.github.nagol2003.planets.planetone.WorldProviderPlanetOne;
import io.github.nagol2003.planets.planetone.biome.PlanetOneBiomes;
import io.github.nagol2003.planets.planettwo.WorldProviderPlanetTwo;
import io.github.nagol2003.spacestation.WorldProviderPlanetTwoStation;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.galaxies.Satellite;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.AtmosphereInfo;
import micdoodle8.mods.galacticraft.api.world.EnumAtmosphericGas;
import micdoodle8.mods.galacticraft.core.dimension.TeleportTypeMoon;
import micdoodle8.mods.galacticraft.core.dimension.TeleportTypeSpaceStation;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedEnderman;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import micdoodle8.mods.galacticraft.core.world.gen.BiomeOrbit;
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
	public static SolarSystem customSystem;
	public static SolarSystem AlphaCentauri;
	public static SolarSystem Zakir;
	public static SolarSystem unknown;
	public static SolarSystem Garphina;

	// Planets
	public static Planet planetOne;
	public static Planet planetTwo;
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
	

	// SpaceStations
	public static Satellite planetTwoSpaceStation;

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
		//customSystem = new SolarSystem("custom_system", "milky_way").setMapPosition(new Vector3(1.0F, -1.4f, 0.0f));
		//Star starSol = (Star) new Star("custom_star").setParentSolarSystem(customSystem).setTierRequired(-1);
		//starSol.setBodyIcon(new ResourceLocation("galacticraftcore", "textures/gui/celestialbodies/sun.png"));
		//customSystem.setMainStar(starSol);
		
		AlphaCentauri = new SolarSystem("AlphaCentauri", "milky_way").setMapPosition(new Vector3(3.8F, 1.6F, 0.0F));
		Star starSol3 = (Star) new Star("AlphaCentauri").setParentSolarSystem(AlphaCentauri).setTierRequired(-1);
		starSol3.setBodyIcon(new ResourceLocation("galacticraftcore", "textures/gui/celestialbodies/sun.png"));
		AlphaCentauri.setMainStar(starSol3);
		
		Zakir = new SolarSystem("Zakir", "milky_way").setMapPosition(new Vector3(4.8F, 2.6F, 0.0F));
		Star starSol4 = (Star) new Star("ZakirStar").setParentSolarSystem(Zakir).setTierRequired(-1);
		starSol4.setBodyIcon(new ResourceLocation("galacticraftcore", "textures/gui/celestialbodies/sun.png"));
		Zakir.setMainStar(starSol4);
		
		unknown = new SolarSystem("unknown", "milky_way").setMapPosition(new Vector3(4.8F, 4.6F, 0.0F));
		Star starSol5 = (Star) new Star("unknown").setParentSolarSystem(unknown).setTierRequired(-1);
		starSol5.setBodyIcon(new ResourceLocation("galacticraftcore", "textures/gui/celestialbodies/sun.png"));
		unknown.setMainStar(starSol5);
		
		Garphina = new SolarSystem("Garphina", "milky_way").setMapPosition(new Vector3(9.0F, 2.6F, 0.0F));
		Star starSol6 = (Star) new Star("Radon").setParentSolarSystem(Garphina).setTierRequired(-1);
		starSol6.setBodyIcon(new ResourceLocation("galacticraftcore", "textures/gui/celestialbodies/sun.png"));
		Garphina.setMainStar(starSol6);
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
		ZakirPrime.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		ZakirPrime.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/zakir.png"));
		ZakirPrime.setDimensionInfo(dim.idPlanetOne, WorldProviderPlanetOne.class);
		ZakirPrime.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		ZakirPrime.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		ZakirPrime.setBiomeInfo(PlanetOneBiomes.planetOne, PlanetOneBiomes.planetOne_sea);
		setMobInfo(ZakirPrime);
		
		ProximaCentauriB = new Planet("ProximaCentauriB").setParentSolarSystem(AlphaCentauri);
		ProximaCentauriB.setTierRequired(6);
		ProximaCentauriB.setRingColorRGB(0.1F, 0.9F, 0.6F);
		ProximaCentauriB.setPhaseShift(1.45F);
		ProximaCentauriB.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.2F, 1.2F));
		ProximaCentauriB.setRelativeOrbitTime(1.0F);
		ProximaCentauriB.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		ProximaCentauriB.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/pcb.png"));
		ProximaCentauriB.setDimensionInfo(dim.idPlanetOne, WorldProviderPlanetOne.class);
		ProximaCentauriB.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		ProximaCentauriB.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		ProximaCentauriB.setBiomeInfo(PlanetOneBiomes.planetOne, PlanetOneBiomes.planetOne_sea);
		setMobInfo(ProximaCentauriB);
		
		AlphaCentauriV = new Planet("AlphaCentauriV").setParentSolarSystem(AlphaCentauri);
		AlphaCentauriV.setTierRequired(6);
		AlphaCentauriV.setRingColorRGB(0.1F, 0.9F, 0.6F);
		AlphaCentauriV.setPhaseShift(1.30F);
		AlphaCentauriV.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.0F, 2.0F));
		AlphaCentauriV.setRelativeOrbitTime(2.0F);
		AlphaCentauriV.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		AlphaCentauriV.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/acv.png"));
		AlphaCentauriV.setDimensionInfo(dim.idPlanetOne, WorldProviderPlanetOne.class);
		AlphaCentauriV.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		AlphaCentauriV.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		AlphaCentauriV.setBiomeInfo(PlanetOneBiomes.planetOne, PlanetOneBiomes.planetOne_sea);
		setMobInfo(AlphaCentauriV);
		
		AlphaCentaurfour = new Planet("AlphaCentaurfour").setParentSolarSystem(AlphaCentauri);
		AlphaCentaurfour.setTierRequired(6);
		AlphaCentaurfour.setRingColorRGB(0.1F, 0.9F, 0.6F);
		AlphaCentaurfour.setPhaseShift(1.30F);
		AlphaCentaurfour.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.6F, 1.6F));
		AlphaCentaurfour.setRelativeOrbitTime(2.0F);
		AlphaCentaurfour.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		AlphaCentaurfour.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/acivd.png"));
		AlphaCentaurfour.setDimensionInfo(dim.idPlanetOne, WorldProviderPlanetOne.class);
		AlphaCentaurfour.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		AlphaCentaurfour.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		AlphaCentaurfour.setBiomeInfo(PlanetOneBiomes.planetOne, PlanetOneBiomes.planetOne_sea);
		setMobInfo(AlphaCentaurfour);
		
		AlphaCentaurtwo = new Planet("AlphaCentaurtwo").setParentSolarSystem(AlphaCentauri);
		AlphaCentaurtwo.setTierRequired(6);
		AlphaCentaurtwo.setRingColorRGB(0.1F, 0.9F, 0.6F);
		AlphaCentaurtwo.setPhaseShift(1.30F);
		AlphaCentaurtwo.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.80F, 0.80F));
		AlphaCentaurtwo.setRelativeOrbitTime(2.0F);
		AlphaCentaurtwo.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		AlphaCentaurtwo.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/acii.png"));
		AlphaCentaurtwo.setDimensionInfo(dim.idPlanetOne, WorldProviderPlanetOne.class);
		AlphaCentaurtwo.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		AlphaCentaurtwo.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		AlphaCentaurtwo.setBiomeInfo(PlanetOneBiomes.planetOne, PlanetOneBiomes.planetOne_sea);
		setMobInfo(AlphaCentaurtwo);
		
		
		AlphaCentaurone = new Planet("AlphaCentaurone").setParentSolarSystem(AlphaCentauri);
		AlphaCentaurone.setTierRequired(6);
		AlphaCentaurone.setRingColorRGB(0.1F, 0.9F, 0.6F);
		AlphaCentaurone.setPhaseShift(1.30F);
		AlphaCentaurone.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.40F, 0.40F));
		AlphaCentaurone.setRelativeOrbitTime(2.0F);
		AlphaCentaurone.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		AlphaCentaurone.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/aciia.png"));
		AlphaCentaurone.setDimensionInfo(dim.idPlanetOne, WorldProviderPlanetOne.class);
		AlphaCentaurone.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		AlphaCentaurone.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		AlphaCentaurone.setBiomeInfo(PlanetOneBiomes.planetOne, PlanetOneBiomes.planetOne_sea);
		setMobInfo(AlphaCentaurone);
		
		planetOne = new Planet("planet_one").setParentSolarSystem(customSystem);
		planetOne.setTierRequired(3);
		planetOne.setRingColorRGB(0.1F, 0.9F, 0.6F);
		planetOne.setPhaseShift(1.45F);
		planetOne.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.0F, 1.0F));
		planetOne.setRelativeOrbitTime(1.0F);
		planetOne.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		planetOne.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/planetfour.png"));
		planetOne.setDimensionInfo(dim.idPlanetOne, WorldProviderPlanetOne.class);
		planetOne.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		planetOne.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		planetOne.setBiomeInfo(PlanetOneBiomes.planetOne, PlanetOneBiomes.planetOne_sea);
		setMobInfo(planetOne);

		// build planetTwo
		planetTwo = new Planet("planet_two").setParentSolarSystem(customSystem);
		planetTwo.setTierRequired(3);
		planetTwo.setRingColorRGB(0.1F, 0.9F, 0.6F);
	    planetTwo.setPhaseShift(1.45F);
		planetTwo.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.5F, 1.5F));
		planetTwo.setRelativeOrbitTime(1.0F);
		planetTwo.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		planetTwo.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/pcb.png"));
		planetTwo.setDimensionInfo(dim.idPlanetTwo, WorldProviderPlanetTwo.class);
		planetTwo.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		planetTwo.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		setMobInfo(planetTwo);
		
		unknownplanet = new Planet("unknownplanet").setParentSolarSystem(unknown);
		unknownplanet.setTierRequired(6);
		unknownplanet.setRingColorRGB(0.1F, 0.9F, 0.6F);
		unknownplanet.setPhaseShift(1.30F);
		unknownplanet.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.80F, 0.80F));
		unknownplanet.setRelativeOrbitTime(2.0F);
		unknownplanet.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		unknownplanet.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/unknown.png"));
		unknownplanet.setDimensionInfo(dim.idPlanetOne, WorldProviderPlanetOne.class);
		unknownplanet.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		unknownplanet.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		unknownplanet.setBiomeInfo(PlanetOneBiomes.planetOne, PlanetOneBiomes.planetOne_sea);
		setMobInfo(unknownplanet);
		
		mother = new Planet("mother").setParentSolarSystem(Zakir);
		mother.setTierRequired(6);
	    mother.setRingColorRGB(0.1F, 0.9F, 0.6F);
		mother.setPhaseShift(1.30F);
		mother.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.80F, 1.80F));
		mother.setRelativeOrbitTime(2.0F);
		mother.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		mother.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/mother.png"));
		mother.setDimensionInfo(dim.idPlanetOne, WorldProviderPlanetOne.class);
		mother.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		mother.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		mother.setBiomeInfo(PlanetOneBiomes.planetOne, PlanetOneBiomes.planetOne_sea);
		setMobInfo(mother);
		
		Polulos = new Planet("Polulos").setParentSolarSystem(Garphina);
		Polulos.setTierRequired(6);
		Polulos.setRingColorRGB(0.1F, 0.9F, 0.6F);
		Polulos.setPhaseShift(1.30F);
		Polulos.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.25F, 0.25F));
		Polulos.setRelativeOrbitTime(2.0F);
		Polulos.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		Polulos.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/mother.png"));
		Polulos.setDimensionInfo(dim.idPlanetOne, WorldProviderPlanetOne.class);
		Polulos.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		Polulos.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		Polulos.setBiomeInfo(PlanetOneBiomes.planetOne, PlanetOneBiomes.planetOne_sea);
		setMobInfo(Polulos);
		
		Shayan = new Planet("Shayan").setParentSolarSystem(Garphina);
		Shayan.setTierRequired(6);
		Shayan.setRingColorRGB(0.1F, 0.9F, 0.6F);
		Shayan.setPhaseShift(1.30F);
		Shayan.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.65F, 0.65F));
		Shayan.setRelativeOrbitTime(2.0F);
		Shayan.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		Shayan.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/mother.png"));
		Shayan.setDimensionInfo(dim.idPlanetOne, WorldProviderPlanetOne.class);
		Shayan.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		Shayan.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		Shayan.setBiomeInfo(PlanetOneBiomes.planetOne, PlanetOneBiomes.planetOne_sea);
		setMobInfo(Shayan);
		
		Denia = new Planet("Denia").setParentSolarSystem(Garphina);
		Denia.setTierRequired(6);
		Denia.setRingColorRGB(0.1F, 0.9F, 0.6F);
		Denia.setPhaseShift(1.30F);
		Denia.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.05F, 1.05F));
		Denia.setRelativeOrbitTime(2.0F);
		Denia.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		Denia.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/mother.png"));
		Denia.setDimensionInfo(dim.idPlanetOne, WorldProviderPlanetOne.class);
		Denia.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		Denia.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		Denia.setBiomeInfo(PlanetOneBiomes.planetOne, PlanetOneBiomes.planetOne_sea);
		setMobInfo(Denia);
		
		Ognious = new Planet("Ognious").setParentSolarSystem(Garphina);
		Ognious.setTierRequired(6);
		Ognious.setRingColorRGB(0.1F, 0.9F, 0.6F);
		Ognious.setPhaseShift(1.30F);
		Ognious.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.35F, 1.35F));
		Ognious.setRelativeOrbitTime(2.0F);
		Ognious.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		Ognious.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/mother.png"));
		Ognious.setDimensionInfo(dim.idPlanetOne, WorldProviderPlanetOne.class);
		Ognious.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		Ognious.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		Ognious.setBiomeInfo(PlanetOneBiomes.planetOne, PlanetOneBiomes.planetOne_sea);
		setMobInfo(Ognious);
		
		Queran = new Planet("Queran").setParentSolarSystem(Garphina);
		Queran.setTierRequired(6);
		Queran.setRingColorRGB(0.1F, 0.9F, 0.6F);
		Queran.setPhaseShift(1.30F);
		Queran.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(3.25F, 3.25F));
		Queran.setRelativeOrbitTime(2.0F);
		Queran.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		Queran.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/mother.png"));
		Queran.setDimensionInfo(dim.idPlanetOne, WorldProviderPlanetOne.class);
		Queran.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		Queran.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		Queran.setBiomeInfo(PlanetOneBiomes.planetOne, PlanetOneBiomes.planetOne_sea);
		setMobInfo(Queran);

		Vermon = new Planet("Vermon").setParentSolarSystem(Garphina);
		Vermon.setTierRequired(6);
		Vermon.setRingColorRGB(0.1F, 0.9F, 0.6F);
		Vermon.setPhaseShift(1.30F);
		Vermon.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9.00F, 9.00F));
		Vermon.setRelativeOrbitTime(2.0F);
		Vermon.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
		Vermon.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/mother.png"));
		Vermon.setDimensionInfo(dim.idPlanetOne, WorldProviderPlanetOne.class);
		Vermon.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.1F));
		Vermon.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		Vermon.setBiomeInfo(PlanetOneBiomes.planetOne, PlanetOneBiomes.planetOne_sea);
		setMobInfo(Vermon);
	}

	/**
	 * Register moon.
	 */
	private static void registerMoon_3rd_Task() {

		planetOneMoon = new Moon("planet_one_moon").setParentPlanet(planetOne);
		planetOneMoon.setPhaseShift(2.436F);
		planetOneMoon.setRingColorRGB(0.1F, 0.1F, 0.6F);
		planetOneMoon.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
		planetOneMoon.setRelativeOrbitTime(75.0F);
		planetOneMoon.setTierRequired(7);
		planetOneMoon.setRelativeSize(0.3867F);
		planetOneMoon.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
		planetOneMoon.setBodyIcon(new ResourceLocation("galacticraftcore" , "textures/gui/celestialbodies/moon.png"));
		planetOneMoon.setDimensionInfo(dim.idMoon, WorldProviderPlanetOneMoon.class);
		planetOneMoon.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.2F));
		planetOneMoon.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		
		AlphaCentauroneA = new Moon("AlphaCentauroneA").setParentPlanet(AlphaCentaurone);
		AlphaCentauroneA.setPhaseShift(2.436F);
    	AlphaCentauroneA.setRingColorRGB(0.1F, 0.1F, 0.6F);
		AlphaCentauroneA.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
		AlphaCentauroneA.setRelativeOrbitTime(75.0F);
		AlphaCentauroneA.setTierRequired(7);
		AlphaCentauroneA.setRelativeSize(0.3867F);
		AlphaCentauroneA.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
		AlphaCentauroneA.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/aciia.png"));
		AlphaCentauroneA.setDimensionInfo(dim.idMoon, WorldProviderPlanetOneMoon.class);
		AlphaCentauroneA.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.2F));
		AlphaCentauroneA.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		
		Erink = new Moon("Erink").setParentPlanet(Vermon);
		Erink.setPhaseShift(2.436F);
		Erink.setRingColorRGB(0.1F, 0.1F, 0.6F);
		Erink.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(12F, 4F));
		Erink.setRelativeOrbitTime(75.0F);
		Erink.setTierRequired(7);
		Erink.setRelativeSize(0.3867F);
		Erink.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
		Erink.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/aciia.png"));
		Erink.setDimensionInfo(dim.idMoon, WorldProviderPlanetOneMoon.class);
		Erink.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.2F));
		Erink.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		
		Blastopy = new Moon("Blastopy").setParentPlanet(Vermon);
		Blastopy.setPhaseShift(2.436F);
		Blastopy.setRingColorRGB(0.1F, 0.1F, 0.6F);
		Blastopy.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(10F, 10F));
		Blastopy.setRelativeOrbitTime(75.0F);
		Blastopy.setTierRequired(7);
		Blastopy.setRelativeSize(0.3867F);
		Blastopy.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
		Blastopy.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/aciia.png"));
		Blastopy.setDimensionInfo(dim.idMoon, WorldProviderPlanetOneMoon.class);
		Blastopy.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.2F));
		Blastopy.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		
		Keyian = new Moon("Keyian").setParentPlanet(Vermon);
		Keyian.setPhaseShift(2.436F);
		Keyian.setRingColorRGB(0.1F, 0.1F, 0.6F);
		Keyian.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8F, 8F));
		Keyian.setRelativeOrbitTime(75.0F);
		Keyian.setTierRequired(7);
		Keyian.setRelativeSize(0.3867F);
		Keyian.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
		Keyian.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/aciia.png"));
		Keyian.setDimensionInfo(dim.idMoon, WorldProviderPlanetOneMoon.class);
		Keyian.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.2F));
		Keyian.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		
		Junsin = new Moon("Junsin").setParentPlanet(Vermon);
		Junsin.setPhaseShift(2.436F);
		Junsin.setRingColorRGB(0.1F, 0.1F, 0.6F);
		Junsin.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(7F, 7F));
		Junsin.setRelativeOrbitTime(75.0F);
		Junsin.setTierRequired(7);
		Junsin.setRelativeSize(0.3867F);
		Junsin.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
		Junsin.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/aciia.png"));
		Junsin.setDimensionInfo(dim.idMoon, WorldProviderPlanetOneMoon.class);
		Junsin.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.2F));
		Junsin.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		
		Xareious = new Moon("Xareious").setParentPlanet(Queran);
		Xareious.setPhaseShift(2.436F);
		Xareious.setRingColorRGB(0.1F, 0.1F, 0.6F);
		Xareious.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 5F));
		Xareious.setRelativeOrbitTime(75.0F);
		Xareious.setTierRequired(7);
		Xareious.setRelativeSize(0.3867F);
		Xareious.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
		Xareious.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/aciia.png"));
		Xareious.setDimensionInfo(dim.idMoon, WorldProviderPlanetOneMoon.class);
		Xareious.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.2F));
		Xareious.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		
		Ammon = new Moon("Ammon").setParentPlanet(Queran);
		Ammon.setPhaseShift(2.436F);
		Ammon.setRingColorRGB(0.1F, 0.1F, 0.6F);
		Ammon.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(6F, 6F));
		Ammon.setRelativeOrbitTime(75.0F);
		Ammon.setTierRequired(7);
		Ammon.setRelativeSize(0.3867F);
		Ammon.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
		Ammon.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/aciia.png"));
		Ammon.setDimensionInfo(dim.idMoon, WorldProviderPlanetOneMoon.class);
		Ammon.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.2F));
		Ammon.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		
		Terrin = new Moon("Terrin").setParentPlanet(Ognious);
		Terrin.setPhaseShift(2.436F);
		Terrin.setRingColorRGB(0.1F, 0.1F, 0.6F);
		Terrin.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(10F,10F));
		Terrin.setRelativeOrbitTime(75.0F);
		Terrin.setTierRequired(7);
		Terrin.setRelativeSize(0.3867F);
		Terrin.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
		Terrin.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/aciia.png"));
		Terrin.setDimensionInfo(dim.idMoon, WorldProviderPlanetOneMoon.class);
		Terrin.setAtmosphere(new AtmosphereInfo(false, false, false, 5.0F, 0.0F, 0.2F));
		Terrin.addChecklistKeys("space_suit", "equip_oxygen_suit", "equip_parachute");
		
	}

	/**
	 * Register space station.
	 */
	private static void registerSpaceStation_4th_Task() {

		planetTwoSpaceStation = new Satellite("space_station.eris").setParentBody(planetTwo);
		planetTwoSpaceStation.setRelativeSize(0.2667F);
		planetTwoSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
		planetTwoSpaceStation.setRelativeOrbitTime(20.0F);
		planetTwoSpaceStation.setTierRequired(planetTwo.getTierRequirement());
		planetTwoSpaceStation.setDimensionInfo(dim.idSpaceStation, dim.StaticidSpaceStation, WorldProviderPlanetTwoStation.class);
		planetTwoSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/space_station.png"));
		planetTwoSpaceStation.addChecklistKeys("equip_oxygen_suit", "equip_parachute");
		planetTwoSpaceStation.setBiomeInfo(BiomeOrbit.space);
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

		GalacticraftRegistry.registerTeleportType(WorldProviderPlanetOne.class, new TeleportTypeMars());
		GalacticraftRegistry.registerTeleportType(WorldProviderPlanetTwo.class, new TeleportTypeMoon());
		GalacticraftRegistry.registerTeleportType(WorldProviderPlanetTwoStation.class, new TeleportTypeSpaceStation());
		GalacticraftRegistry.registerTeleportType(WorldProviderPlanetOneMoon.class, new TeleportTypeMars());
	}

	private static void registerAll() {
		// Now we register each Celestial Body after we have created and defined them

		//GalaxyRegistry.registerSolarSystem(customSystem);
		//GalaxyRegistry.registerSolarSystem(customSystem);
		GalaxyRegistry.registerSolarSystem(AlphaCentauri);
		GalaxyRegistry.registerSolarSystem(Zakir);
		GalaxyRegistry.registerPlanet(ProximaCentauriB);
		GalaxyRegistry.registerPlanet(AlphaCentauriV);
		GalaxyRegistry.registerPlanet(AlphaCentaurfour);
		GalaxyRegistry.registerPlanet(AlphaCentaurone);
		GalaxyRegistry.registerPlanet(AlphaCentaurtwo);
		GalaxyRegistry.registerPlanet(ZakirPrime);
		//GalaxyRegistry.registerPlanet(planetOne);
		//GalaxyRegistry.registerPlanet(planetTwo);
		//GalaxyRegistry.registerMoon(planetOneMoon);
		GalaxyRegistry.registerMoon(AlphaCentauroneA);
		//GalaxyRegistry.registerSatellite(planetTwoSpaceStation);
		GalaxyRegistry.registerSolarSystem(unknown);
		GalaxyRegistry.registerPlanet(unknownplanet);
		GalaxyRegistry.registerPlanet(mother);
		GalaxyRegistry.registerSolarSystem(Garphina);
		GalaxyRegistry.registerPlanet(Polulos);
		GalaxyRegistry.registerPlanet(Shayan);
		GalaxyRegistry.registerPlanet(Denia);
		GalaxyRegistry.registerPlanet(Ognious);
		GalaxyRegistry.registerPlanet(Queran);
		GalaxyRegistry.registerPlanet(Vermon);
		GalaxyRegistry.registerMoon(Erink);
		GalaxyRegistry.registerMoon(Blastopy);
		GalaxyRegistry.registerMoon(Keyian);
		GalaxyRegistry.registerMoon(Junsin);
		GalaxyRegistry.registerMoon(Xareious);
		GalaxyRegistry.registerMoon(Ammon);
		GalaxyRegistry.registerMoon(Terrin);

	}

}