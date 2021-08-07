package io.github.nagol2003.entities.deniamammal;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

//Made with Blockbench 3.9.2
//Exported for Minecraft version 1.7 - 1.12
//Paste this class into your mod and generate all required imports


public class Mammal extends ModelBase {
	private final ModelRenderer RightLeg;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer Body;
	private final ModelRenderer cube_r5;
	private final ModelRenderer Head;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer RightArm;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer LeftArm;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;

	public Mammal() {
		textureWidth = 64;
		textureHeight = 64;

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(2.0F, 12.0F, 2.0F);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 35, 0, -1.0F, 10.0F, -4.25F, 2, 2, 5, 0.0F, false));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 6.2371F, -0.8828F);
		RightLeg.addChild(cube_r1);
		//setRotationAngle(cube_r1, -0.0873F, 0.0F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 40, 21, -1.5F, -1.5F, -2.0F, 3, 1, 3, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 15, 50, -1.5F, -9.5F, -2.0F, 3, 8, 3, 0.0F, false));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 11.564F, 0.5181F);
		RightLeg.addChild(cube_r2);
		//setRotationAngle(cube_r2, 0.1745F, 0.0F, 0.0F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 42, 7, -1.0F, -7.5F, -1.5F, 2, 6, 2, 0.0F, false));

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(-2.0F, 12.0F, 2.0F);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 33, 10, -1.0F, 10.0F, -4.25F, 2, 2, 5, 0.0F, false));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 6.2371F, -0.8828F);
		LeftLeg.addChild(cube_r3);
		//setRotationAngle(cube_r3, -0.0873F, 0.0F, 0.0F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 36, 17, -1.5F, -1.5F, -2.0F, 3, 1, 3, 0.0F, false));
		cube_r3.cubeList.add(new ModelBox(cube_r3, 28, 50, -1.5F, -9.5F, -2.0F, 3, 8, 3, 0.0F, false));

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 11.564F, 0.5181F);
		LeftLeg.addChild(cube_r4);
		//setRotationAngle(cube_r4, 0.1745F, 0.0F, 0.0F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 40, 35, -1.0F, -7.5F, -1.5F, 2, 6, 2, 0.0F, false));

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 12.0F, 2.0F);
		Body.cubeList.add(new ModelBox(Body, 41, 50, -3.0F, -11.0F, -2.5F, 6, 8, 4, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 6, 42, 0.0F, -11.0F, 1.5F, 0, 5, 3, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 42, -1.0F, -11.0F, 0.5F, 0, 5, 3, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 34, 41, 1.0F, -11.0F, 0.5F, 0, 5, 3, 0.0F, false));

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, -9.0F, 0.0F);
		Body.addChild(cube_r5);
		//setRotationAngle(cube_r5, 0.1309F, 0.0F, 0.0F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 11, -3.5F, -2.0F, -3.5F, 7, 1, 6, 0.0F, false));
		cube_r5.cubeList.add(new ModelBox(cube_r5, 40, 40, 2.0F, -7.0F, 1.5F, 0, 6, 3, 0.0F, false));
		cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 8, -2.0F, -7.0F, 1.5F, 0, 6, 3, 0.0F, false));
		cube_r5.cubeList.add(new ModelBox(cube_r5, 28, 41, 0.0F, -7.0F, 2.5F, 0, 6, 3, 0.0F, false));
		cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 0, -3.5F, -7.0F, -3.5F, 7, 5, 6, 0.0F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 2.0F, -0.8F);
		Head.cubeList.add(new ModelBox(Head, 0, 18, -2.5F, -10.0F, -3.2F, 5, 5, 5, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 20, 15, -2.5F, -5.0F, -2.2F, 5, 2, 0, 0.0F, false));

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-4.5865F, -8.6394F, -0.7F);
		Head.addChild(cube_r6);
		//setRotationAngle(cube_r6, 0.0F, 0.0F, 0.7854F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 15, 18, -2.75F, -2.0F, -1.0F, 2, 2, 2, 0.0F, false));

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(3.5F, -8.5F, -0.7F);
		Head.addChild(cube_r7);
		//setRotationAngle(cube_r7, 0.0F, 0.0F, -0.3927F);
		cube_r7.cubeList.add(new ModelBox(cube_r7, 43, 25, -1.25F, -2.0F, -1.0F, 3, 2, 2, 0.0F, false));

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-3.5F, -8.5F, -0.7F);
		Head.addChild(cube_r8);
		//setRotationAngle(cube_r8, 0.0F, 0.0F, 0.3927F);
		cube_r8.cubeList.add(new ModelBox(cube_r8, 44, 0, -1.75F, -2.0F, -1.0F, 3, 2, 2, 0.0F, false));

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(5.5F, 4.0F, 1.0F);
		RightArm.cubeList.add(new ModelBox(RightArm, 20, 35, -1.0F, -4.5F, -1.0F, 2, 11, 2, 0.0F, false));

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(0.0F, -5.0F, 0.0F);
		RightArm.addChild(cube_r9);
		//setRotationAngle(cube_r9, 0.0F, 0.0F, 0.2182F);
		cube_r9.cubeList.add(new ModelBox(cube_r9, 32, 27, -2.0F, -5.0F, -1.5F, 4, 5, 3, 0.0F, false));

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(0.0F, -5.0F, 0.0F);
		RightArm.addChild(cube_r10);
		//setRotationAngle(cube_r10, 0.0F, 0.0F, -0.2618F);
		cube_r10.cubeList.add(new ModelBox(cube_r10, 16, 27, -2.0F, -3.0F, -2.0F, 4, 4, 4, 0.0F, false));

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(-5.5F, 4.0F, 1.0F);
		LeftArm.cubeList.add(new ModelBox(LeftArm, 12, 35, -1.0F, -4.5F, -1.0F, 2, 11, 2, 0.0F, false));

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(0.0F, -5.0F, 0.0F);
		LeftArm.addChild(cube_r11);
		//setRotationAngle(cube_r11, 0.0F, 0.0F, -0.2182F);
		cube_r11.cubeList.add(new ModelBox(cube_r11, 0, 28, -2.0F, -5.0F, -1.5F, 4, 5, 3, 0.0F, false));

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(0.0F, -5.0F, 0.0F);
		LeftArm.addChild(cube_r12);
		//setRotationAngle(cube_r12, 0.0F, 0.0F, 0.2618F);
		cube_r12.cubeList.add(new ModelBox(cube_r12, 22, 7, -2.0F, -3.0F, -2.0F, 4, 4, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		RightLeg.render(f5);
		LeftLeg.render(f5);
		Body.render(f5);
		Head.render(f5);
		RightArm.render(f5);
		LeftArm.render(f5);
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		
		this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * -1.4F * limbSwingAmount;
		this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
		this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 0.7F * limbSwingAmount;
		this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * -0.7F * limbSwingAmount;
	}
}