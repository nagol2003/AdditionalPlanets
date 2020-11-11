package io.github.nagol2003.proxy;

import io.github.nagol2003.registry.APRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends ServerProxy {

	@Override
	public void preInit(APRegistry registry, FMLPreInitializationEvent event) {
		super.preInit(registry, event);
		register_event(this);
		/// PLACE CODE BELOW ///
		
		
		/// PLACE CODE ABOVE ///
		registry.clientPreInit(event);
	}

	@Override
	public void init(APRegistry registry, FMLInitializationEvent event) {
		super.init(registry, event);
		/// PLACE CODE BELOW ///
		
		
		
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
}
