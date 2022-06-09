package io.github.nagol2003.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.world.WorldServer;


public class TestStructureBlock extends Block{

    public TestStructureBlock() {
        super(Material.ROCK);
        setRegistryName("TestStructureBlock");
        setUnlocalizedName("TestStructureBlock");
        setSoundType(SoundType.GROUND);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.SOLID;
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack itemstack) {
        super.onBlockPlacedBy(world, pos, state, entity, itemstack);
        if (world.isRemote)
            return;
        Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
                new ResourceLocation("addtlplanets", "penis"));
        if (template == null)
            return;
        BlockPos spawnTo = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        IBlockState iblockstate = world.getBlockState(spawnTo);
        world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
        template.addBlocksToWorldChunk(world, spawnTo,
                new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk((ChunkPos) null)
                        .setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
    }
}
