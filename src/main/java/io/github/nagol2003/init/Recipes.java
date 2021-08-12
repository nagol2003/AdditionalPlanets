package io.github.nagol2003.init;

import java.util.HashMap;

import io.github.nagol2003.AddonConfig;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.core.GCItems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {
	
	public static void init() {
		GameRegistry.addSmelting(InitBlocks.POLULOSFERMINIUMORE, new ItemStack(InitItems.FERMINIUM_CHUNK, 1), 35.0f);
		GameRegistry.addSmelting(InitBlocks.DENIAFERMINIUMORE, new ItemStack(InitItems.FERMINIUM_CHUNK, 1), 35.0f);
		GameRegistry.addSmelting(InitItems.RAW_CRAB_MEAT, new ItemStack(InitItems.COOKED_CRAB_MEAT, 1), 35.0f);
		GameRegistry.addSmelting(InitBlocks.DENIAIRONORE, new ItemStack(Items.IRON_INGOT, 1), 35.0f);
	}
	
	//Compressor
	
	public static void compressor() {
        ItemStack input = new ItemStack(InitItems.FERMINIUM_CHUNK, 1);
        ItemStack outputResult = new ItemStack(InitItems.FERMINIUM_ALLOY, 1, 6);
                             
        CompressorRecipes.addShapelessRecipe(outputResult, input, input);
      }
	
	public static void compressor2() {
        ItemStack input = new ItemStack(InitItems.COOKED_CRAB_MEAT, 1);
        ItemStack outputResult = new ItemStack(InitItems.BOOTS_FERMINIUM, 1, 6);
                             
        CompressorRecipes.addShapelessRecipe(outputResult, input, input);
      }
	
}
