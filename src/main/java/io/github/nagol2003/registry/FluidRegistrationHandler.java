package io.github.nagol2003.registry;

import com.google.common.base.Preconditions;

import io.github.nagol2003.Const;
import io.github.nagol2003.init.InitFluids;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Const.modID)
public class FluidRegistrationHandler {
	/**
	 * Register this mod's fluid {@link Block}s.
	 *
	 * @param event The event
	 */
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		final IForgeRegistry<Block> registry = event.getRegistry();

		for (final IFluidBlock fluidBlock : InitFluids.MOD_FLUID_BLOCKS) {
			final Block block = (Block) fluidBlock;
			block.setRegistryName(Const.modID, "fluid." + fluidBlock.getFluid().getName());
			block.setUnlocalizedName(Const.TEXTURE_PREFIX + fluidBlock.getFluid().getUnlocalizedName());
			registry.register(block);
		}
	}

	/**
	 * Register this mod's fluid {@link ItemBlock}s.
	 *
	 * @param event The event
	 */
	// Use EventPriority.LOWEST so this is called after the RegistryEvent.Register<Item> handler in ModBlocks where
	// the ItemBlock for ModBlocks.FLUID_TANK is registered.
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();

		for (final IFluidBlock fluidBlock : InitFluids.MOD_FLUID_BLOCKS) {
			final Block block = (Block) fluidBlock;
			final ItemBlock itemBlock = new ItemBlock(block);
			final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName());
			itemBlock.setRegistryName(registryName);
			registry.register(itemBlock);
		}

		for(final Fluid fluid : InitFluids.FLUIDS) {
			FluidRegistry.addBucketForFluid(fluid);
		}
	}
}
