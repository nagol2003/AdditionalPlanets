package io.github.nagol2003.items.tools;

import java.util.Set;


import java.util.Set;

import com.google.common.collect.Sets;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;



import com.google.common.collect.Sets;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;


public class ToolAxe extends ItemTool
{
	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE);
	
	public ToolAxe(String name, ToolMaterial material)
	{
		super(material, EFFECTIVE_ON);
		setUnlocalizedName(name);
		setRegistryName(name);
		//setCreativeTab(TutorialMod.TUTORIALMODTAB);
		
		//ItemInit.ITEMS.add(this);
	}
}


//import net.minecraftforge.client.model.obj.OBJModel.Material;