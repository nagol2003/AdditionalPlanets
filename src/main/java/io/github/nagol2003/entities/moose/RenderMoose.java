package io.github.nagol2003.entities.moose;

import io.github.nagol2003.Const;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderMoose extends RenderLiving<EntityMoose> {
	
	public static final ResourceLocation TEXTURE = new ResourceLocation(Const.modID + ":textures/entities/moose.png");
	
	public RenderMoose(RenderManager manager) {
		
		super(manager, new Moose(), 0.2f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityMoose entity) 
	{
		return TEXTURE;
	}
	
}
