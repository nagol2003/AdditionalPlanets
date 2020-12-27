package io.github.nagol2003.celestial;

import io.github.nagol2003.Const;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import net.minecraft.util.ResourceLocation;

public class Systems {
	
	public static SolarSystem garphina;
	public static SolarSystem aa;
	public static SolarSystem wormHoleMilkeyWay;
	public static SolarSystem wormHoleAndromeda;
	public static SolarSystem wormHoleMessier;

	public Systems() {
		registerAll();
	}
	
	private static void registerAll() {
		
		garphina = new SolarSystem("Garphina", Galaxy.andromeda.getName()).setMapPosition(new Vector3(1.0F, 1.0F, 0.0F));
		Star starSol6 = (Star) new Star("Radon").setParentSolarSystem(garphina).setTierRequired(-1);
		starSol6.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/radonstar.png"));
		garphina.setMainStar(starSol6);
		GalaxyRegistry.registerSolarSystem(garphina);
		
		aa = new SolarSystem("Aa", "milky_way").setMapPosition(new Vector3(1.2F, -1.8F, 0.0F));
		Star starSol9 = (Star) new Star("KanLaon").setParentSolarSystem(aa).setTierRequired(-1);
		starSol9.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/kanlaon.png"));
		aa.setMainStar(starSol9);
		GalaxyRegistry.registerSolarSystem(aa);
		
		wormHoleMilkeyWay = new SolarSystem("WormHoleMilkeyWay", "milky_way").setMapPosition(new Vector3(-1.0F, 2.5F, 0.0F));
		Star starSol16 = (Star) new Star("WormHoleMilkeyWay").setParentSolarSystem(wormHoleMilkeyWay).setTierRequired(-1);
		starSol16.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/wormhole.png"));
		wormHoleMilkeyWay.setMainStar(starSol16);
		GalaxyRegistry.registerSolarSystem(wormHoleMilkeyWay);
		
		wormHoleAndromeda = new SolarSystem("WormHoleAndromeda", Galaxy.andromeda.getName()).setMapPosition(new Vector3(-1.0F, 0.5F, 0.0F));
		Star starSol17 = (Star) new Star("WormHoleAndromeda").setParentSolarSystem(wormHoleAndromeda).setTierRequired(-1);
		starSol17.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/wormhole.png"));
		wormHoleAndromeda.setMainStar(starSol17);
		GalaxyRegistry.registerSolarSystem(wormHoleAndromeda);
		
		wormHoleMessier = new SolarSystem("WormHoleMessier", Galaxy.messier81.getName()).setMapPosition(new Vector3(-1.0F, 0.5F, 0.0F));
		Star starSol18 = (Star) new Star("WormHoleMessier").setParentSolarSystem(wormHoleMessier).setTierRequired(-1);
		starSol18.setBodyIcon(new ResourceLocation(Const.ASSET_PREFIX, "textures/gui/celestialbodies/wormhole.png"));
		wormHoleMessier.setMainStar(starSol18);
		GalaxyRegistry.registerSolarSystem(wormHoleMessier);
	}
}
