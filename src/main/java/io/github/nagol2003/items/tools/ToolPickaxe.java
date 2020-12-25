package io.github.nagol2003.items.tools;

import net.minecraft.item.ItemPickaxe;

public class ToolPickaxe extends ItemPickaxe 
{
	public ToolPickaxe(String name, ToolMaterial material) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		//setCreativeTab(AdditionalPlanetsTab.AdditionalPlanets);
		
		//InitItems.ITEMS.add(this);
	}
}