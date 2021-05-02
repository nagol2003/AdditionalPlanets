package io.github.nagol2003.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Optional;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockSponge;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.MutableBlockPos;
import net.minecraft.world.World;

public final class BlockUtil {

	@Nullable
	public static Block getBlock(@Nullable final String resourceLocation) {
		return (!StringUtils.isEmpty(resourceLocation)) ? getBlock(new ResourceLocation(resourceLocation)) : null;
	}

	@Nullable
	public static Block getBlock(@Nullable final ResourceLocation resourceLocation) {
		return (resourceLocation != null && Block.REGISTRY.containsKey(resourceLocation)) ? Block.REGISTRY.getObject(resourceLocation) : null;
	}

	public static Block getBlock(@Nullable final String resourceLocation, final Block fallback) {
		return (!StringUtils.isEmpty(resourceLocation)) ? getBlock(new ResourceLocation(resourceLocation), fallback) : fallback;
	}

	public static Block getBlock(@Nullable final ResourceLocation resourceLocation, final Block fallback) {
		Block block = getBlock(resourceLocation);
		return (block != null) ? block : fallback;
	}

	public static IBlockState getPossibleState(final Block block, final String propertyName, final String valueName, IBlockState fallback) {
		if (StringUtils.isEmpty(propertyName) || StringUtils.isEmpty(valueName)) {
			return fallback;
		}
		IBlockState bs = getPossibleState(block, propertyName, valueName);
		return bs != null ? bs : fallback;
	}

	@Nullable
	public static IBlockState getPossibleState(final Block block, final String propertyName, final String valueName) {
		if (StringUtils.isEmpty(propertyName) || StringUtils.isEmpty(valueName)) {
			return null;
		}
		IProperty<?> property = block.getBlockState().getProperty(propertyName);
		return (property != null) ? getPossibleState(block.getDefaultState(), property, valueName) : null;
	}

	@Nullable
	public static IBlockState getPossibleState(final IBlockState blockState, final String propertyName, final String valueName) {
		if (StringUtils.isEmpty(propertyName) || StringUtils.isEmpty(valueName)) {
			return null;
		}
		IProperty<?> property = blockState.getBlock().getBlockState().getProperty(propertyName);
		return (property != null) ? getPossibleState(blockState, property, valueName) : null;
	}

	public static <T extends Comparable<T>> IBlockState getPossibleState(final IBlockState blockstate, final IProperty<T> propname, final String valueName) {
		if (StringUtils.isEmpty(valueName)) {
			return blockstate;
		}
		Optional<T> value = propname.parseValue(valueName);
		return value.isPresent() ? blockstate.withProperty(propname, value.get()) : blockstate;
	}

