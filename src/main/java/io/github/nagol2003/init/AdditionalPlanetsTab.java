package io.github.nagol2003.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class AdditionalPlanetsTab {

	static final CreativeTabs AdditionalPlanetsTab = (new CreativeTabs("AdditionalPlanetsTab") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Blocks.FIRE);
		}
		
	});
	
}
