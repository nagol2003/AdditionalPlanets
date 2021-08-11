package io.github.nagol2003.util;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;

import io.github.nagol2003.AddonMain;
import io.github.nagol2003.client.IItemMeshDefinitionCustom;
import lombok.experimental.UtilityClass;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.IFluidBlock;

@UtilityClass
public class FluidUtility {

	public static Map<Fluid, IFluidBlock> FLUIDBLOCKS = new HashMap<>();

	public static @Nonnull ItemStack getBucket(@Nonnull Fluid fluid) {
		final FluidStack fluidStack = new FluidStack(fluid, Fluid.BUCKET_VOLUME);
		try {
			fluidStack.getFluid();
		} catch (NullPointerException e) {
			throw new RuntimeException("The fluid " + fluid + " (" + fluid.getUnlocalizedName()
					+ ") is registered in the FluidRegistry, but the FluidRegistry has no delegate for it. This is impossible.",
					e);
		}
		try {
			return FluidUtil.getFilledBucket(fluidStack);
		} catch (Exception e) {
			throw new RuntimeException("The fluid " + fluid + " (" + fluid.getUnlocalizedName()
					+ ") is registered in the FluidRegistry, but crashes when put into a bucket. This is a bug in the mod it belongs to.",
					e);
		}
	}

	public static void registerFluidVariant(String fluid, Block fluidBlock) {
		ModelResourceLocation location = new ModelResourceLocation(fluid, "fluid");
		AddonMain.LOGGER.info("ModelResourceLocation: " + location.toString());
		Item item = Item.getItemFromBlock(fluidBlock);
		ModelBakery.registerItemVariants(item, new ResourceLocation(fluid));
		ModelLoader.setCustomMeshDefinition(item, IItemMeshDefinitionCustom.create((ItemStack stack) -> location));
		ModelLoader.setCustomStateMapper(fluidBlock, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return location;
			}
		});

	}
}
