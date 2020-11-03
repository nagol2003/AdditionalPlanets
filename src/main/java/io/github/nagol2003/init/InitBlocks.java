package io.github.nagol2003.init;

import io.github.nagol2003.blocks.BlockCrust;
import io.github.nagol2003.blocks.BlockCrust.RockType;
import io.github.nagol2003.registry.APRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class InitBlocks {
	
	public static final Block ROCK_1 = new BlockCrust(RockType.IGNEOUS);
	public static final Block ROCK_2 = new BlockCrust(RockType.METAMORPHIC);
	public static final Block ROCK_3 = new BlockCrust(RockType.SEDIMENTARY);
	
	public static void registerAll (APRegistry registry) {
		CreativeTabs toTab = AdditionalPlanetsTab.blockTab;
		
		registry.registerBlock(ROCK_1, "rock_1").setCreativeTab(toTab);
		registry.registerBlock(ROCK_2, "rock_2").setCreativeTab(toTab);
		registry.registerBlock(ROCK_3, "rock_3").setCreativeTab(toTab);
	}
}
