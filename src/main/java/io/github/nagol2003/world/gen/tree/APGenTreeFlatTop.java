package io.github.nagol2003.world.gen.tree;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class APGenTreeFlatTop extends APGenTreeBase {

	public APGenTreeFlatTop(Block log, Block leaves) {
		super(true);
		this.setLogBlock(log.getDefaultState());
		this.setLeavesBlock(leaves.getDefaultState());
		this.trunkSize = 10;
		this.setMaxCrownSize(5);
		this.setMinCrownSize(3);
	}

	@Override
	public boolean generate (World world, Random rand, BlockPos pos) {
		if (!this.isGroundValid(world, pos)) {
			return false;
		}

		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		int h  = this.trunkSize;
		int bh = h - 6;

		for (int i = 0; i < h; i++) {
			this.placeLogBlock(world, new BlockPos(x, y + i, z), this.logBlock, this.generateFlag);
		}
		genLeaves(world, rand, x, y + h, z);

		int   sh, dir;
		float xd, yd, c;

		for (int a = 6 + rand.nextInt(3); a > -1; a--) {
			sh  = bh + rand.nextInt(4);
			dir = rand.nextInt(360);
			xd  = (float) Math.cos((dir * Math.PI) / 180f) * 2f;
			yd  = (float) Math.sin((dir * Math.PI) / 180f) * 2f;
			c   = 1;

			while (sh < h) {
				this.placeLogBlock(world, new BlockPos(x + (int) (xd * c), y + sh, z
						+ (int) (yd * c)), this.logBlock, this.generateFlag);
				sh++;
				c += 0.5f;
			}
			genLeaves(world, rand, x + (int) (xd * c), y + sh, z + (int) (yd * c));
		}

		return true;
	}

	public void genLeaves (World world, Random rand, int x, int y, int z) {

		if (!this.noLeaves) {

			int i;
			int j;
			for (i = -2; i <= 2; i++) {
				for (j = -2; j <= 2; j++) {
					if ((Math.abs(i) + Math.abs(j)) < 4) {
						this.placeLeavesBlock(world, new BlockPos(x + i, y + 1, z
								+ j), this.leavesBlock, this.generateFlag);
					}
				}
			}

			for (i = -3; i <= 3; i++) {
				for (j = -3; j <= 3; j++) {
					if ((Math.abs(i) + Math.abs(j)) < 5) {
						this.placeLeavesBlock(world, new BlockPos(x + i, y, z
								+ j), this.leavesBlock, this.generateFlag);
					}
				}
			}
		}

		this.placeLogBlock(world, new BlockPos(x, y, z), this.logBlock, this.generateFlag);
	}

}