	public static IBlockState getStateStone(final BlockStone.EnumType variant) {
		switch (variant) {
			case STONE:
				return Blocks.STONE.getDefaultState();
			case GRANITE:
				return Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE);
			case GRANITE_SMOOTH:
				return Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE_SMOOTH);
			case DIORITE:
				return Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE);
			case DIORITE_SMOOTH:
				return Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE_SMOOTH);
			case ANDESITE:
				return Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE);
			case ANDESITE_SMOOTH:
				return Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE_SMOOTH);
		}
		return Blocks.STONE.getDefaultState();
	}

	public static IBlockState getStateDirt(final BlockDirt.DirtType variant) {
		switch (variant) {
			case DIRT:
				return Blocks.DIRT.getDefaultState();
			case COARSE_DIRT:
				return Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
			case PODZOL:
				return Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.PODZOL);
		}
		return Blocks.DIRT.getDefaultState();
	}

	public static IBlockState getStateSand(final BlockSand.EnumType variant) {
		switch (variant) {
			case SAND:
				return Blocks.SAND.getDefaultState();
			case RED_SAND:
				return Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND);
		}
		return Blocks.SAND.getDefaultState();
	}

	public static IBlockState getStateClay(final EnumDyeColor color) {
		switch (color) {
			case WHITE:
				return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE);
			case ORANGE:
				return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE);
			case MAGENTA:
				return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.MAGENTA);
			case LIGHT_BLUE:
				return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.LIGHT_BLUE);
			case YELLOW:
				return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW);
			case LIME:
				return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.LIME);
			case PINK:
				return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.PINK);
			case GRAY:
				return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.GRAY);
			case SILVER:
				return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER);
			case CYAN:
				return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.CYAN);
			case PURPLE:
				return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.PURPLE);
			case BLUE:
				return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BLUE);
			case BROWN:
				return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN);
			case GREEN:
				return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.GREEN);
			case RED:
				return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.RED);
			case BLACK:
				return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BLACK);
		}
		return Blocks.HARDENED_CLAY.getDefaultState();
	}

	public static IBlockState getStateLog(final BlockPlanks.EnumType variant) {
		switch (variant) {
			case OAK:
				return Blocks.LOG.getDefaultState();
			case SPRUCE:
				return Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);
			case BIRCH:
				return Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH);
			case JUNGLE:
				return Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
			case ACACIA:
				return Blocks.LOG2.getDefaultState();
			case DARK_OAK:
				return Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK);
		}
		return Blocks.LOG.getDefaultState();
	}

	public static IBlockState getStateLeaf(final BlockPlanks.EnumType variant) {
		switch (variant) {
			case OAK:
				return Blocks.LEAVES.getDefaultState();
			case SPRUCE:
				return Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE);
			case BIRCH:
				return Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.BIRCH);
			case JUNGLE:
				return Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE);
			case ACACIA:
				return Blocks.LEAVES2.getDefaultState();
			case DARK_OAK:
				return Blocks.LEAVES2.getDefaultState().withProperty(BlockNewLeaf.VARIANT, BlockPlanks.EnumType.DARK_OAK);
		}
		return Blocks.LEAVES.getDefaultState();
	}

	public static IBlockState getStateSapling(final BlockPlanks.EnumType type) {
		switch (type) {
			case OAK:
				return Blocks.SAPLING.getDefaultState();
			case SPRUCE:
				return Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.SPRUCE);
			case BIRCH:
				return Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.BIRCH);
			case JUNGLE:
				return Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.JUNGLE);
			case ACACIA:
				return Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.ACACIA);
			case DARK_OAK:
				return Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.DARK_OAK);
		}
		return Blocks.SAPLING.getDefaultState();
	}

	public static IBlockState getSponge(final boolean wet) {
		return wet ? Blocks.SPONGE.getDefaultState().withProperty(BlockSponge.WET, true) : Blocks.SPONGE.getDefaultState();
	}

	public static IBlockState getStateFlower(final BlockFlower.EnumFlowerType type) {
		switch (type) {
			case DANDELION:
				return Blocks.YELLOW_FLOWER.getDefaultState().withProperty(Blocks.YELLOW_FLOWER.getTypeProperty(), type);
			case POPPY:
			case BLUE_ORCHID:
			case ALLIUM:
			case HOUSTONIA:
			case RED_TULIP:
			case ORANGE_TULIP:
			case WHITE_TULIP:
			case PINK_TULIP:
			case OXEYE_DAISY:
				return Blocks.RED_FLOWER.getDefaultState().withProperty(Blocks.RED_FLOWER.getTypeProperty(), type);
		}
		return Blocks.RED_FLOWER.getDefaultState();// unreachable
	}

	public static IBlockState getStateDoublePlant(final BlockDoublePlant.EnumPlantType variant) {
		switch (variant) {
			case SUNFLOWER:
				return Blocks.DOUBLE_PLANT.getDefaultState().withProperty(BlockDoublePlant.VARIANT, BlockDoublePlant.EnumPlantType.SUNFLOWER);
			case SYRINGA:
				return Blocks.DOUBLE_PLANT.getDefaultState().withProperty(BlockDoublePlant.VARIANT, BlockDoublePlant.EnumPlantType.SYRINGA);
			case GRASS:
				return Blocks.DOUBLE_PLANT.getDefaultState().withProperty(BlockDoublePlant.VARIANT, BlockDoublePlant.EnumPlantType.GRASS);
			case FERN:
				return Blocks.DOUBLE_PLANT.getDefaultState().withProperty(BlockDoublePlant.VARIANT, BlockDoublePlant.EnumPlantType.FERN);
			case ROSE:
				return Blocks.DOUBLE_PLANT.getDefaultState().withProperty(BlockDoublePlant.VARIANT, BlockDoublePlant.EnumPlantType.ROSE);
			case PAEONIA:
				return Blocks.DOUBLE_PLANT.getDefaultState().withProperty(BlockDoublePlant.VARIANT, BlockDoublePlant.EnumPlantType.PAEONIA);
		}
		return Blocks.DOUBLE_PLANT.getDefaultState();
	}

	public static IBlockState getSaplingFromLeaves(IBlockState leaves, IBlockState fallback) {
		IBlockState ret;
		return (ret = getSaplingFromLeaves(leaves)) != null ? ret : fallback;
	}

	@Nullable
	public static IBlockState getSaplingFromLeaves(IBlockState leaves) {
		if (!(leaves.getBlock() instanceof BlockLeaves)) { return null; }
		BlockPlanks.EnumType type = (BlockPlanks.EnumType) leaves.getProperties().get(BlockOldLeaf.VARIANT);
		if (type == null) { type = (BlockPlanks.EnumType) leaves.getProperties().get(BlockNewLeaf.VARIANT); }
		if (type != null) {
			switch (type) {
				case OAK     : return Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.OAK);
				case SPRUCE  : return Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.SPRUCE);
				case BIRCH   : return Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.BIRCH);
				case JUNGLE  : return Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.JUNGLE);
				case ACACIA  : return Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.ACACIA);
				case DARK_OAK: return Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.DARK_OAK);
			}
		}
		return null;
	}

	@Nullable
	public static BlockPlanks.EnumType getTypeFromSapling(IBlockState sapling) {
		if (!(sapling.getBlock() instanceof BlockSapling)) { return null; }
		BlockPlanks.EnumType ret = null;
		try { ret = sapling.getValue(BlockSapling.TYPE); }
		catch (IllegalArgumentException ignore) {}
		return ret;
	}

	public static boolean isBlockAir(final IBlockState blockState) {
		return blockState.getBlock() == Blocks.AIR;
	}

	public static boolean isBlockAir(final Block block) {
		return block == Blocks.AIR;
	}

	public static boolean isMaterialAir(final IBlockState blockState) {
		return blockState.getMaterial() == Material.AIR;
	}

	public static boolean isMaterialAir(final Block block) {
		return block.getDefaultState().getMaterial() == Material.AIR;
	}

	public static boolean isMaterialAir(final Material material) {
		return material == Material.AIR;
	}

	public static boolean isBlock(final World world, final BlockPos origin, final Block block) {
		return world.getBlockState(origin).getBlock() == block;
	}

	public static boolean isBlockOneOf(final World world, final BlockPos origin, final Block... validBlocks) {
		return isBlockOneOf(world, origin, Collections.unmodifiableCollection(Arrays.asList(validBlocks)));
	}

	public static boolean isBlockOneOf(final World world, final BlockPos origin, final Collection<Block> validBlocks) {
		final Block checkBlock = world.getBlockState(origin).getBlock();
		return (validBlocks.isEmpty()) ? isBlockAir(checkBlock) : validBlocks.contains(checkBlock);
	}

	public static boolean isMaterial(final World world, final BlockPos origin, final Material material) {
		return world.getBlockState(origin).getMaterial() == material;
	}

	public static boolean isMaterialOneOf(final World world, final BlockPos origin, final Material... validMaterials) {
		return isMaterialOneOf(world, origin, Collections.unmodifiableCollection(Arrays.asList(validMaterials)));
	}

	public static boolean isMaterialOneOf(final World world, final BlockPos origin, final Collection<Material> validMaterials) {
		final Material checkMaterial = world.getBlockState(origin).getMaterial();
		return (validMaterials.isEmpty()) ? isMaterialAir(checkMaterial) : validMaterials.contains(checkMaterial);
	}

	public static boolean isReplaceable(final World world, final BlockPos origin) {
		return world.getBlockState(origin).getMaterial().isReplaceable();
	}

	public static boolean checkAdjacentBlocks(final MatchType matchType, final World world, final BlockPos origin, final Block... validBlocks) {
		return checkAdjacentBlocks(matchType, world, origin, Collections.unmodifiableCollection(Arrays.asList(validBlocks)));
	}

	public static boolean checkAdjacentBlocks(final MatchType matchType, final World world, final BlockPos origin, final Collection<Block> validBlocks) {

		final boolean ignoreReplaceable = matchType == MatchType.ALL_IGNORE_REPLACEABLE;

		switch (matchType) {

			case ALL_IGNORE_REPLACEABLE:
			case ALL:
				for (EnumFacing direction : EnumFacing.HORIZONTALS) {
					final IBlockState bs = world.getBlockState(origin.offset(direction));
					if ((ignoreReplaceable && !bs.getMaterial().isReplaceable()) ||
							(validBlocks.isEmpty()) ? !isBlockAir(bs) : !validBlocks.contains(bs.getBlock())) {
						return false;
					}
				}
				return true;

			case ANY:
				for (EnumFacing direction : EnumFacing.HORIZONTALS) {
					final Block block = world.getBlockState(origin.offset(direction)).getBlock();
					if ((validBlocks.isEmpty()) ? isBlockAir(block) : !validBlocks.contains(block)) {
						return true;
					}
				}
				return false;

			case NONE:
				for (EnumFacing direction : EnumFacing.HORIZONTALS) {
					final Block block = world.getBlockState(origin.offset(direction)).getBlock();
					if ((validBlocks.isEmpty()) ? isBlockAir(block) : !validBlocks.contains(block)) {
						return false;
					}
				}
				return true;
		}
		return false;// unreachable
	}

	public static boolean checkAdjacentMaterials(final MatchType matchType, final World world, final BlockPos origin, final Material... validMaterials) {
		return checkAdjacentMaterials(matchType, world, origin, Collections.unmodifiableCollection(Arrays.asList(validMaterials)));
	}

	public static boolean checkAdjacentMaterials(final MatchType matchType, final World world, final BlockPos origin, final Collection<Material> validMaterials) {

		final boolean ignoreReplaceable = matchType == MatchType.ALL_IGNORE_REPLACEABLE;

		switch (matchType) {

			case ALL_IGNORE_REPLACEABLE:
			case ALL:
				for (EnumFacing direction : EnumFacing.HORIZONTALS) {
					final Material material = world.getBlockState(origin.offset(direction)).getMaterial();
					if ((ignoreReplaceable && !material.isReplaceable()) ||
							(validMaterials.isEmpty()) ? !isMaterialAir(material) : !validMaterials.contains(material)) {
						return false;
					}
				}
				return true;

			case ANY:
				for (EnumFacing direction : EnumFacing.HORIZONTALS) {
					final Material material = world.getBlockState(origin.offset(direction)).getMaterial();
					if ((validMaterials.isEmpty()) ? isMaterialAir(material) : validMaterials.contains(material)) {
						return true;
					}
				}
				return false;

			case NONE:
				for (EnumFacing direction : EnumFacing.HORIZONTALS) {
					final Material material = world.getBlockState(origin.offset(direction)).getMaterial();
					if ((validMaterials.isEmpty()) ? isMaterialAir(material) : validMaterials.contains(material)) {
						return false;
					}
				}
				return true;
		}
		return false;
	}

	public static boolean checkVerticalBlocks(final MatchType matchType, final World world, final BlockPos origin, final int distance, final Block... validBlocks) {
		return checkVerticalBlocks(matchType, world, origin, distance, Collections.unmodifiableCollection(Arrays.asList(validBlocks)));
	}

	public static boolean checkVerticalBlocks(final MatchType matchType, final World world, final BlockPos origin, final int distance, final Collection<Block> validBlocks) {

		final int
		ox = origin.getX(),
		oy = origin.getY(),
		oz = origin.getZ();
		final int dis = Math.abs(distance);
		final boolean invert = distance < 0;
		final boolean ignoreReplaceable = matchType == MatchType.ALL_IGNORE_REPLACEABLE;
		final MutableBlockPos mpos = new MutableBlockPos();

		switch (matchType) {

			case ALL_IGNORE_REPLACEABLE:
			case ALL:
				for (int i = dis; i > 0; i--) {
					final IBlockState bs = world.getBlockState(mpos.setPos(ox, oy + (invert ? -i : i), oz));
					if ((ignoreReplaceable && !bs.getMaterial().isReplaceable()) ||
							(validBlocks.isEmpty()) ? !isBlockAir(bs) : !validBlocks.contains(bs.getBlock())) {
						return false;
					}
				}
				return true;

			case ANY:
				for (int i = dis; i > 0; i--) {
					final Block block = world.getBlockState(mpos.setPos(ox, oy + (invert ? -i : i), oz)).getBlock();
					if ((validBlocks.isEmpty()) ? isBlockAir(block) : validBlocks.contains(block)) {
						return true;
					}
				}
				return false;

			case NONE:
				for (int i = dis; i > 0; i--) {
					final Block block = world.getBlockState(mpos.setPos(ox, oy + (invert ? -i : i), oz)).getBlock();
					if ((validBlocks.isEmpty()) ? isBlockAir(block) : validBlocks.contains(block)) {
						return false;
					}
				}
				return true;
		}
		return false;
	}

	public static boolean checkVerticalMaterials(final MatchType matchType, final World world, final BlockPos origin, final int distance, final Material... validMaterials) {
		return checkVerticalMaterials(matchType, world, origin, distance, Collections.unmodifiableCollection(Arrays.asList(validMaterials)));
	}

	public static boolean checkVerticalMaterials(final MatchType matchType, final World world, final BlockPos origin, final int distance, final Collection<Material> validMaterials) {

		final int
		ox = origin.getX(),
		oy = origin.getY(),
		oz = origin.getZ();
		final int dis = Math.abs(distance);
		final boolean invert = distance < 0;
		final boolean ignoreReplaceable = matchType == MatchType.ALL_IGNORE_REPLACEABLE;
		MutableBlockPos mpos = new MutableBlockPos();

		switch (matchType) {

			case ALL_IGNORE_REPLACEABLE:
			case ALL:
				for (int i = dis; i > 0; i--) {
					final Material material = world.getBlockState(mpos.setPos(ox, oy + (invert ? -i : i), oz)).getMaterial();
					if ((ignoreReplaceable && !material.isReplaceable()) ||
							(validMaterials.isEmpty()) ? !isMaterialAir(material) : !validMaterials.contains(material)) {
						return false;
					}
				}
				return true;

			case ANY:
				for (int i = dis; i > 0; i--) {
					final Material material = world.getBlockState(mpos.setPos(ox, oy + (invert ? -i : i), oz)).getMaterial();
					if ((validMaterials.isEmpty()) ? isMaterialAir(material) : validMaterials.contains(material)) {
						return true;
					}
				}
				return false;

			case NONE:
				for (int i = dis; i > 0; i--) {
					final Material material = world.getBlockState(mpos.setPos(ox, oy + (invert ? -i : i), oz)).getMaterial();
					if ((validMaterials.isEmpty()) ? isMaterialAir(material) : validMaterials.contains(material)) {
						return false;
					}
				}
				return true;
		}
		return false;
	}

	public static boolean checkAreaBlocks(final MatchType matchType, final World world, final BlockPos origin, final int checkRadius, final Block... validBlocks) {
		return checkAreaBlocks(matchType, world, origin, checkRadius, Collections.unmodifiableCollection(Arrays.asList(validBlocks)));
	}

	public static boolean checkAreaBlocks(final MatchType matchType, final World world, final BlockPos origin, final int checkRadius, final Collection<Block> validBlocks) {

		final int
		ox = origin.getX(),
		oy = origin.getY(),
		oz = origin.getZ();
		final boolean ignoreReplaceable = matchType == MatchType.ALL_IGNORE_REPLACEABLE;
		MutableBlockPos mpos = new MutableBlockPos();
		int x, z, i = 1;
		IBlockState bs;

		switch (matchType) {

			case ALL_IGNORE_REPLACEABLE:
			case ALL:
				while (i <= checkRadius) {
					x = ox + i;
					z = oz + i;
					for (; x > ox - i; ) {
						bs = world.getBlockState(mpos.setPos(--x, oy, z));
						if ((ignoreReplaceable && !bs.getMaterial().isReplaceable()) ||
								(validBlocks.isEmpty()) ? !isBlockAir(bs) : !validBlocks.contains(bs.getBlock())) {
							return false;
						}
					}
					for (; z > oz - i; ) {
						bs = world.getBlockState(mpos.setPos(x, oy, --z));
						if ((ignoreReplaceable && !bs.getMaterial().isReplaceable()) ||
								(validBlocks.isEmpty()) ? !isBlockAir(bs) : !validBlocks.contains(bs.getBlock())) {
							return false;
						}
					}
					for (; x < ox + i; ) {
						bs = world.getBlockState(mpos.setPos(++x, oy, z));
						if ((ignoreReplaceable && !bs.getMaterial().isReplaceable()) ||
								(validBlocks.isEmpty()) ? !isBlockAir(bs) : !validBlocks.contains(bs.getBlock())) {
							return false;
						}
					}
					for (; z < oz + i; ) {
						bs = world.getBlockState(mpos.setPos(x, oy, ++z));
						if ((ignoreReplaceable && !bs.getMaterial().isReplaceable()) ||
								(validBlocks.isEmpty()) ? !isBlockAir(bs) : !validBlocks.contains(bs.getBlock())) {
							return false;
						}
					}
					i++;
				}
				return true;

			case ANY:
				while (i <= checkRadius) {
					x = ox + i;
					z = oz + i;
					for (; x > ox - i; ) {
						bs = world.getBlockState(mpos.setPos(--x, oy, z));
						if ((validBlocks.isEmpty()) ? isBlockAir(bs) : validBlocks.contains(bs.getBlock())) {
							return true;
						}
					}
					for (; z > oz - i; ) {
						bs = world.getBlockState(mpos.setPos(x, oy, --z));
						if ((validBlocks.isEmpty()) ? isBlockAir(bs) : validBlocks.contains(bs.getBlock())) {
							return true;
						}
					}
					for (; x < ox + i; ) {
						bs = world.getBlockState(mpos.setPos(++x, oy, z));
						if ((validBlocks.isEmpty()) ? isBlockAir(bs) : validBlocks.contains(bs.getBlock())) {
							return true;
						}
					}
					for (; z < oz + i; ) {
						bs = world.getBlockState(mpos.setPos(x, oy, ++z));
						if ((validBlocks.isEmpty()) ? isBlockAir(bs) : validBlocks.contains(bs.getBlock())) {
							return true;
						}
					}
					i++;
				}
				return false;

			case NONE:
				while (i <= checkRadius) {
					x = ox + i;
					z = oz + i;
					for (; x > ox - i; ) {
						if (validBlocks.contains(world.getBlockState(mpos.setPos(--x, oy, z)).getBlock())) {
							return false;
						}
					}
					for (; z > oz - i; ) {
						if (validBlocks.contains(world.getBlockState(mpos.setPos(x, oy, --z)).getBlock())) {
							return false;
						}
					}
					for (; x < ox + i; ) {
						if (validBlocks.contains(world.getBlockState(mpos.setPos(++x, oy, z)).getBlock())) {
							return false;
						}
					}
					for (; z < oz + i; ) {
						if (validBlocks.contains(world.getBlockState(mpos.setPos(x, oy, ++z)).getBlock())) {
							return false;
						}
					}
					i++;
				}
				return true;
		}
		return false;
	}

	public static boolean checkAreaMaterials(final MatchType matchType, final World world, final BlockPos origin, final int checkRadius, final Material... validMaterials) {
		return checkAreaMaterials(matchType, world, origin, checkRadius, Collections.unmodifiableCollection(Arrays.asList(validMaterials)));
	}

	public static boolean checkAreaMaterials(final MatchType matchType, final World world, final BlockPos origin, final int checkRadius, final Collection<Material> validMaterials) {

		final int
		ox = origin.getX(),
		oy = origin.getY(),
		oz = origin.getZ();
		final boolean ignoreReplaceable = matchType == MatchType.ALL_IGNORE_REPLACEABLE;
		MutableBlockPos mpos = new MutableBlockPos();
		int x, z, i = 1;
		Material material;

		switch (matchType) {

			case ALL_IGNORE_REPLACEABLE:
			case ALL:
				while (i <= checkRadius) {
					x = ox + i;
					z = oz + i;
					for (; x > ox - i; ) {
						material = world.getBlockState(mpos.setPos(--x, oy, z)).getMaterial();
						if ((ignoreReplaceable && !material.isReplaceable()) ||
								(validMaterials.isEmpty()) ? !isMaterialAir(material) : !validMaterials.contains(material)) {
							return false;
						}
					}
					for (; z > oz - i; ) {
						material = world.getBlockState(mpos.setPos(x, oy, --z)).getMaterial();
						if ((ignoreReplaceable && !material.isReplaceable()) ||
								(validMaterials.isEmpty()) ? !isMaterialAir(material) : !validMaterials.contains(material)) {
							return false;
						}
					}
					for (; x < ox + i; ) {
						material = world.getBlockState(mpos.setPos(++x, oy, z)).getMaterial();
						if ((ignoreReplaceable && !material.isReplaceable()) ||
								(validMaterials.isEmpty()) ? !isMaterialAir(material) : !validMaterials.contains(material)) {
							return false;
						}
					}
					for (; z < oz + i; ) {
						material = world.getBlockState(mpos.setPos(x, oy, ++z)).getMaterial();
						if ((ignoreReplaceable && !material.isReplaceable()) ||
								(validMaterials.isEmpty()) ? !isMaterialAir(material) : !validMaterials.contains(material)) {
							return false;
						}
					}
					i++;
				}
				return true;

			case ANY:
				while (i <= checkRadius) {
					x = ox + i;
					z = oz + i;
					for (; x > ox - i; ) {
						material = world.getBlockState(mpos.setPos(--x, oy, z)).getMaterial();
						if ((validMaterials.isEmpty()) ? isMaterialAir(material) : validMaterials.contains(material)) {
							return true;
						}
					}
					for (; z > oz - i; ) {
						material = world.getBlockState(mpos.setPos(x, oy, --z)).getMaterial();
						if ((validMaterials.isEmpty()) ? isMaterialAir(material) : validMaterials.contains(material)) {
							return true;
						}
					}
					for (; x < ox + i; ) {
						material = world.getBlockState(mpos.setPos(++x, oy, z)).getMaterial();
						if ((validMaterials.isEmpty()) ? isMaterialAir(material) : validMaterials.contains(material)) {
							return true;
						}
					}
					for (; z < oz + i; ) {
						material = world.getBlockState(mpos.setPos(x, oy, ++z)).getMaterial();
						if ((validMaterials.isEmpty()) ? isMaterialAir(material) : validMaterials.contains(material)) {
							return true;
						}
					}
					i++;
				}
				return false;

			case NONE:
				while (i <= checkRadius) {
					x = ox + i;
					z = oz + i;
					for (; x > ox - i; ) {
						material = world.getBlockState(mpos.setPos(--x, oy, z)).getMaterial();
						if ((validMaterials.isEmpty()) ? isMaterialAir(material) : validMaterials.contains(material)) {
							return false;
						}
					}
					for (; z > oz - i; ) {
						material = world.getBlockState(mpos.setPos(x, oy, --z)).getMaterial();
						if ((validMaterials.isEmpty()) ? isMaterialAir(material) : validMaterials.contains(material)) {
							return false;
						}
					}
					for (; x < ox + i; ) {
						material = world.getBlockState(mpos.setPos(++x, oy, z)).getMaterial();
						if ((validMaterials.isEmpty()) ? isMaterialAir(material) : validMaterials.contains(material)) {
							return false;
						}
					}
					for (; z < oz + i; ) {
						material = world.getBlockState(mpos.setPos(x, oy, ++z)).getMaterial();
						if ((validMaterials.isEmpty()) ? isMaterialAir(material) : validMaterials.contains(material)) {
							return false;
						}
					}
					i++;
				}
				return true;
		}
		return false;
	}

	public static boolean checkVolumeBlocks(final MatchType matchType, final World world, final BlockPos origin, final int checkRadius, final int checkHeight, final Block... validBlocks) {
		return checkVolumeBlocks(matchType, world, origin, checkRadius, checkHeight, Collections.unmodifiableCollection(Arrays.asList(validBlocks)));
	}

	public static boolean checkVolumeBlocks(final MatchType matchType, final World world, final BlockPos origin, final int checkRadius, final int checkHeight, final Collection<Block> validBlocks) {

		final int
		ox = origin.getX(),
		oy = origin.getY(),
		oz = origin.getZ();
		final int height = Math.abs(checkHeight);
		final boolean invert = checkHeight < 0;
		final MutableBlockPos mpos = new MutableBlockPos();

		if (!checkVerticalBlocks(matchType, world, origin, checkHeight, validBlocks)) {
			return false;
		}
		for (int i = 0; i < height; i++) {
			if (!checkAreaBlocks(matchType, world, mpos.setPos(ox, oy + (invert ? -i : i), oz), checkRadius, validBlocks)) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkVolumeMaterials(final MatchType matchType, final World world, final BlockPos origin, final int checkRadius, final int checkHeight, final Material... validMaterials) {
		return checkVolumeMaterials(matchType, world, origin, checkRadius, checkHeight, Collections.unmodifiableCollection(Arrays.asList(validMaterials)));
	}

	public static boolean checkVolumeMaterials(final MatchType matchType, final World world, final BlockPos origin, final int checkRadius, final int checkHeight, final Collection<Material> validMaterials) {

		final int
		ox = origin.getX(),
		oy = origin.getY(),
		oz = origin.getZ();
		final int height = Math.abs(checkHeight);
		final boolean invert = checkHeight < 0;
		final MutableBlockPos mpos = new MutableBlockPos();

		if (!checkVerticalMaterials(matchType, world, origin, checkHeight, validMaterials)) {
			return false;
		}
		for (int i = 0; i < height; i++) {
			if (!checkAreaMaterials(matchType, world, mpos.setPos(ox, oy + (invert ? -i : i), oz), checkRadius, validMaterials)) {
				return false;
			}
		}
		return true;
	}

	public enum EnumMaterial {
		AIR(Material.AIR),
		ANVIL(Material.ANVIL),
		BARRIER(Material.BARRIER),
		CACTUS(Material.CACTUS),
		CAKE(Material.CAKE),
		CARPET(Material.CARPET),
		CIRCUITS(Material.CIRCUITS),
		CLAY(Material.CLAY),
		CLOTH(Material.CLOTH),
		CORAL(Material.CORAL),
		CRAFTED_SNOW(Material.CRAFTED_SNOW),
		DRAGON_EGG(Material.DRAGON_EGG),
		FIRE(Material.FIRE),
		GLASS(Material.GLASS),
		GOURD(Material.GOURD),
		GRASS(Material.GRASS),
		GROUND(Material.GROUND),
		ICE(Material.ICE),
		IRON(Material.IRON),
		LAVA(Material.LAVA),
		LEAVES(Material.LEAVES),
		PACKED_ICE(Material.PACKED_ICE),
		PISTON(Material.PISTON),
		PLANTS(Material.PLANTS),
		PORTAL(Material.PORTAL),
		REDSTONE_LIGHT(Material.REDSTONE_LIGHT),
		ROCK(Material.ROCK),
		SAND(Material.SAND),
		SNOW(Material.SNOW),
		SPONGE(Material.SPONGE),
		STRUCTURE_VOID(Material.STRUCTURE_VOID),
		TNT(Material.TNT),
		VINE(Material.VINE),
		WATER(Material.WATER),
		WEB(Material.WEB),
		WOOD(Material.WOOD);

		private final Material material;

		EnumMaterial(Material material) {
			this.material = material;
		}

		public static Collection<Material> getMaterials() {
			return Collections.unmodifiableCollection(
					Arrays.stream(values())
					.map(EnumMaterial::getMaterial)
					.collect(Collectors.toSet())
					);
		}

		@Nullable
		public static Material getByName(final String name) {
			return Arrays.stream(values())
					.filter(material -> material.name().equals(name.toUpperCase(Locale.ENGLISH)))
					.findFirst()
					.map(EnumMaterial::getMaterial)
					.orElse(null);
		}

		@Nullable
		public static EnumMaterial getByMaterial(final Material material) {
			return Arrays.stream(values())
					.filter(value -> value.getMaterial() == material)
					.findFirst()
					.orElse(null);
		}

		public static Collection<Material> getReplaceable() {
			return Collections.unmodifiableCollection(
					Arrays.stream(values())
					.filter(EnumMaterial::isReplaceable)
					.map(EnumMaterial::getMaterial)
					.collect(Collectors.toList())
					);
		}

		public Material getMaterial() {
			return this.material;
		}

		public boolean isReplaceable() {
			return this.material.isReplaceable();
		}
	}

	public enum MatchType {
		ALL_IGNORE_REPLACEABLE,
		ALL,
		ANY,
		NONE
	}
}
