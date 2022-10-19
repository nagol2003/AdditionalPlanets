package io.github.nagol2003.world.gen.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public abstract class APGenTreeBaseTestHerobrine extends WorldGenAbstractTree {

	protected IBlockState logBlock;
	protected IBlockState signBlock;
	protected IBlockState leavesBlock;
	protected int trunkSize;
	protected int crownSize;
	protected boolean noLeaves;
	protected boolean treesCanGenerateOnSand;

	protected IBlockState saplingBlock;

	protected int generateFlag;

	protected int minTrunkSize;
	protected int maxTrunkSize;
	protected int minCrownSize;
	protected int maxCrownSize;

	protected ArrayList<Material> canGrowIntoMaterials;

	public APGenTreeBaseTestHerobrine(boolean notify) {
		super(notify);
	}

	public APGenTreeBaseTestHerobrine() {
		this(false);

		this.setLogBlock(Blocks.LOG.getDefaultState());
		this.setSignBlock(Blocks.WALL_SIGN.getDefaultState());
		this.setLeavesBlock(Blocks.LEAVES.getDefaultState());
		this.trunkSize = 4;
		this.crownSize = 1;
		this.setNoLeaves(false);
		this.setTreesCanGenerateOnSand(false);

		this.saplingBlock = Blocks.SAPLING.getDefaultState();

		this.generateFlag = 2;

		// These need to default to zero as they're only used when generating trees from saplings.
		this.setMinTrunkSize(0);
		this.setMaxTrunkSize(0);
		this.setMinCrownSize(0);
		this.setMaxCrownSize(0);

		this.canGrowIntoMaterials = new ArrayList<>(Arrays.asList(
				Material.AIR,
				Material.WOOD,
				Material.LEAVES,
				Material.GRASS,
				Material.GROUND,
				Material.PLANTS,
				Material.VINE,
				Material.WATER,
				Material.SNOW
				));
	}

	public void buildTrunk(World world, Random rand, int x, int y, int z) {

	}

	public void buildBranch(World world, Random rand, int x, int y, int z, int dX, int dZ, int logLength, int leaveSize) {

	}

	public void buildLeaves(World world, int x, int y, int z) {

	}

	public void buildLeaves(World world, Random rand, int x, int y, int z, int size) {

	}

	protected boolean isGroundValid(World world, BlockPos trunkPos) {

		return this.isGroundValid(world, trunkPos, this.treesCanGenerateOnSand);
	}

	protected boolean isGroundValid(World world, BlockPos trunkPos, boolean sandAllowed) {

		IBlockState g = world.getBlockState(new BlockPos(trunkPos.getX(), trunkPos.getY() - 1, trunkPos.getZ()));

		if (g.getBlock() == Blocks.SAND && !sandAllowed) {
			return false;
		}

		if(g.getBlock() == Blocks.AIR || g.getBlock() == Blocks.WATER) {
			return false;
		}

		return true;
	}

	protected boolean isGroundValid(World world, ArrayList<BlockPos> trunkPos) {

		if (trunkPos.isEmpty()) {
			throw new RuntimeException("Unable to determine if ground is valid. No trunks.");
		}

		for (BlockPos element : trunkPos) {
			if (!this.isGroundValid(world, element)) {
				return false;
			}
		}

		return true;
	}

	protected void placeLogBlock(World world, BlockPos pos, IBlockState logBlock, int generateFlag) {

		if (this.isReplaceable(world, pos)) {
			world.setBlockState(pos, logBlock, generateFlag);
		}
	}
	
	protected void placeSignBlock(World world, BlockPos pos, IBlockState signBlock, int generateFlag) {

		if (this.isReplaceable(world, pos)) {
			world.setBlockState(pos, signBlock, generateFlag);
		}
	}

	protected void placeLeavesBlock(World world, BlockPos pos, IBlockState leavesBlock, int generateFlag) {

		if (world.isAirBlock(pos)) {
			world.setBlockState(pos, leavesBlock, generateFlag);
		}
	}

	protected void placeLogBlock(World world, BlockPos pos, IBlockState logBlock, int generateFlag, APGenTreeData treeData) {

		this.placeLogBlock(world, pos, logBlock, generateFlag);
	}
	
	protected void placeSignBlock(World world, BlockPos pos, IBlockState signBlock, int generateFlag, APGenTreeData treeData) {

		this.placeSignBlock(world, pos, signBlock, generateFlag);
	}

	protected void placeLeavesBlock(World world, BlockPos pos, IBlockState leavesBlock, int generateFlag, APGenTreeData treeData) {

		this.placeLeavesBlock(world, pos, leavesBlock, generateFlag);
	}

	@Override
	public boolean isReplaceable(World world, BlockPos pos) {

		IBlockState state = world.getBlockState(pos);

		return state.getBlock().isAir(state, world, pos)
				|| state.getBlock().isLeaves(state, world, pos)
				|| state.getBlock().isWood(world, pos)
				|| canGrowInto(state.getBlock());
	}

	@Override
	protected boolean canGrowInto(Block block) {

		if (block instanceof BlockPlanks) {
			return false;
		}

		Material material = block.getDefaultState().getMaterial();

		for (Material element : this.canGrowIntoMaterials) {
			if (material == element) {
				return true;
			}
		}

		return false;
	}

	public IBlockState getTrunkLog(IBlockState defaultLog) {

		IBlockState trunkLog;

		try {
			trunkLog = defaultLog.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.NONE);
		}
		catch (Exception e) {
			trunkLog = defaultLog;
		}

		return trunkLog;
	}

	public IBlockState getLogBlock() {

		return logBlock;
	}

	public APGenTreeBaseTestHerobrine setLogBlock(IBlockState logBlock) {

		this.logBlock = logBlock;
		return this;
	}
	
	public IBlockState getSignBlock() {

		return signBlock;
	}

	public APGenTreeBaseTestHerobrine setSignBlock(IBlockState signBlock) {

		this.signBlock = signBlock;
		return this;
	}

	public IBlockState getLeavesBlock() {

		return leavesBlock;
	}

	public APGenTreeBaseTestHerobrine setLeavesBlock(IBlockState leavesBlock) {

		this.leavesBlock = leavesBlock;
		return this;
	}

	public int getTrunkSize() {

		return trunkSize;
	}

	public APGenTreeBaseTestHerobrine setTrunkSize(int trunkSize) {

		this.trunkSize = trunkSize;
		return this;
	}

	public int getCrownSize() {

		return crownSize;
	}

	public APGenTreeBaseTestHerobrine setCrownSize(int crownSize) {

		this.crownSize = crownSize;
		return this;
	}

	public boolean getNoLeaves() {

		return noLeaves;
	}

	public APGenTreeBaseTestHerobrine setNoLeaves(boolean noLeaves) {

		this.noLeaves = noLeaves;
		return this;
	}

	public APGenTreeBaseTestHerobrine setTreesCanGenerateOnSand(boolean notOnSand) {
		this.treesCanGenerateOnSand = notOnSand;
		return this;
	}

	public IBlockState getSaplingBlock() {

		return saplingBlock;
	}

	public APGenTreeBaseTestHerobrine setSaplingBlock(IBlockState saplingBlock) {

		this.saplingBlock = saplingBlock;
		return this;
	}

	public int getGenerateFlag() {

		return generateFlag;
	}

	public APGenTreeBaseTestHerobrine setGenerateFlag(int generateFlag) {

		this.generateFlag = generateFlag;
		return this;
	}

	public int getMinTrunkSize() {

		return minTrunkSize;
	}

	public APGenTreeBaseTestHerobrine setMinTrunkSize(int minTrunkSize) {

		this.minTrunkSize = minTrunkSize;
		return this;
	}

	public int getMaxTrunkSize() {

		return maxTrunkSize;
	}

	public APGenTreeBaseTestHerobrine setMaxTrunkSize(int maxTrunkSize) {

		this.maxTrunkSize = maxTrunkSize;
		return this;
	}

	public int getMinCrownSize() {

		return minCrownSize;
	}

	public APGenTreeBaseTestHerobrine setMinCrownSize(int minCrownSize) {

		this.minCrownSize = minCrownSize;
		return this;
	}

	public int getMaxCrownSize() {

		return maxCrownSize;
	}

	public APGenTreeBaseTestHerobrine setMaxCrownSize(int maxCrownSize) {

		this.maxCrownSize = maxCrownSize;
		return this;
	}
}
