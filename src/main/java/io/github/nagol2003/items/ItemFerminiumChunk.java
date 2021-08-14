package io.github.nagol2003.items;

import io.github.nagol2003.blocks.interfaces.IAddRecipe;
import io.github.nagol2003.init.InitFluids;
import io.github.nagol2003.registry.recipe.RecipeBuilder;
import io.github.nagol2003.util.FluidUtility;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemFerminiumChunk extends Item implements IAddRecipe {

	@Override
	public void onUpdate(final ItemStack stack, final World worldIn, final Entity entityIn, final int itemSlot, final boolean isSelected) {
	    super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);

	    if (entityIn instanceof EntityLivingBase) {
	        ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 10, 1));
	        }
	}

	@Override
	public void addRecipes(RecipeBuilder recipes) {
		//Examples of how to add
		// either define the itemstacks as method variables

		// we want to produce this item so call this
		ItemStack output = new ItemStack(this);

		// we want to have 1 tin bucket produce this item, use our own FluidUtility class to pass our fluid and get a bucket as an ItemStack
		ItemStack input = FluidUtility.getBucket(InitFluids.TIN);
		//now add
		recipes.addShapeless("test_chunk", output, input);


		// or we can just define the recipe with output and inputs in the method
		//recipes.addShapeless("test_chunk", new ItemStack(this), FluidUtility.getBucket(InitFluids.TIN));
	}
}
