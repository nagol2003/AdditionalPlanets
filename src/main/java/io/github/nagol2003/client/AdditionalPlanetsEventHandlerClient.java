package io.github.nagol2003.client;

import io.github.nagol2003.Const;
import io.github.nagol2003.celestial.AddonCelestialBodies;
import micdoodle8.mods.galacticraft.api.event.client.CelestialBodyRenderEvent;
import micdoodle8.mods.galacticraft.core.Constants;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.client.gui.screen.GuiCelestialSelection;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AdditionalPlanetsEventHandlerClient {

	public static Minecraft mc = FMLClientHandler.instance().getClient();
	
	@SubscribeEvent
    public void onRenderPlanetPost(CelestialBodyRenderEvent.Post event)
    {
        if (mc.currentScreen instanceof GuiCelestialSelection)
        {
            if (event.celestialBody == AddonCelestialBodies.Ognious)
            {
                mc.renderEngine.bindTexture(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/ognious_rings.png"));
                float size = ((GuiCelestialSelection)mc.currentScreen).getWidthForCelestialBody(event.celestialBody) / 6.0F;
                ((GuiCelestialSelection) mc.currentScreen).drawTexturedModalRect(-7.5F * size, -1.75F * size, 15.0F * size, 3.5F * size, 0, 0, 30, 7, false, false, 32, 32);
            }
        }
    }
	
}
