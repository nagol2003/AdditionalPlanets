package io.github.nagol2003.client;

import io.github.nagol2003.Const;
import io.github.nagol2003.celestial.planets.Ognious.SkyProviderOgnious;
import io.github.nagol2003.celestial.planets.Ognious.WorldProviderOgnious;
import io.github.nagol2003.celestial.planets.Polulos.SkyProviderPolulos;
import io.github.nagol2003.celestial.planets.Polulos.WorldProviderPolulos;
import io.github.nagol2003.celestial.planets.denia.SkyProviderDenia;
import io.github.nagol2003.celestial.planets.denia.WorldProviderDenia;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.client.CloudRenderer;
import micdoodle8.mods.galacticraft.core.client.SkyProviderMoon;
import micdoodle8.mods.galacticraft.planets.mars.client.SkyProviderMars;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Const.modID, value = Side.CLIENT)
public class SkyProviderEvent {
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onClientTick(ClientTickEvent event) {
		final Minecraft mc = FMLClientHandler.instance().getClient();
		final WorldClient world = mc.world;
		final EntityPlayerSP player = mc.player;
		
		if(event.phase == Phase.START && player != null && world != null) {
			WorldProvider provider = world.provider;
			
			if(provider instanceof WorldProviderOgnious) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderOgnious());
				}
			}
			
			if(provider instanceof WorldProviderPolulos) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderPolulos());
				}
				
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			
			if(provider instanceof WorldProviderDenia) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderDenia());
				}
				
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
				
//				if (world.provider.getCloudRenderer() == null) {
//					world.provider.setCloudRenderer(new CloudRenderer());
//				}
			}
		}
	}



/*	if(provider instanceof WorldProviderPolulos) {
if(provider.getSkyRenderer() == null) {
	provider.setSkyRenderer(new SkyProviderPolulos());
} */ 
//in place of ognious 