package io.github.nagol2003.items.tools;

import net.minecraft.item.ItemSpade;

public class ToolShovel extends ItemSpade 
{
	public ToolShovel(String name, ToolMaterial material) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		//setCreativeTab(AdditionalPlanetsTab.AdditionalPlanets);
		
		//InitItems.ITEMS.add(this);
	}
}