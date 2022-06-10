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
        //entity.getHorizontalFacing().getIndex();
        System.out.println("Facing: " + entity.getHorizontalFacing().getIndex());
        if (world.isRemote)
            return;
        Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
                new ResourceLocation("addtlplanets", "test"));
        if (template == null)
            return;
        BlockPos spawnTo = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        IBlockState iblockstate = world.getBlockState(spawnTo);
        world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);


        Rotation rotation = Rotation.NONE;
        switch(entity.getHorizontalFacing().getIndex()) {
            case 2: //north
                rotation = Rotation.CLOCKWISE_180; //FIXME POSSIBLY WRONG ORIENTATION
                break;
            case 3: //south
                rotation = Rotation.NONE; //FIXME POSSIBLY WRONG ORIENTATION
                break;
            case 4: //West
                rotation = Rotation.CLOCKWISE_90; //FIXME POSSIBLY WRONG ORIENTATION
                break;
            case 5: //East
                rotation = Rotation.COUNTERCLOCKWISE_90; //FIXME POSSIBLY WRONG ORIENTATION
                break;
        }


        template.addBlocksToWorldChunk(world, spawnTo,
                new PlacementSettings().setRotation(rotation).setMirror(Mirror.NONE).setChunk((ChunkPos) null)
                        .setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
    }
}
