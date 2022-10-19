package io.github.nagol2003.entities.pigman2;

import io.github.nagol2003.Const;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPigman2 extends RenderLiving<EntityPigman2> {
	
	public static final ResourceLocation TEXTURE = new ResourceLocation(Const.modID + ":textures/entities/pigman2.png");
	
	public RenderPigman2(RenderManager manager) {
		
		super(manager, new Pigman2(), 0.2f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPigman2 entity) 
	{
		return TEXTURE;
	}
	
}
