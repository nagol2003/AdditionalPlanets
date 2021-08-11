package io.github.nagol2003.init;

import io.github.nagol2003.util.FluidUtility;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AdditionalPlanetsTab {

	public static final CreativeTabs blockTab = new CreativeTabs("apBlockTab") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(InitBlocks.ROCK_1);
		}

        @SideOnly(Side.CLIENT)
        @Override
        public void displayAllRelevantItems(final NonNullList<ItemStack> items)
        {
            super.displayAllRelevantItems(items);
        }
	};


	public static final CreativeTabs ItemTab = new CreativeTabs("apItemTab") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(InitItems.FERMINIUM_CHUNK);
		}

        @SideOnly(Side.CLIENT)
        @Override
        public void displayAllRelevantItems(final NonNullList<ItemStack> items)
        {
            super.displayAllRelevantItems(items);
            InitFluids.MOD_FLUID_BLOCKS.forEach(fluidBlock -> {
            	items.add(FluidUtility.getBucket(fluidBlock.getFluid()));
            });
        }
	};

	public static final CreativeTabs AdditionalPlanets = new CreativeTabs("additionalPlanets") {

			@Override
			@SideOnly(Side.CLIENT)
			public ItemStack getTabIconItem() {
				return new ItemStack(InitItems.FERMINIUM_ALLOY);
			}

	        @SideOnly(Side.CLIENT)
	        @Override
	        public void displayAllRelevantItems(final NonNullList<ItemStack> items)
	        {
	            super.displayAllRelevantItems(items);
	        }
	    };
}