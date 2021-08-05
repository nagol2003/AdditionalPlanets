package io.github.nagol2003.client;

import io.github.nagol2003.Const;
import io.github.nagol2003.celestial.planets.WorldProviderAddonPlanet;
import io.github.nagol2003.celestial.planets.ognious.SkyProviderOgnious;
import io.github.nagol2003.client.render.sky.SnowRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = Const.modID, value = Side.CLIENT)
public class PlanetAtmosphereHandler {
	
	@SubscribeEvent
	public static void clientTick(TickEvent.ClientTickEvent event) {
		if (event.phase != TickEvent.Phase.END) return;

		Minecraft mc = Minecraft.getMinecraft();
		
		if(mc.player != null && mc.world != null) {
			WorldProvider provider = mc.world.provider;
			if(provider instanceof WorldProviderAddonPlanet) {
				WorldProviderAddonPlanet planetProvider = (WorldProviderAddonPlanet) provider;
				if (planetProvider.getSkyRenderer() == null) {
					try {
						planetProvider.setSkyRenderer(planetProvider.getSkyProviderClass().newInstance());
					} catch (InstantiationException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
				if(!mc.isGamePaused() && mc.world.provider.getWeatherRenderer() instanceof SnowRenderer) {
					((SnowRenderer) mc.world.provider.getWeatherRenderer()).tick();
				}
			}
		}
	}
}
