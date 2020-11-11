package io.github.nagol2003.blocks;

import java.util.Random;

import io.github.nagol2003.init.AdditionalPlanetsTab;
import io.github.nagol2003.init.InitBlocks;
import io.github.nagol2003.init.InitItems;
import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import micdoodle8.mods.galacticraft.core.blocks.ISortableBlock;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StrangeMetallic extends Block implements ISortableBlock, ITerraformableBlock {
	
	  public Item getItemDropped(IBlockState state, Random rand, int fortune)
	  {
		  {
	        if (this == InitBlocks.STRANGEMETALLIC);
	  };
	            return InitItems.STRANGE_METALLIC_SUBSTANCE;
	    }

	        public StrangeMetallic() {
	    		super(Material.ROCK);
	    		this.setSoundType(SoundType.STONE);
	    		this.setHardness(5.0f);
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
