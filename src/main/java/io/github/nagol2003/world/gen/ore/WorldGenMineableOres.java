package io.github.nagol2003.world.gen.ore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenMineableOres extends WorldGenerator {

	protected int blocksPerVein;
	protected int veinsPerChunk;
	protected int minY;
	protected int maxY;
	protected IBlockState ore;
	protected List<IBlockState> predicate = new ArrayList<>();

	public WorldGenMineableOres(Block oreBlock, int blocksPerVein, int veinsPerChunk, int startY, int endY,
			IBlockState... replaceTargets) {
		this(oreBlock, blocksPerVein, veinsPerChunk, startY, endY);
		for (IBlockState state : replaceTargets) {
			this.predicate.add(state);
		}
	}

	private WorldGenMineableOres(Block oreBlock, int blocksPerVein, int veinsPerChunk, int startY, int endY) {
		this.ore = oreBlock.getDefaultState();
		this.blocksPerVein = blocksPerVein;
		this.veinsPerChunk = veinsPerChunk;
		this.minY = startY;
		this.maxY = endY;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {

		float f = rand.nextFloat() * (float) Math.PI;
		double d0 = position.getX() + 8 + MathHelper.sin(f) * this.blocksPerVein / 8.0F;
		double d1 = position.getX() + 8 - MathHelper.sin(f) * this.blocksPerVein / 8.0F;
		double d2 = position.getZ() + 8 + MathHelper.cos(f) * this.blocksPerVein / 8.0F;
		double d3 = position.getZ() + 8 - MathHelper.cos(f) * this.blocksPerVein / 8.0F;
		double d4 = position.getY() + rand.nextInt(3) - 2;
		double d5 = position.getY() + rand.nextInt(3) - 2;

		for (int i = 0; i < this.blocksPerVein; ++i) {
			float f1 = i / (float) this.blocksPerVein;
			double d6 = d0 + (d1 - d0) * f1;
			double d7 = d4 + (d5 - d4) * f1;
			double d8 = d2 + (d3 - d2) * f1;
			double d9 = rand.nextDouble() * this.blocksPerVein / 16.0D;
			double d10 = (MathHelper.sin((float) Math.PI * f1) + 1.0F) * d9 + 1.0D;
			double d11 = (MathHelper.sin((float) Math.PI * f1) + 1.0F) * d9 + 1.0D;
			int j = MathHelper.floor(d6 - d10 / 2.0D);
			int k = MathHelper.floor(d7 - d11 / 2.0D);
			int l = MathHelper.floor(d8 - d10 / 2.0D);
			int i1 = MathHelper.floor(d6 + d10 / 2.0D);
			int j1 = MathHelper.floor(d7 + d11 / 2.0D);
			int k1 = MathHelper.floor(d8 + d10 / 2.0D);

			for (int l1 = j; l1 <= i1; ++l1) {
				double d12 = (l1 + 0.5D - d6) / (d10 / 2.0D);

				if (d12 * d12 < 1.0D) {
					for (int i2 = k; i2 <= j1; ++i2) {
						double d13 = (i2 + 0.5D - d7) / (d11 / 2.0D);

						if (d12 * d12 + d13 * d13 < 1.0D) {
							for (int j2 = l; j2 <= k1; ++j2) {
								double d14 = (j2 + 0.5D - d8) / (d10 / 2.0D);

								if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D) {
									BlockPos blockpos = new BlockPos(l1, i2, j2);

									IBlockState state = worldIn.getBlockState(blockpos);
									if (this.predicate.contains(state)) {
										worldIn.setBlockState(blockpos, this.ore, 2);
									}
								}
							}
						}
					}
				}
			}
		}

		return true;
	}
}
