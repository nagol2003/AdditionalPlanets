package io.github.nagol2003.blocks.Polulos;

import io.github.nagol2003.init.AdditionalPlanetsTab;
import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import micdoodle8.mods.galacticraft.core.blocks.ISortableBlock;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PolulosRock extends Block implements ISortableBlock, ITerraformableBlock {

	public PolulosRock() {
		super(Material.ROCK);
		this.setSoundType(SoundType.STONE);
		this.setHardness(3.0f);
		this.setHarvestLevel("pickaxe", 2);
		this.setCreativeTab(AdditionalPlanetsTab.blockTab);

	}

	@Override
	public boolean isTerraformable(World world, BlockPos pos) {
		return false;
	}

	@Override
	public EnumSortCategoryBlock getCategory(int meta) {
		return EnumSortCategoryBlock.DECORATION;
	}
	
}
