package io.github.nagol2003.init;

import io.github.nagol2003.blocks.Denia.DeniaFerminiumOre;
import io.github.nagol2003.blocks.Denia.DeniaIronOre;
import io.github.nagol2003.blocks.Denia.FROZENCO2;
import io.github.nagol2003.blocks.Denia.StrangeMetallicDenia;
import io.github.nagol2003.blocks.Denia.Tundra;
import io.github.nagol2003.blocks.Denia.deniastone;
import io.github.nagol2003.blocks.Ognious.MoistDirt;
import io.github.nagol2003.blocks.Ognious.OgniousGrass;
import io.github.nagol2003.blocks.Ognious.OgniousLeaves;
import io.github.nagol2003.blocks.Ognious.OgniousLog;
import io.github.nagol2003.blocks.Ognious.OgniousRock;
import io.github.nagol2003.blocks.Ognious.OgniousStone;
import io.github.nagol2003.blocks.Polulos.PolulosDirt;
import io.github.nagol2003.blocks.Polulos.PolulosFerminiumOre;
import io.github.nagol2003.blocks.Polulos.PolulosRock;
import io.github.nagol2003.blocks.Polulos.PolulosSand;
import io.github.nagol2003.blocks.Polulos.ScorchedLeaves;
import io.github.nagol2003.blocks.Polulos.ScorchedLog;
import io.github.nagol2003.blocks.Polulos.StrangeMetallicPolulos;
import io.github.nagol2003.blocks.Tutorial.BlockCrust;
import io.github.nagol2003.blocks.Tutorial.BlockCrust.RockType;
import io.github.nagol2003.blocks.vulcan.VulcanDirt;
import io.github.nagol2003.blocks.vulcan.VulcanRockBurnt;
import io.github.nagol2003.blocks.vulcan.VulcanRockScorched;
import io.github.nagol2003.registry.APRegistry;
import io.github.nagol2003.testing.LIGHTSPEEDENGINE;
import net.minecraft.block.Block;

public class InitBlocks {

	//tutorial blocks
	public static final Block ROCK_1 = new BlockCrust(RockType.IGNEOUS);
	public static final Block ROCK_2 = new BlockCrust(RockType.METAMORPHIC);
	public static final Block ROCK_3 = new BlockCrust(RockType.SEDIMENTARY);

	//Additional Planets blocks
	public static final Block FROZENCO2 = new FROZENCO2();
	public static final Block POLULOSROCK = new PolulosRock();
	public static final Block POLULOSDIRT = new PolulosDirt();
	public static final Block SCORCHEDLOG = new ScorchedLog();
	public static final Block POLULOSSAND = new PolulosSand();
	public static final Block SCORCHEDLEAVES = new ScorchedLeaves();
	public static final Block POLULOSFERMINIUMORE = new PolulosFerminiumOre();
	public static final Block STRANGEMETALLICPOLULOS = new StrangeMetallicPolulos();
	public static final Block OGNIOUSGRASS = new OgniousGrass();
	public static final Block MOISTDIRT= new MoistDirt();
	public static final Block OGNIOUSLOG= new OgniousLog();
	public static final Block OGNIOUSLEAVES= new OgniousLeaves();
	public static final Block OGNIOUSSTONE= new OgniousStone();
	public static final Block OGNIOUSROCK= new OgniousRock();
	public static final Block VULCANDIRT= new VulcanDirt();
	public static final Block VULCANROCKSCORCHED= new VulcanRockScorched();
	public static final Block VULCANROCKBURNT= new VulcanRockBurnt();
	public static final Block DENIASTONE = new deniastone();
	public static final Block DENIAFERMINIUMORE = new DeniaFerminiumOre();
	public static final Block STRANGEMETALLICDENIA = new StrangeMetallicDenia();
	public static final Block DENIAIRONORE = new DeniaIronOre();
	public static final Block TUNDRA = new Tundra();
	public static final Block LIGHTSPEEDENGINE = new LIGHTSPEEDENGINE();
	//public static final Block REESH_PLANT = new ReeshPlant(null);
	//public static final Block REESH_PLANT = new ReeshPlant("reeshplant");

	public static void registerAll (APRegistry registry) {

		registry.setTab(AdditionalPlanetsTab.blockTab);
		registry.register(ROCK_1, "rock_1");
		registry.register(ROCK_2, "rock_2");
		registry.register(ROCK_3, "rock_3");

		registry.setTab(AdditionalPlanetsTab.AdditionalPlanets);
		registry.register(FROZENCO2, "frozenco2");
		registry.register(POLULOSROCK, "polulosrock");
		registry.register(POLULOSDIRT, "polulosdirt");
		registry.register(SCORCHEDLOG, "schorchedlog");
		registry.register(POLULOSSAND, "polulossand");
		registry.register(SCORCHEDLEAVES, "schorchedleaves");
		registry.register(POLULOSFERMINIUMORE, "polulosferminiumore");
		registry.register(STRANGEMETALLICPOLULOS, "strangemetallicpolulos");
		registry.register(OGNIOUSGRASS, "ogniousgrass");
		registry.register(MOISTDIRT, "moistdirt");
		registry.register(OGNIOUSLOG, "ogniouslog");
		registry.register(OGNIOUSLEAVES, "ogniousleaves");
		registry.register(OGNIOUSSTONE, "ogniousstone");
		registry.register(OGNIOUSROCK, "ogniousrock");
		registry.register(VULCANDIRT, "vulcandirt");
		registry.register(VULCANROCKSCORCHED, "vulcanrockscorched");
		registry.register(VULCANROCKBURNT, "vulcanrockburnt");
		registry.register(DENIASTONE, "deniastone");
		registry.register(DENIAFERMINIUMORE, "deniaferminiumore");
		registry.register(STRANGEMETALLICDENIA, "strangemetallicdenia");
		registry.register(DENIAIRONORE, "deniaironore");
		registry.register(TUNDRA, "tundra");
		registry.register(LIGHTSPEEDENGINE, "lightspeedengine");
		//registry.register(REESH_PLANT, "reeshplant");


	}

}
