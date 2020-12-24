package io.github.nagol2003.entities.deniamammal;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.12
// Paste this class into your mod and generate all required imports


public class mammal extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer leg;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer leg4;

	public mammal() {
		textureWidth = 256;
		textureHeight = 256;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 25, 199, -6.0F, -34.0F, -2.0F, 6, 19, 4, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(-4.0F, -34.0F, 0.0F);
		body.addChild(head);
		head.cubeList.add(new ModelBox(head, 55, 30, -3.0F, -4.0F, -3.0F, 8, 4, 5, 0.0F, false));

		leg = new ModelRenderer(this);
		leg.setRotationPoint(-1.0F, -15.0F, 0.0F);
		body.addChild(leg);
		leg.cubeList.add(new ModelBox(leg, 31, 104, -1.0F, 0.0F, -1.0F, 2, 15, 2, 0.0F, false));

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(-1.0F, -15.0F, 0.0F);
		body.addChild(leg2);
		leg2.cubeList.add(new ModelBox(leg2, 40, 105, -5.0F, 0.0F, -1.0F, 2, 15, 2, 0.0F, false));

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(-1.0F, -15.0F, 0.0F);
		body.addChild(leg3);
		leg3.cubeList.add(new ModelBox(leg3, 80, 108, -7.0F, -15.0F, -1.0F, 2, 15, 2, 0.0F, false));

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(-1.0F, -15.0F, 0.0F);
		body.addChild(leg4);
		leg4.cubeList.add(new ModelBox(leg4, 85, 101, 3.0F, -15.0F, -1.0F, -8, 15, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}