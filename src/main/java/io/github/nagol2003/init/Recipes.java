package io.github.nagol2003.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {
	
	public static void init() {
		GameRegistry.addSmelting(InitBlocks.FERMINIUMORE, new ItemStack(InitItems.FERMINIUM_CHUNK, 1), 35.0f);
	}

}
