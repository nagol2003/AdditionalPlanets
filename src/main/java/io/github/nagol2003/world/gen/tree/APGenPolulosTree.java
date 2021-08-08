package io.github.nagol2003.world.gen.tree;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class APGenPolulosTree extends APGenTreeBasePolulos {

	public APGenPolulosTree(Block log, Block leaves) {
		super();
		this.setLogBlock(log.getDefaultState());
		this.setLeavesBlock(leaves.getDefaultState());
		this.setMinTrunkSize(11);
		this.setMaxTrunkSize(91);
	}

	public APGenPolulosTree setCanGenerateOnSand() {
		super.setTreesCanGenerateOnSand(true);
		return this;
	}

	@Override
	public boolean generate (World world, Random rand, BlockPos pos) {

		if (!this.isGroundValid(world, pos)) {
			return false;
		}

		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		int i, j, k;
		for (i = 0; i < this.trunkSize; i++) {
			this.placeLogBlock(world, new BlockPos(x, y, z), this.logBlock, this.generateFlag);
			y++;
		}

		int small = (int) Math.ceil(this.crownSize / 2);
		int large = small;

		for (i = 0; i < large; i++) {
			if (!this.noLeaves) {

				for (j = -2; j <= 2; j++) {
					for (k = -2; k <= 2; k++) {
						if (Math.abs(j) + Math.abs(k) != 4
								&& ((j > -2 && k > -2 && j < 2 && k < 2) || rand.nextInt(4) != 0)) {
							this.placeLeavesBlock(world, new BlockPos(x + j, y, z
									+ k), this.leavesBlock, this.generateFlag);
						}
					}
				}
			}
			this.placeLogBlock(world, new BlockPos(x, y, z), this.logBlock, this.generateFlag);
			y++;
		}

		for (i = 0; i < small; i++) {
			if (!this.noLeaves) {

				for (j = -1; j <= 1; j++) {
					for (k = -1; k <= 1; k++) {
						if (Math.abs(j) + Math.abs(k) < 2 || (rand.nextInt(4) != 0)) {
							this.placeLeavesBlock(world, new BlockPos(x + j, y, z
									+ k), this.leavesBlock, this.generateFlag);
						}
					}
				}

				if (i == 0) {
					this.placeLeavesBlock(world, new BlockPos(x + 1, y, z), this.leavesBlock, this.generateFlag);
					this.placeLeavesBlock(world, new BlockPos(x - 1, y, z), this.leavesBlock, this.generateFlag);
					this.placeLeavesBlock(world, new BlockPos(x, y, z + 1), this.leavesBlock, this.generateFlag);
					this.placeLeavesBlock(world, new BlockPos(x, y, z - 1), this.leavesBlock, this.generateFlag);
					this.placeLeavesBlock(world, new BlockPos(x + 2, y, z), this.leavesBlock, this.generateFlag);
					this.placeLeavesBlock(world, new BlockPos(x - 2, y, z), this.leavesBlock, this.generateFlag);
					this.placeLeavesBlock(world, new BlockPos(x, y, z + 2), this.leavesBlock, this.generateFlag);
					this.placeLeavesBlock(world, new BlockPos(x, y, z - 2), this.leavesBlock, this.generateFlag);
				}
			}

			this.placeLogBlock(world, new BlockPos(x, y, z), this.logBlock, this.generateFlag);
			y++;
		}

		this.placeLogBlock(world, new BlockPos(x, y, z), this.logBlock, this.generateFlag);

		if (!this.noLeaves) {
			this.placeLeavesBlock(world, new BlockPos(x + 1, y, z), this.leavesBlock, this.generateFlag);
			
			this.placeLeavesBlock(world, new BlockPos(x + 1, y - 3, z), this.logBlock, this.generateFlag);
			this.placeLeavesBlock(world, new BlockPos(x + 2, y - 2, z), this.logBlock, this.generateFlag);
			
		}

		return true;
	}

}
