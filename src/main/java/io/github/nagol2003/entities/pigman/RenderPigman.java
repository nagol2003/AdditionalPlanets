package io.github.nagol2003.entities.pigman;

import io.github.nagol2003.Const;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPigman extends RenderLiving<EntityPigman> {
	
	public static final ResourceLocation TEXTURE = new ResourceLocation(Const.modID + ":textures/entities/pigman.png");
	
	public RenderPigman(RenderManager manager) {
		
		super(manager, new Pigman(), 0.2f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPigman entity) 
	{
		return TEXTURE;
	}
	
}
