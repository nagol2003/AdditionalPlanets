package io.github.nagol2003.entities.deniamammal;

import io.github.nagol2003.Const;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderMammal extends RenderLiving<EntityMammal> {
	
	public static final ResourceLocation TEXTURE = new ResourceLocation(Const.modID + ":textures/entities/mammal.png");
	
	public RenderMammal(RenderManager manager) {
		
		super(manager, new mammal(), 0.2f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityMammal entity) 
	{
		return TEXTURE;
	}
	
}
