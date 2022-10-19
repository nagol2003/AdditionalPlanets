package io.github.nagol2003.init;

import io.github.nagol2003.entities.deniamammal.EntityMammal;
import io.github.nagol2003.entities.moose.EntityMoose;
import io.github.nagol2003.entities.pigman.EntityPigman;
import io.github.nagol2003.entities.pigman2.EntityPigman2;
import io.github.nagol2003.entities.poluloscrab.EntityPolulosCrab;
import io.github.nagol2003.entities.poluloscrab.RenderCrab;
import io.github.nagol2003.registry.APRegistry;

public class EntityInit {
	
	public static void registerEntities(APRegistry registry) {
		
		registry.registerEntity(EntityPolulosCrab.class, "test", 94, 2, true, 13310623, 65354);
		registry.registerEntity(EntityMammal.class, "mammal", 94, 2, true, 13310623, 65354);
		registry.registerEntity(EntityPigman.class, "pigman", 94, 2, true, 13310623, 65354);
		registry.registerEntity(EntityPigman2.class, "pigman2", 94, 2, true, 13310623, 65354);
		registry.registerEntity(EntityMoose.class, "moose", 94, 2, true, 13310623, 65354);
	
		//registerEntity("test", EntityPolulosCrab.class, Const.ENTITY_POLULOSCRAB, 50, 13310623, 65354);
		
	}

	private static void registerNonMobEntity() {
		
	}

}
