package io.github.nagol2003.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemFerminiumChunk extends Item {

	@Override
	public void onUpdate(final ItemStack stack, final World worldIn, final Entity entityIn, final int itemSlot, final boolean isSelected) { 
	    super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);

	    if (entityIn instanceof EntityLivingBase) { 
	        ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 10, 1));
	        }
	}
	
}
