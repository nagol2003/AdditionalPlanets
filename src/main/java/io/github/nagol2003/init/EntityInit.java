package io.github.nagol2003.init;

import io.github.nagol2003.entities.deniamammal.EntityMammal;
import io.github.nagol2003.entities.pigman.EntityPigman;
import io.github.nagol2003.entities.poluloscrab.EntityPolulosCrab;
import io.github.nagol2003.entities.poluloscrab.RenderCrab;
import io.github.nagol2003.registry.APRegistry;

public class EntityInit {
	
	public static void registerEntities(APRegistry registry) {
		
		registry.registerEntity(EntityPolulosCrab.class, "test", 64, 20, true, 13310623, 65354);
		registry.registerEntity(EntityMammal.class, "mammal", 64, 20, true, 13310623, 65354);
		registry.registerEntity(EntityPigman.class, "pigman", 64, 20, true, 13310623, 65354);
	
		//registerEntity("test", EntityPolulosCrab.class, Const.ENTITY_POLULOSCRAB, 50, 13310623, 65354);
		
	}

	private static void registerNonMobEntity() {
		
	}

}
