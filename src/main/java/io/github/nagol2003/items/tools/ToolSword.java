package io.github.nagol2003.items.tools;

import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword 
{
	public ToolSword(String name, ToolMaterial material) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		//setCreativeTab(AdditionalPlanetsTab.AdditionalPlanets);
		
		//InitItems.ITEMS.add(this);
	}
	
}