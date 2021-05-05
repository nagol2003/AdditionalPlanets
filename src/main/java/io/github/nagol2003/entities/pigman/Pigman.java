package io.github.nagol2003.entities.pigman;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;


public class Pigman extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer arm;
	private final ModelRenderer arm2;
	private final ModelRenderer arm3;
	private final ModelRenderer arm4;

	public Pigman() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 9, 13, -5.0F, -26.0F, -4.0F, 8, 14, 5, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(head);
		head.cubeList.add(new ModelBox(head, 1, 1, -5.0F, -34.0F, -5.0F, 8, 8, 7, 0.0F, false));

		arm = new ModelRenderer(this);
		arm.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(arm);
		arm.cubeList.add(new ModelBox(arm, 13, 13, 3.0F, -26.0F, -4.0F, 4, 14, 5, 0.0F, false));

		arm2 = new ModelRenderer(this);
		arm2.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(arm2);
		arm2.cubeList.add(new ModelBox(arm2, 33, 13, -9.0F, -26.0F, -4.0F, 4, 14, 5, 0.0F, false));

		arm3 = new ModelRenderer(this);
		arm3.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(arm3);
		arm3.cubeList.add(new ModelBox(arm3, 16, 47, -5.0F, -12.0F, -4.0F, 4, 12, 5, 0.0F, false));

		arm4 = new ModelRenderer(this);
		arm4.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(arm4);
		arm4.cubeList.add(new ModelBox(arm4, 16, 47, -1.0F, -12.0F, -4.0F, 4, 12, 5, 0.0F, false));
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
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		
	//	this.body.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
	//	this.head.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
		this.arm.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
		this.arm2.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
		this.arm3.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
		this.arm4.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
		
	}
	
}