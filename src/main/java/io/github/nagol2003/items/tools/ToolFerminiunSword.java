package io.github.nagol2003.items.tools;

import net.minecraft.item.ItemSword;

public class ToolFerminiunSword extends ItemSword {
	
	public ToolFerminiunSword(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
	//	setCreativeTab(toTab2);
		//this.setCreativeTab(AdditionalPlanetsTab.blockTab);
		
		//InitItems.ITEMS.add(this);
	}

}
