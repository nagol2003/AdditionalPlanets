package io.github.nagol2003.items.food;

import net.minecraft.item.ItemFood;

public class RawCrabMeat extends ItemFood
{
	public RawCrabMeat(String name, int amount, float saturation, boolean isWolfFood) 
	{
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(name);	
		setRegistryName(name);
	}
} 