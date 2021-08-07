package io.github.nagol2003.blocks.state;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

public class MultiBlockMatcher implements Predicate<IBlockState> {

	private final List<Block> blockList;

	private MultiBlockMatcher(List<Block> blockList) {
		this.blockList = blockList;
	}

	public static MultiBlockMatcher ofBlocks(Block... blocks) {
		return new MultiBlockMatcher(Lists.newArrayList(blocks));
	}

	@Override
	public boolean apply(@Nullable IBlockState blockstate) {
		return blockstate != null && this.blockList.contains(blockstate.getBlock());
	}

}
