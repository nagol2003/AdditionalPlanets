package io.github.nagol2003.init;

import io.github.nagol2003.items.ItemFerminiumAlloy;
import io.github.nagol2003.items.ItemFerminiumChunk;
import io.github.nagol2003.items.ItemStrangeMetallicSubstance;
import io.github.nagol2003.items.food.CookedCrabMeat;
import io.github.nagol2003.items.food.RawCrabMeat;
import io.github.nagol2003.items.food.Reesh;
import io.github.nagol2003.items.tools.ToolAxe;
import io.github.nagol2003.items.tools.ToolPickaxe;
import io.github.nagol2003.items.tools.ToolShovel;
import io.github.nagol2003.items.tools.ToolSword;
import io.github.nagol2003.registry.APRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class InitItems {
	
	//Items
	public static final Item FERMINIUM_CHUNK = new ItemFerminiumChunk();
	public static final Item FERMINIUM_ALLOY = new ItemFerminiumAlloy();
	public static final Item STRANGE_METALLIC_SUBSTANCE = new ItemStrangeMetallicSubstance();
	
	//Materials
	public static final ToolMaterial MATERIAL_FERMINIUM = EnumHelper.addToolMaterial("material_ferminium", 3, 950, 13.0F, 6.0F, 15);
	public static final ToolMaterial TOOL_FERMINIUM = EnumHelper.addToolMaterial("tool_ferminium", 7, 1500, 15.0f, 7.0f, 19);
	
	//public static final ArmorMaterial  ARMORFERMINIUM = EnumHelper.addArmorMaterial("armor_ferminium", 4, 7, 13.0F, 6.0F, 9);
	 public static ArmorMaterial ARMORFERMINIUM1 = EnumHelper.addArmorMaterial("FERMINIUM", "FERMINIUM", 42, new int[] { 4, 7, 9, 4 }, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F);
	 public static ArmorMaterial ARMORFERMINIUM2 = EnumHelper.addArmorMaterial("FERMINIUM", "copper", 42, new int[] { 4, 7, 9, 4 }, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F);
	 public static ArmorMaterial ARMORFERMINIUM3 = EnumHelper.addArmorMaterial("FERMINIUM", "copper", 42, new int[] { 4, 7, 9, 4 }, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F);
	 public static ArmorMaterial ARMORFERMINIUM4 = EnumHelper.addArmorMaterial("FERMINIUM", "COPPER", 42, new int[] { 4, 7, 9, 4 }, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F);
	
	//Tools
	public static final Item PICKAXE_FERMINIUM = new ToolPickaxe("ferminium_pickaxe", TOOL_FERMINIUM);
	public static final Item AXE_FERMINIUM = new ToolAxe("ferminium_axe", TOOL_FERMINIUM);
	public static final Item SHOVEL_FERMINIUM = new ToolShovel("ferminium_shovel", TOOL_FERMINIUM);
	public static final Item SWORD_FERMINIUM = new ToolSword("ferminium_sword", TOOL_FERMINIUM);
	
	//Food
	public static final Item RAW_CRAB_MEAT = new RawCrabMeat("rawcrabmeat", 4, 0.3F, false);
	public static final Item COOKED_CRAB_MEAT = new CookedCrabMeat("cookedcrabmeat", 8, 0.9F, false);
	public static final Item REESH = new Reesh("reesh", 6, 0.6F, false);
	//public static final Item REESH_SEEDS = new ReeshSeeds();
	
	//Armor
	public static final Item HELMET_FERMINIUM = new ItemArmor(ARMORFERMINIUM1, 7, EntityEquipmentSlot.HEAD).setUnlocalizedName("ferminium_helmet");
	public static final Item CHESTPLATE_FERMINIUM = new ItemArmor(ARMORFERMINIUM2, 7, EntityEquipmentSlot.CHEST).setUnlocalizedName("ferminium_chestplate");
	public static final Item LEGGINGS_FERMINIUM = new ItemArmor(ARMORFERMINIUM3, 7, EntityEquipmentSlot.LEGS).setUnlocalizedName("ferminium_leggings");
	public static final Item BOOTS_FERMINIUM = new ItemArmor(ARMORFERMINIUM4, 7, EntityEquipmentSlot.FEET).setUnlocalizedName("ferminium_boots");
	
	
	
	public static void registerAll (APRegistry registry) {
		CreativeTabs toTab = AdditionalPlanetsTab.AdditionalPlanets;
		
		registry.registerItem(FERMINIUM_CHUNK, "ferminium_chunk").setCreativeTab(toTab);
		registry.registerItem(FERMINIUM_ALLOY, "ferminium_alloy").setCreativeTab(toTab);
		registry.registerItem(STRANGE_METALLIC_SUBSTANCE, "strange_metallic_substance").setCreativeTab(toTab);
		//registry.registerItem(FERMINIUM_SWORD, "ferminium_sword").setCreativeTab(toTab);
		registry.registerItem(RAW_CRAB_MEAT, "rawcrabmeat").setCreativeTab(toTab);
		registry.registerItem(COOKED_CRAB_MEAT, "cookedcrabmeat").setCreativeTab(toTab);
		registry.registerItem(PICKAXE_FERMINIUM, "ferminium_pickaxe").setCreativeTab(toTab);
		registry.registerItem(AXE_FERMINIUM, "ferminium_axe").setCreativeTab(toTab);
		registry.registerItem(SHOVEL_FERMINIUM, "ferminium_shovel").setCreativeTab(toTab);
		registry.registerItem(SWORD_FERMINIUM, "ferminium_sword").setCreativeTab(toTab);
		registry.registerItem(REESH, "reesh").setCreativeTab(toTab);
		//registry.registerItem(REESH_SEEDS, "reeshseeds").setCreativeTab(toTab);
		registry.registerItem(HELMET_FERMINIUM, "ferminium_helmet").setCreativeTab(toTab);
		registry.registerItem(CHESTPLATE_FERMINIUM, "ferminium_chestplate").setCreativeTab(toTab);
		registry.registerItem(LEGGINGS_FERMINIUM, "ferminium_leggings").setCreativeTab(toTab);
		registry.registerItem(BOOTS_FERMINIUM, "ferminium_boots").setCreativeTab(toTab);
		
	}
	
	//public static void registerAll (APRegistry registry) {
		CreativeTabs toTab = AdditionalPlanetsTab.blockTab;

}