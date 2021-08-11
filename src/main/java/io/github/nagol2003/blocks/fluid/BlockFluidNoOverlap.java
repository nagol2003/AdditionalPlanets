package io.github.nagol2003.blocks.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluidNoOverlap extends BlockFluidClassic {

	public BlockFluidNoOverlap(final Fluid fluid, final Material material) {
		super(fluid, material);
	}

    @Override
	public boolean canDisplace(IBlockAccess world, BlockPos pos)
    {
        IBlockState state = world.getBlockState(pos);
        Block block = state.getBlock();

        if(state.getMaterial() instanceof MaterialLiquid) {
        	return false;
        }

        return super.canDisplace(world, pos);
    }
}
