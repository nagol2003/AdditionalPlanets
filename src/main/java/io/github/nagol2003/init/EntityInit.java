package io.github.nagol2003.init;

import java.lang.ref.Reference;

import io.github.nagol2003.AddonMain;
import io.github.nagol2003.Const;
import io.github.nagol2003.entities.poluloscrab.EntityPolulosCrab;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
	
	public static void registerEntities() {
		
		registerEntity("test", EntityPolulosCrab.class, Const.ENTITY_POLULOSCRAB, 50, 13310623, 65354);
		
	}
	
	private static void registerEntity(String name, Class<?extends Entity> entity, int id, int range, int color1, int color2) {
		
		EntityRegistry.registerModEntity(new ResourceLocation(Const.modID + ":" + name), entity, name, id, AddonMain.INSTANCE, range, 1, true, color1, color2);
		
	}
	
	private static void registerNonMobEntity() {
		
	}

}
