package io.github.nagol2003.init;

import java.util.HashMap;

import io.github.nagol2003.AddonConfig;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {
	
	public static void init() {
		GameRegistry.addSmelting(InitBlocks.POLULOSFERMINIUMORE, new ItemStack(InitItems.FERMINIUM_CHUNK, 1), 35.0f);
		GameRegistry.addSmelting(InitBlocks.DENIAFERMINIUMORE, new ItemStack(InitItems.FERMINIUM_CHUNK, 1), 35.0f);
		GameRegistry.addSmelting(InitItems.RAW_CRAB_MEAT, new ItemStack(InitItems.COOKED_CRAB_MEAT, 1), 35.0f);
	}
}
