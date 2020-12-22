package io.github.nagol2003.entities.poluloscrab;

import io.github.nagol2003.Const;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCrab extends RenderLiving<EntityPolulosCrab> {
	
	public static final ResourceLocation TEXTURE = new ResourceLocation(Const.modID + ":textures/entities/crab.png");
	
	public RenderCrab(RenderManager manager) {
		
		super(manager, new PolulosCrab(), 0.2f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPolulosCrab entity) 
	{
		return TEXTURE;
	}
	
}
