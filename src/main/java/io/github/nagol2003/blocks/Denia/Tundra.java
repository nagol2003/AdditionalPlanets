package io.github.nagol2003.blocks.Denia;

import io.github.nagol2003.init.AdditionalPlanetsTab;
import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import micdoodle8.mods.galacticraft.core.blocks.ISortableBlock;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Tundra extends Block implements ISortableBlock, ITerraformableBlock {

	public Tundra() {
		super(Material.GOURD);
		this.setSoundType(SoundType.STONE);
		this.setHardness(2.0f);
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
