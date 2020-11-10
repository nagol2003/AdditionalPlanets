package io.github.nagol2003.proxy;

import io.github.nagol2003.registry.APRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy implements IProxy {

	public void register_event (Object obj) {
		MinecraftForge.EVENT_BUS.register(obj);
	}

	@Override
	public void preInit(APRegistry registry, FMLPreInitializationEvent event) {
		registry.preInit(event);
	}

	@Override
	public void init(APRegistry registry, FMLInitializationEvent event) {
		registry.init(event);
	}
	
	public void receiveIMC(IMCEvent event) {
	}

	@Override
	public void postInit(APRegistry registry, FMLPostInitializationEvent event) {
		registry.postInit(event);
	}

	@Override
	public EntityPlayer getClientPlayer() {
		return null;
	}
	
	public EntityPlayer getPlayerFromNetHandler (INetHandler handler) {
		if (handler instanceof NetHandlerPlayServer) {
			return ((NetHandlerPlayServer) handler).player;
		}
		else {
			return null;
		}
	}
}
