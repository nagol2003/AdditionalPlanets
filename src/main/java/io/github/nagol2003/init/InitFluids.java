package io.github.nagol2003.init;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

import io.github.nagol2003.Const;
import io.github.nagol2003.blocks.fluid.BlockFluidNoFlow;
import io.github.nagol2003.blocks.fluid.BlockFluidNoOverlap;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.IFluidBlock;

public class InitFluids {

	/**
	 * The fluids registered by this mod. Includes fluids that were already registered by another mod.
	 */
	public static final Set<Fluid> FLUIDS = new HashSet<>();

	/**
	 * The fluid blocks from this mod only. Doesn't include blocks for fluids that were already registered by another mod.
	 */
	public static final Set<IFluidBlock> MOD_FLUID_BLOCKS = new HashSet<>();

	public static final Fluid STATIC = createFluid("static", false,
			fluid -> fluid.setLuminosity(10).setDensity(800).setViscosity(1500),
			fluid -> new BlockFluidNoFlow(fluid, new MaterialLiquid(MapColor.BROWN)));

	public static final Fluid STATIC_GAS = createFluid("static_gas", false,
			fluid -> fluid.setLuminosity(10).setDensity(-800).setViscosity(1500).setGaseous(true),

			fluid -> new BlockFluidNoFlow(fluid, new MaterialLiquid(MapColor.BROWN)));

	public static final Fluid NORMAL = createFluid("normal", true,
			fluid -> fluid.setLuminosity(10).setDensity(1600).setViscosity(100),
			fluid -> new BlockFluidNoOverlap(fluid, new MaterialLiquid(MapColor.ADOBE)));

	public static final Fluid NORMAL_GAS = createFluid("normal_gas", true,
			fluid -> fluid.setLuminosity(10).setDensity(-1600).setViscosity(100).setGaseous(true),
			fluid -> new BlockFluidClassic(fluid, new MaterialLiquid(MapColor.ADOBE)));

	public static final Fluid FINITE = createFluid("finite", false,
			fluid -> fluid.setLuminosity(10).setDensity(800).setViscosity(1500),
			fluid -> new BlockFluidFinite(fluid, new MaterialLiquid(MapColor.BLACK)));

	/**
	 * Create a {@link Fluid} and its {@link IFluidBlock}, or use the existing ones if a fluid has already been registered with the same name.
	 *
	 * @param name                 The name of the fluid
	 * @param hasFlowIcon          Does the fluid have a flow icon?
	 * @param fluidPropertyApplier A function that sets the properties of the {@link Fluid}
	 * @param blockFactory         A function that creates the {@link IFluidBlock}
	 * @return The fluid and block
	 */
	private static <T extends Block & IFluidBlock> Fluid createFluid(final String name, final boolean hasFlowIcon, final Consumer<Fluid> fluidPropertyApplier, final Function<Fluid, T> blockFactory) {
		final String texturePrefix = Const.TEXTURE_PREFIX + "blocks/fluids/fluid_";

		final ResourceLocation still = new ResourceLocation(texturePrefix + name + "_still");
		final ResourceLocation flowing = hasFlowIcon ? new ResourceLocation(texturePrefix + name + "_flow") : still;

		Fluid fluid = new Fluid(name, still, flowing);
		final boolean useOwnFluid = FluidRegistry.registerFluid(fluid);

		if (useOwnFluid) {
			fluidPropertyApplier.accept(fluid);
			MOD_FLUID_BLOCKS.add(blockFactory.apply(fluid));
		} else {
			fluid = FluidRegistry.getFluid(name);
		}

		FLUIDS.add(fluid);

		return fluid;
	}
}
