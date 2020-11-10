package io.github.nagol2003.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AdditionalPlanetsTab {

	public static final CreativeTabs blockTab = new CreativeTabs("apBlockTab") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(Item.getItemFromBlock(Blocks.BARRIER));
		}
	};
}
