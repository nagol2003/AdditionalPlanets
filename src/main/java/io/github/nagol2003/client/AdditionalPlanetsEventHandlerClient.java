package io.github.nagol2003.client;

import io.github.nagol2003.Const;
import io.github.nagol2003.celestial.AddonCelestialBodies;
import micdoodle8.mods.galacticraft.api.event.client.CelestialBodyRenderEvent;
import micdoodle8.mods.galacticraft.core.client.gui.screen.GuiCelestialSelection;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = Const.modID, value = Side.CLIENT)
public class AdditionalPlanetsEventHandlerClient {

	public static Minecraft mc = FMLClientHandler.instance().getClient();
	
	@SubscribeEvent
    public static void onRenderPlanetPost(CelestialBodyRenderEvent.Post event)
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
