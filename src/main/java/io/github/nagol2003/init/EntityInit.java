package io.github.nagol2003.init;

import io.github.nagol2003.entities.deniamammal.EntityMammal;
import io.github.nagol2003.entities.poluloscrab.EntityPolulosCrab;
import io.github.nagol2003.registry.APRegistry;

public class EntityInit {
	
	public static void registerEntities(APRegistry registry) {
		
		registry.registerEntity(EntityPolulosCrab.class, "test", 20, 3, true, 13310623, 65354);
		
		registry.registerEntity(EntityMammal.class, "mammal", 20, 3, true, 13310623, 65354);
		
		//registerEntity("test", EntityPolulosCrab.class, Const.ENTITY_POLULOSCRAB, 50, 13310623, 65354);
		
	}

	private static void registerNonMobEntity() {
		
	}

}
