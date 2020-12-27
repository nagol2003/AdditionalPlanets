package io.github.nagol2003.init;

import asmodeuscore.core.astronomy.BodiesRegistry;
import io.github.nagol2003.celestial.Galaxy;
import io.github.nagol2003.celestial.Planets;
import io.github.nagol2003.celestial.SpaceStations;
import io.github.nagol2003.celestial.Systems;

public class InitCelestial {
	
	public static void init() {
		
		BodiesRegistry.setMaxTier(1);
		new Galaxy();
		new Systems();
		new Planets();
		new SpaceStations();
	}

}
