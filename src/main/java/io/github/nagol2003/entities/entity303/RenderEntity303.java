package io.github.nagol2003.entities.entity303;

import io.github.nagol2003.Const;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderEntity303 extends RenderLiving<EntityEntity303> {
	
	public static final ResourceLocation TEXTURE = new ResourceLocation(Const.modID + ":textures/entities/entity303.png");
	
	public RenderEntity303(RenderManager manager) {
		
		super(manager, new Entity303(), 0.2f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityEntity303 entity) 
	{
		return TEXTURE;
	}
	
}
