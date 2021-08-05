package io.github.nagol2003.celestial.planets;

import io.github.nagol2003.client.render.sky.SnowRenderer;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;
import micdoodle8.mods.galacticraft.core.client.CloudRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class WorldProviderAddonPlanet extends WorldProviderSpace implements ISolarLevel {

	protected Class<? extends IRenderHandler> skyProvider;
	protected boolean constantSnow = false;
	protected boolean renderClouds = false;
	
	public Class<? extends IRenderHandler> getSkyProviderClass() {
		return skyProvider;
	}

	@Override
	public Vector3 getFogColor() {
		return new Vector3(0, 0, 0);
	}

	@Override
	public double getHorizon() {
		return 44.0D;
	}

	@Override
	public int getAverageGroundLevel() {
		return 44;
	}

	@Override
	public boolean hasSunset() {
		return false;
	}

	@Override
	public boolean canCoordinateBeSpawn(int var1, int var2) {
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IRenderHandler getCloudRenderer() {
		if(renderClouds == false) {
			if (super.getCloudRenderer() == null) {
				this.setCloudRenderer(new CloudRenderer());
			}
		}
		return super.getCloudRenderer();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IRenderHandler getWeatherRenderer() {
		if(constantSnow == true) {
			if (super.getWeatherRenderer() == null) {
				this.setWeatherRenderer(new SnowRenderer());
			}
		}
		return super.getWeatherRenderer();
	}
}
