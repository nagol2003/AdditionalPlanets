package io.github.nagol2003.blocks.Ognious;

import io.github.nagol2003.init.InitBlocks;
import io.github.nagol2003.init.InitItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ReeshPlant extends BlockCrops {
	
	//private static final AxisAlignedBB[] reesh = new AxisAlignedBB[] {new AxisAligned
	
	public ReeshPlant(String name) {
		
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		if(!worldIn.isRemote) {
			
			if(this.isMaxAge(state)) {
				
				worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(InitItems.REESH, 2)));  //drop
				worldIn.setBlockState(pos, this.withAge(0));
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	protected Item getSeed() {
		
		return InitItems.REESH_SEEDS;
		
	}
	
	@Override
	protected Item getCrop() {

		return InitItems.REESH;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		// TODO Auto-generated method stub
		return super.getBoundingBox(state, source, pos);
	}

}
