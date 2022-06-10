package io.github.nagol2003.blocks.phu;

import io.github.nagol2003.init.AdditionalPlanetsTab;
import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import micdoodle8.mods.galacticraft.core.blocks.ISortableBlock;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;

public class SmallPHUBlock extends Block implements ISortableBlock, ITerraformableBlock {

	public SmallPHUBlock() {
		super(Material.GROUND);
		this.setSoundType(SoundType.GROUND);
		this.setHardness(1.0f);
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
	
	
	@Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack itemstack) {
        super.onBlockPlacedBy(world, pos, state, entity, itemstack);
        if (world.isRemote)
            return;
        Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
                new ResourceLocation("addtlplanets", "testbase"));
        if (template == null)
            return;
        BlockPos spawnTo = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
        IBlockState iblockstate = world.getBlockState(spawnTo);
        world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
        template.addBlocksToWorldChunk(world, spawnTo,
                new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk((ChunkPos) null)
                        .setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
    }
	
}
