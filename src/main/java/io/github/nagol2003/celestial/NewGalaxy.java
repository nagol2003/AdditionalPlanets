package io.github.nagol2003.celestial;

import asmodeuscore.core.astronomy.BodiesRegistry;
import asmodeuscore.core.astronomy.BodiesRegistry.Galaxies;
import io.github.nagol2003.Const;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import net.minecraft.util.ResourceLocation;

public class NewGalaxy {
	
	public static Galaxies andromeda;
	public static SolarSystem adnro1;
	public static SolarSystem andro2;
	
	public static void init() {
		build();
	}
	
	private static void build() {
		andromeda = BodiesRegistry.registerGalaxy("andromeda", new ResourceLocation(Const.modID, "textures/gui/galaxy/wormhole.png"));
		
		adnro1 = new SolarSystem("adnro1", andromeda.getName()).setMapPosition(new Vector3(-1.0F, 1.0F, 0.0F));
		Star starSol4 = (Star) new Star("zsadnro1").setParentSolarSystem(adnro1).setTierRequired(-1);
		starSol4.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
		adnro1.setMainStar(starSol4);
		GalaxyRegistry.registerSolarSystem(adnro1);
		
		andro2 = new SolarSystem("adnro2", andromeda.getName()).setMapPosition(new Vector3(1.0F, -1.0F, 0.0F));
		Star starSol5 = (Star) new Star("zsadnro2").setParentSolarSystem(andro2).setTierRequired(-1);
		starSol5.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
		andro2.setMainStar(starSol5);
		GalaxyRegistry.registerSolarSystem(adnro1);
	}

}
