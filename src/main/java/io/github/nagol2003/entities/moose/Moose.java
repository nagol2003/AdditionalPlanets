package io.github.nagol2003.entities.moose;
// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class Moose extends ModelBase {
	private final ModelRenderer bone;
	private final ModelRenderer Head;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer RightFrontLeg;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer LeftFrontLeg;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer Body;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer LeftBackLeg;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer RightBackLeg;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;

	public Moose() {
		textureWidth = 384;
		textureHeight = 384;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, -5.0F);
		

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -45.0F, -24.0F);
		bone.addChild(Head);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 1.5F, -30.0F);
		Head.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.3491F, 0.0F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 135, -7.5F, -6.0F, 0.75F, 15, 15, 15, 0.0F, false));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(12.0F, -11.25F, -7.5F);
		Head.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.1614F, -0.0654F, 0.3883F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 12, -6.0F, -3.75F, -1.5F, 6, 9, 3, 0.0F, false));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-12.0F, -11.25F, -7.5F);
		Head.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.1614F, 0.0654F, -0.3883F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 0, 0.0F, -3.75F, -1.5F, 6, 9, 3, 0.0F, false));

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-13.5F, -6.75F, -13.5F);
		Head.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.1614F, -0.0654F, 0.3883F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 42, 95, -4.5F, -8.25F, -3.0F, 12, 6, 6, 0.0F, false));

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-13.5F, -6.75F, -13.5F);
		Head.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.5367F, -0.1004F, 0.6021F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 69, 48, -31.5F, -5.25F, -13.5F, 27, 0, 27, 0.0F, false));

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(13.5F, -6.75F, -13.5F);
		Head.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.5367F, 0.1004F, -0.6021F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 75, 0, 4.5F, -5.25F, -13.5F, 27, 0, 27, 0.0F, false));

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(13.5F, -6.75F, -13.5F);
		Head.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.1614F, 0.0654F, -0.3883F);
		cube_r7.cubeList.add(new ModelBox(cube_r7, 162, 92, -7.5F, -8.25F, -3.0F, 12, 6, 6, 0.0F, false));

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(0.0F, -1.5F, -1.5F);
		Head.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.1745F, 0.0F, 0.0F);
		cube_r8.cubeList.add(new ModelBox(cube_r8, 144, 63, -9.0F, -12.75F, -15.0F, 18, 18, 12, 0.0F, false));

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(0.0F, 0.0F, -6.0F);
		Head.addChild(cube_r9);
		setRotationAngle(cube_r9, -0.1309F, 0.0F, 0.0F);
		cube_r9.cubeList.add(new ModelBox(cube_r9, 153, 150, -7.5F, -12.0F, -3.0F, 15, 18, 12, 0.0F, false));

		RightFrontLeg = new ModelRenderer(this);
		RightFrontLeg.setRotationPoint(15.0F, -42.0F, -9.0F);
		bone.addChild(RightFrontLeg);
		RightFrontLeg.cubeList.add(new ModelBox(RightFrontLeg, 144, 180, -6.0F, 21.0F, 0.0F, 6, 21, 6, 0.0F, false));

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-3.0F, 12.0F, 3.0F);
		RightFrontLeg.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0873F, 0.0F, 0.0F);
		cube_r10.cubeList.add(new ModelBox(cube_r10, 0, 165, -4.5F, -9.0F, -6.75F, 9, 18, 12, 0.0F, false));

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-3.0F, 12.0F, 3.0F);
		RightFrontLeg.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.2182F, 0.0F, 0.0F);
		cube_r11.cubeList.add(new ModelBox(cube_r11, 60, 147, -6.0F, -21.0F, -7.5F, 12, 18, 15, 0.0F, false));

		LeftFrontLeg = new ModelRenderer(this);
		LeftFrontLeg.setRotationPoint(-15.0F, -42.0F, -9.0F);
		bone.addChild(LeftFrontLeg);
		LeftFrontLeg.cubeList.add(new ModelBox(LeftFrontLeg, 168, 180, 0.0F, 21.0F, 0.0F, 6, 21, 6, 0.0F, false));

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(3.0F, 12.0F, 3.0F);
		LeftFrontLeg.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0873F, 0.0F, 0.0F);
		cube_r12.cubeList.add(new ModelBox(cube_r12, 180, 30, -4.5F, -9.0F, -6.75F, 9, 18, 12, 0.0F, false));

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(3.0F, 12.0F, 3.0F);
		LeftFrontLeg.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.2182F, 0.0F, 0.0F);
		cube_r13.cubeList.add(new ModelBox(cube_r13, 147, 105, -6.0F, -21.0F, -7.5F, 12, 18, 15, 0.0F, false));

		Body = new ModelRenderer(this);
		Body.setRotationPoint(-7.5F, -58.6202F, -21.2989F);
		bone.addChild(Body);
		Body.cubeList.add(new ModelBox(Body, 0, 48, -4.5F, 3.8702F, 18.2989F, 24, 24, 24, 0.0F, false));

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(7.5F, 3.1202F, 0.2989F);
		Body.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.1745F, 0.0F, 0.0F);
		cube_r14.cubeList.add(new ModelBox(cube_r14, 102, 26, -12.0F, -2.25F, -1.5F, 24, 6, 15, 0.0F, false));

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(7.5F, 0.8702F, 13.7989F);
		Body.addChild(cube_r15);
		setRotationAngle(cube_r15, -0.3927F, 0.0F, 0.0F);
		cube_r15.cubeList.add(new ModelBox(cube_r15, 45, 120, -12.0F, -2.25F, -1.5F, 24, 6, 15, 0.0F, false));

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(7.5F, 15.8702F, 9.2989F);
		Body.addChild(cube_r16);
		setRotationAngle(cube_r16, -0.1745F, 0.0F, 0.0F);
		cube_r16.cubeList.add(new ModelBox(cube_r16, 0, 0, -13.5F, -12.0F, -11.25F, 27, 24, 24, 0.0F, false));

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(7.5F, 14.3702F, 51.2989F);
		Body.addChild(cube_r17);
		setRotationAngle(cube_r17, -0.3054F, 0.0F, 0.0F);
		cube_r17.cubeList.add(new ModelBox(cube_r17, 78, 78, -12.0F, -9.0F, -12.0F, 24, 24, 18, 0.0F, false));

		LeftBackLeg = new ModelRenderer(this);
		LeftBackLeg.setRotationPoint(-19.5F, -43.5F, 30.0F);
		bone.addChild(LeftBackLeg);
		LeftBackLeg.cubeList.add(new ModelBox(LeftBackLeg, 42, 174, 4.5F, 19.5F, -3.0F, 6, 24, 6, 0.0F, false));

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(6.0F, 9.0F, 0.0F);
		LeftBackLeg.addChild(cube_r18);
		setRotationAngle(cube_r18, -0.3927F, 0.0F, 0.0F);
		cube_r18.cubeList.add(new ModelBox(cube_r18, 105, 123, -5.25F, -16.5F, -13.5F, 12, 21, 18, 0.0F, false));

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(6.0F, 9.0F, 0.0F);
		LeftBackLeg.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.3927F, 0.0F, 0.0F);
		cube_r19.cubeList.add(new ModelBox(cube_r19, 102, 168, -3.0F, -4.5F, -10.5F, 9, 18, 12, 0.0F, false));

		RightBackLeg = new ModelRenderer(this);
		RightBackLeg.setRotationPoint(19.5F, -43.5F, 30.0F);
		bone.addChild(RightBackLeg);
		RightBackLeg.cubeList.add(new ModelBox(RightBackLeg, 42, 174, -10.5F, 19.5F, -3.0F, 6, 24, 6, 0.0F, false));

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(-6.0F, 9.0F, 0.0F);
		RightBackLeg.addChild(cube_r20);
		setRotationAngle(cube_r20, -0.3927F, 0.0F, 0.0F);
		cube_r20.cubeList.add(new ModelBox(cube_r20, 0, 96, -6.75F, -16.5F, -13.5F, 12, 21, 18, 0.0F, false));

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(-6.0F, 9.0F, 0.0F);
		RightBackLeg.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.3927F, 0.0F, 0.0F);
		cube_r21.cubeList.add(new ModelBox(cube_r21, 165, 0, -6.0F, -4.5F, -10.5F, 9, 18, 12, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bone.render(f5);
	}
	
public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		
		this.RightBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
		this.LeftBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * -1.4F * limbSwingAmount;
		this.LeftFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}