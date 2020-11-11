package io.github.nagol2003.init;

import io.github.nagol2003.items.ItemFerminiumAlloy;
import io.github.nagol2003.items.ItemFerminiumChunk;
import io.github.nagol2003.items.ItemStrangeMetallicSubstance;
import io.github.nagol2003.items.tools.ToolFerminiunSword;
import io.github.nagol2003.registry.APRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class InitItems {
	
	//Items
	public static final Item FERMINIUM_CHUNK = new ItemFerminiumChunk();
	
	public static final Item FERMINIUM_ALLOY = new ItemFerminiumAlloy();
	
	public static final Item STRANGE_METALLIC_SUBSTANCE = new ItemStrangeMetallicSubstance();
	
	//Materials
	public static final ToolMaterial MATERIAL_FERMINIUM = EnumHelper.addToolMaterial("material_ferminium", 3, 950, 13.0F, 6.0F, 15);
	
	//Tools
	public static final ItemSword FERMINIUM_SWORD = new ToolFerminiunSword("ferminium_sword", MATERIAL_FERMINIUM);
	
	
	
	public static void registerAll (APRegistry registry) {
		CreativeTabs toTab = AdditionalPlanetsTab.AdditionalPlanets;
		
		registry.registerItem(FERMINIUM_CHUNK, "ferminium_chunk").setCreativeTab(toTab);
		
		registry.registerItem(FERMINIUM_ALLOY, "ferminium_alloy").setCreativeTab(toTab);
		
		registry.registerItem(STRANGE_METALLIC_SUBSTANCE, "strange_metallic_substance").setCreativeTab(toTab);
		
		registry.registerItem(FERMINIUM_SWORD, "ferminium_sword").setCreativeTab(toTab);
	}
	
	//public static void registerAll (APRegistry registry) {
		CreativeTabs toTab = AdditionalPlanetsTab.blockTab;

	
}