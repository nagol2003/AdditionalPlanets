 package io.github.nagol2003.proxy;

import java.lang.reflect.Field;
import java.util.Map;

import io.github.nagol2003.Const;
import io.github.nagol2003.client.render.ModRenderPlayer;
import io.github.nagol2003.entities.deniamammal.EntityMammal;
import io.github.nagol2003.entities.deniamammal.RenderMammal;
import io.github.nagol2003.entities.moose.EntityMoose;
import io.github.nagol2003.entities.moose.RenderMoose;
import io.github.nagol2003.entities.pigman.EntityPigman;
import io.github.nagol2003.entities.pigman.RenderPigman;
import io.github.nagol2003.entities.poluloscrab.EntityPolulosCrab;
import io.github.nagol2003.entities.poluloscrab.RenderCrab;
import io.github.nagol2003.registry.APRegistry;
import io.github.nagol2003.util.Reflected;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(value = Side.CLIENT, modid = Const.modID)
public class ClientProxy extends ServerProxy {
	
	public static Field playerRenderer = Reflected.findField(RenderManager.class, "playerRenderer", "field_178637_m");
	public static Field skinMap = Reflected.findField(RenderManager.class, "skinMap", "field_178636_l");
	
	@Override
	public void preInit(APRegistry registry, FMLPreInitializationEvent event) {
		super.preInit(registry, event);
		register_event(this);
		/// PLACE CODE BELOW ///v
		registry.registerEntityRenderer(EntityPolulosCrab.class, RenderCrab::new);
		registry.registerEntityRenderer(EntityMammal.class, RenderMammal::new);
		registry.registerEntityRenderer(EntityPigman.class, RenderPigman::new);
		registry.registerEntityRenderer(EntityMoose.class, RenderMoose::new);
		/// PLACE CODE ABOVE ///
		registry.clientPreInit(event);
	}
	@SuppressWarnings("unchecked")
	@Override
	public void init(APRegistry registry, FMLInitializationEvent event) {
		super.init(registry, event);
		playerRenderer.setAccessible(true);
		 Minecraft mc = Minecraft.getMinecraft();
		/// PLACE CODE BELOW ///
		 try
	        {
		 playerRenderer.set(mc.getRenderManager(), new ModRenderPlayer(mc.getRenderManager()));
         // DEBUG
         System.out.println("playerRenderer after reflection is "+playerRenderer.get(mc.getRenderManager()));
         ((Map<String, RenderPlayer>) skinMap.get(mc.getRenderManager())).put("default", new ModRenderPlayer(mc.getRenderManager()));
         ((Map<String, RenderPlayer>)skinMap.get(mc.getRenderManager())).put("slim", new ModRenderPlayer(mc.getRenderManager(), true));
         }
		 catch (IllegalArgumentException | IllegalAccessException e)
		 {
		 }
		
		
		/// PLACE CODE ABOVE ///
		registry.clientInit(event);
	}

	@Override
	public void postInit(APRegistry registry, FMLPostInitializationEvent event) {
		super.postInit(registry, event);
		/// PLACE CODE BELOW ///
		
		
		
		/// PLACE CODE ABOVE ///
		registry.clientPostInit(event);
	}
	
	public World getWorld() {
		return Minecraft.getMinecraft().world;
	}

	@Override
	public EntityPlayer getClientPlayer() {
		return Minecraft.getMinecraft().player;
	}

	public static int getColorForEnchantment(Map<Enchantment, Integer> enchantments) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static float greenFromColor(int parColor) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static float redFromColor(int parColor) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static float blueFromColor(int parColor) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static float alphaFromColor(int parColor) {
		// TODO Auto-generated method stub
		return 0;
	}
}
