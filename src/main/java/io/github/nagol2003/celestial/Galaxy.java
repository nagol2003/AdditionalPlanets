package io.github.nagol2003.celestial;

import asmodeuscore.core.astronomy.BodiesRegistry;
import asmodeuscore.core.astronomy.BodiesRegistry.Galaxies;
import io.github.nagol2003.Const;
import net.minecraft.util.ResourceLocation;

public class Galaxy {
	
	public static Galaxies andromeda;
	public static Galaxies messier81;
	
	public Galaxy() {
		build();
	}
	
	private static void build() {
		andromeda = BodiesRegistry.registerGalaxy("andromeda", new ResourceLocation(Const.modID, "textures/gui/galaxy/wormhole.png"));
		messier81 = BodiesRegistry.registerGalaxy("messier81", new ResourceLocation(Const.modID, "textures/galaxy/messier.png"));
	}

}
