package io.github.nagol2003.util.handlers;

import io.github.nagol2003.entities.deniamammal.EntityMammal;
import io.github.nagol2003.entities.deniamammal.RenderMammal;
import io.github.nagol2003.entities.entity303.EntityEntity303;
import io.github.nagol2003.entities.entity303.RenderEntity303;
import io.github.nagol2003.entities.moose.EntityMoose;
import io.github.nagol2003.entities.moose.RenderMoose;
import io.github.nagol2003.entities.pigman.EntityPigman;
import io.github.nagol2003.entities.pigman.RenderPigman;
import io.github.nagol2003.entities.pigman2.EntityPigman2;
import io.github.nagol2003.entities.pigman2.RenderPigman2;
import io.github.nagol2003.entities.poluloscrab.EntityPolulosCrab;
import io.github.nagol2003.entities.poluloscrab.RenderCrab;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
	
	public static void registerEntityRenders() {
		
		RenderingRegistry.registerEntityRenderingHandler(EntityPolulosCrab.class, new IRenderFactory<EntityPolulosCrab>() {
			@Override
			public Render<? super EntityPolulosCrab> createRenderFor(RenderManager manager) {
				return new RenderCrab(manager);
			}
		});
		
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMammal.class, new IRenderFactory<EntityMammal>() {
			@Override
			public Render<? super EntityMammal> createRenderFor(RenderManager manager) {
				return new RenderMammal(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMoose.class, new IRenderFactory<EntityMoose>() {
			@Override
			public Render<? super EntityMoose> createRenderFor(RenderManager manager) {
				return new RenderMoose(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityPigman.class, new IRenderFactory<EntityPigman>() {
			@Override
			public Render<? super EntityPigman> createRenderFor(RenderManager manager) {
				return new RenderPigman(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityPigman2.class, new IRenderFactory<EntityPigman2>() {
			@Override
			public Render<? super EntityPigman2> createRenderFor(RenderManager manager) {
				return new RenderPigman2(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityEntity303.class, new IRenderFactory<EntityEntity303>() {
			@Override
			public Render<? super EntityEntity303> createRenderFor(RenderManager manager) {
				return new RenderEntity303(manager);
			}
		});
		
		
	}

}
