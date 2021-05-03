package io.github.nagol2003.items;

import io.github.nagol2003.init.InitItems;
import micdoodle8.mods.galacticraft.core.items.ISortableItem;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryItem;
import micdoodle8.mods.galacticraft.planets.GalacticraftPlanets;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.minecraft.client.main.Main;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FerminiumHelmet extends ItemArmor implements ISortableItem
{
	
	@SideOnly(Side.CLIENT)
    @Override
    public void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(InitItems.HELMET_FERMINIUM, 0, new ModelResourceLocation("gcaddon:textures/model/armor/ferminium_layer_1.png"));
    }
	
    private final ArmorMaterial material;

    public FerminiumHelmet(ArmorMaterial par2EnumArmorMaterial, int par3, EntityEquipmentSlot par4)
    {
        super(par2EnumArmorMaterial, par3, par4);
        this.material = par2EnumArmorMaterial;
    }

    /*@Override
    public Item setUnlocalizedName(String par1Str)
    {
//        super.setTextureName(par1Str);
        super.setUnlocalizedName(par1Str);
        return this;
    }*/

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        if (this.material == InitItems.ARMORFERMINIUM)
        {
            if (stack.getItem() == InitItems.HELMET_FERMINIUM)
            {
                return "gcaddon:textures/model/armor/ferminium_layer_1.png";
            }
        }

        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return ClientProxyCore.galacticraftItem;
    }

    @Override
    public EnumSortCategoryItem getCategory(int meta)
    {
        return EnumSortCategoryItem.ARMOR;
    }
    
    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        return repair.getItem() == MarsItems.marsItemBasic && repair.getItemDamage() == 2;
    }
    
}