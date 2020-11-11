package io.github.nagol2003.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AdditionalPlanetsTab {

	public static final CreativeTabs blockTab = new CreativeTabs("apBlockTab") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(InitBlocks.ROCK_1);
		}
	};
	
	
	public static final CreativeTabs ItemTab = new CreativeTabs("apItemTab") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(InitItems.FERMINIUM_CHUNK);
		}
		
	};
	
	public static final CreativeTabs AdditionalPlanets = new CreativeTabs("additionalPlanets") {

			@Override
			@SideOnly(Side.CLIENT)
			public ItemStack getTabIconItem() {
				return new ItemStack(InitItems.FERMINIUM_ALLOY);
			}
	    };
}