package io.github.nagol2003.entities.poluloscrab;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

// Made with Blockbench 3.6.5
// Exported for Minecraft version 1.12
// Paste this class into your mod and generate all required imports


public class PolulosCrab extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer mandibles;
	private final ModelRenderer left;
	private final ModelRenderer left2;
	private final ModelRenderer right;
	private final ModelRenderer right2;
	private final ModelRenderer eyestock_right;
	private final ModelRenderer eye2;
	private final ModelRenderer eyestock_left;
	private final ModelRenderer eye;
	private final ModelRenderer leg1;
	private final ModelRenderer knee;
	private final ModelRenderer leg2;
	private final ModelRenderer knee2;
	private final ModelRenderer leg3;
	private final ModelRenderer knee3;
	private final ModelRenderer leg4;
	private final ModelRenderer knee4;
	private final ModelRenderer leg5;
	private final ModelRenderer knee5;
	private final ModelRenderer leg6;
	private final ModelRenderer knee6;
	private final ModelRenderer leg7;
	private final ModelRenderer knee7;
	private final ModelRenderer leg8;
	private final ModelRenderer knee8;
	private final ModelRenderer leg9;
	private final ModelRenderer knee9;
	private final ModelRenderer leg10;
	private final ModelRenderer knee10;
	private final ModelRenderer leg11;
	private final ModelRenderer knee11;
	private final ModelRenderer leg12;
	private final ModelRenderer knee12;

	public PolulosCrab() {
		textureWidth = 256;
		textureHeight = 256;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 20.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 21, -15.0F, -7.0F, -15.0F, 30, 7, 30, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 58, -14.0F, -8.0F, -14.0F, 28, 1, 28, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 87, -14.0F, 0.0F, -14.0F, 28, 1, 28, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -3.0F, -16.0F);
		body.addChild(head);
		head.cubeList.add(new ModelBox(head, 7, 10, -1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 9, -3.0F, -6.0F, -6.0F, 6, 6, 6, 0.0F, false));

		mandibles = new ModelRenderer(this);
		mandibles.setRotationPoint(0.0F, -2.0F, -6.0F);
		head.addChild(mandibles);
		

		left = new ModelRenderer(this);
		left.setRotationPoint(3.0F, 0.0F, 0.0F);
		mandibles.addChild(left);
		setRotationAngle(left, 0.1702F, -0.691F, -0.1091F);
		left.cubeList.add(new ModelBox(left, 39, 31, -1.0F, -1.0F, -2.0F, 1, 1, 3, 0.0F, false));

		left2 = new ModelRenderer(this);
		left2.setRotationPoint(-1.0F, -1.0F, -2.0F);
		left.addChild(left2);
		setRotationAngle(left2, 0.0F, 0.4363F, 0.0F);
		left2.cubeList.add(new ModelBox(left2, 39, 31, 0.0F, 0.0F, -2.0F, 1, 1, 3, -0.1F, false));

		right = new ModelRenderer(this);
		right.setRotationPoint(-2.0F, -1.0F, 1.0F);
		mandibles.addChild(right);
		setRotationAngle(right, 0.1714F, 0.7348F, -0.0649F);
		right.cubeList.add(new ModelBox(right, 59, 36, -0.4807F, -0.1561F, -3.2964F, 1, 1, 3, 0.0F, false));

		right2 = new ModelRenderer(this);
		right2.setRotationPoint(-0.4807F, -0.3561F, -3.2964F);
		right.addChild(right2);
		setRotationAngle(right2, 0.0F, -0.4363F, 0.0F);
		right2.cubeList.add(new ModelBox(right2, 59, 36, 0.0F, 0.2F, -3.0F, 1, 1, 3, -0.1F, false));

		eyestock_right = new ModelRenderer(this);
		eyestock_right.setRotationPoint(-1.0F, -6.0F, -5.0F);
		head.addChild(eyestock_right);
		setRotationAngle(eyestock_right, 0.0F, 0.0F, -0.2967F);
		eyestock_right.cubeList.add(new ModelBox(eyestock_right, 0, 5, -1.0F, -3.0F, 0.0F, 1, 3, 1, 0.0F, false));

		eye2 = new ModelRenderer(this);
		eye2.setRotationPoint(-0.2924F, -2.0437F, 0.0F);
		eyestock_right.addChild(eye2);
		setRotationAngle(eye2, 0.0F, 0.0F, 0.384F);
		eye2.cubeList.add(new ModelBox(eye2, 0, 0, -2.0F, -3.0F, -0.5F, 3, 3, 2, 0.0F, false));

		eyestock_left = new ModelRenderer(this);
		eyestock_left.setRotationPoint(1.0F, -6.0F, -5.0F);
		head.addChild(eyestock_left);
		setRotationAngle(eyestock_left, 0.0F, 0.0F, 0.2967F);
		eyestock_left.cubeList.add(new ModelBox(eyestock_left, 0, 5, 0.0F, -3.0F, 0.0F, 1, 3, 1, 0.0F, false));

		eye = new ModelRenderer(this);
		eye.setRotationPoint(0.2924F, -2.0437F, 0.0F);
		eyestock_left.addChild(eye);
		setRotationAngle(eye, 0.0F, 0.0F, -0.384F);
		eye.cubeList.add(new ModelBox(eye, 0, 0, -1.0F, -3.0F, -0.5F, 3, 3, 2, 0.0F, false));

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(14.0F, 0.0F, -9.0F);
		body.addChild(leg1);
		setRotationAngle(leg1, 0.0F, 0.0F, -1.309F);
		leg1.cubeList.add(new ModelBox(leg1, 56, 31, -1.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F, false));

		knee = new ModelRenderer(this);
		knee.setRotationPoint(0.0F, 5.0F, 0.0F);
		leg1.addChild(knee);
		setRotationAngle(knee, 0.0F, 0.0F, 0.1745F);
		knee.cubeList.add(new ModelBox(knee, 79, 33, -1.0F, -1.0F, -1.0F, 2, 6, 2, -0.25F, false));

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(14.0F, 0.0F, -5.0F);
		body.addChild(leg2);
		setRotationAngle(leg2, 0.0F, 0.0F, -1.309F);
		leg2.cubeList.add(new ModelBox(leg2, 72, 27, -1.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F, false));

		knee2 = new ModelRenderer(this);
		knee2.setRotationPoint(0.0F, 5.0F, 0.0F);
		leg2.addChild(knee2);
		setRotationAngle(knee2, 0.0F, 0.0F, 0.1745F);
		knee2.cubeList.add(new ModelBox(knee2, 40, 41, -1.0F, -1.0F, -1.0F, 2, 6, 2, -0.25F, false));

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(14.0F, 0.0F, -1.0F);
		body.addChild(leg3);
		setRotationAngle(leg3, 0.0F, 0.0F, -1.309F);
		leg3.cubeList.add(new ModelBox(leg3, 43, 48, -1.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F, false));

		knee3 = new ModelRenderer(this);
		knee3.setRotationPoint(0.0F, 5.0F, 0.0F);
		leg3.addChild(knee3);
		setRotationAngle(knee3, 0.0F, 0.0F, 0.1745F);
		knee3.cubeList.add(new ModelBox(knee3, 78, 29, -1.0F, -1.0F, -1.0F, 2, 6, 2, -0.25F, false));

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(14.0F, 0.0F, 3.0F);
		body.addChild(leg4);
		setRotationAngle(leg4, 0.0F, 0.0F, -1.309F);
		leg4.cubeList.add(new ModelBox(leg4, 46, 32, -1.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F, false));

		knee4 = new ModelRenderer(this);
		knee4.setRotationPoint(0.0F, 5.0F, 0.0F);
		leg4.addChild(knee4);
		setRotationAngle(knee4, 0.0F, 0.0F, 0.1745F);
		knee4.cubeList.add(new ModelBox(knee4, 40, 46, -1.0F, -1.0F, -1.0F, 2, 6, 2, -0.25F, false));

		leg5 = new ModelRenderer(this);
		leg5.setRotationPoint(14.0F, 0.0F, 7.0F);
		body.addChild(leg5);
		setRotationAngle(leg5, 0.0F, 0.0F, -1.309F);
		leg5.cubeList.add(new ModelBox(leg5, 40, 36, -1.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F, false));

		knee5 = new ModelRenderer(this);
		knee5.setRotationPoint(0.0F, 5.0F, 0.0F);
		leg5.addChild(knee5);
		setRotationAngle(knee5, 0.0F, 0.0F, 0.1745F);
		knee5.cubeList.add(new ModelBox(knee5, 74, 40, -1.0F, -1.0F, -1.0F, 2, 6, 2, -0.25F, false));

		leg6 = new ModelRenderer(this);
		leg6.setRotationPoint(14.0F, 0.0F, 11.0F);
		body.addChild(leg6);
		setRotationAngle(leg6, 0.0F, 0.0F, -1.309F);
		leg6.cubeList.add(new ModelBox(leg6, 53, 40, -1.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F, false));

		knee6 = new ModelRenderer(this);
		knee6.setRotationPoint(0.0F, 5.0F, 0.0F);
		leg6.addChild(knee6);
		setRotationAngle(knee6, 0.0F, 0.0F, 0.1745F);
		knee6.cubeList.add(new ModelBox(knee6, 70, 36, -1.0F, -1.0F, -1.0F, 2, 6, 2, -0.25F, false));

		leg7 = new ModelRenderer(this);
		leg7.setRotationPoint(-14.0F, 0.0F, -9.0F);
		body.addChild(leg7);
		setRotationAngle(leg7, 3.1416F, 0.0F, -1.8326F);
		leg7.cubeList.add(new ModelBox(leg7, 50, 39, -1.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F, false));

		knee7 = new ModelRenderer(this);
		knee7.setRotationPoint(0.0F, 5.0F, 0.0F);
		leg7.addChild(knee7);
		setRotationAngle(knee7, 0.0F, 0.0F, 0.1745F);
		knee7.cubeList.add(new ModelBox(knee7, 65, 45, -1.0F, -1.0F, -1.0F, 2, 6, 2, -0.25F, false));

		leg8 = new ModelRenderer(this);
		leg8.setRotationPoint(-14.0F, 0.0F, -5.0F);
		body.addChild(leg8);
		setRotationAngle(leg8, 3.1416F, 0.0F, -1.8326F);
		leg8.cubeList.add(new ModelBox(leg8, 68, 34, -1.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F, false));

		knee8 = new ModelRenderer(this);
		knee8.setRotationPoint(0.0F, 5.0F, 0.0F);
		leg8.addChild(knee8);
		setRotationAngle(knee8, 0.0F, 0.0F, 0.1745F);
		knee8.cubeList.add(new ModelBox(knee8, 41, 28, -1.0F, -1.0F, -1.0F, 2, 6, 2, -0.25F, false));

		leg9 = new ModelRenderer(this);
		leg9.setRotationPoint(-14.0F, 0.0F, -1.0F);
		body.addChild(leg9);
		setRotationAngle(leg9, 3.1416F, 0.0F, -1.8326F);
		leg9.cubeList.add(new ModelBox(leg9, 42, 37, -1.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F, false));

		knee9 = new ModelRenderer(this);
		knee9.setRotationPoint(0.0F, 5.0F, 0.0F);
		leg9.addChild(knee9);
		setRotationAngle(knee9, 0.0F, 0.0F, 0.1745F);
		knee9.cubeList.add(new ModelBox(knee9, 57, 35, -1.0F, -1.0F, -1.0F, 2, 6, 2, -0.25F, false));

		leg10 = new ModelRenderer(this);
		leg10.setRotationPoint(-14.0F, 0.0F, 3.0F);
		body.addChild(leg10);
		setRotationAngle(leg10, 3.1416F, 0.0F, -1.8326F);
		leg10.cubeList.add(new ModelBox(leg10, 70, 41, -1.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F, false));

		knee10 = new ModelRenderer(this);
		knee10.setRotationPoint(0.0F, 5.0F, 0.0F);
		leg10.addChild(knee10);
		setRotationAngle(knee10, 0.0F, 0.0F, 0.1745F);
		knee10.cubeList.add(new ModelBox(knee10, 61, 34, -1.0F, -1.0F, -1.0F, 2, 6, 2, -0.25F, false));

		leg11 = new ModelRenderer(this);
		leg11.setRotationPoint(-14.0F, 0.0F, 7.0F);
		body.addChild(leg11);
		setRotationAngle(leg11, 3.1416F, 0.0F, -1.8326F);
		leg11.cubeList.add(new ModelBox(leg11, 55, 37, -1.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F, false));

		knee11 = new ModelRenderer(this);
		knee11.setRotationPoint(0.0F, 5.0F, 0.0F);
		leg11.addChild(knee11);
		setRotationAngle(knee11, 0.0F, 0.0F, 0.1745F);
		knee11.cubeList.add(new ModelBox(knee11, 80, 38, -1.0F, -1.0F, -1.0F, 2, 6, 2, -0.25F, false));

		leg12 = new ModelRenderer(this);
		leg12.setRotationPoint(-14.0F, 0.0F, 11.0F);
		body.addChild(leg12);
		setRotationAngle(leg12, 3.1416F, 0.0F, -1.8326F);
		leg12.cubeList.add(new ModelBox(leg12, 38, 29, -1.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F, false));

		knee12 = new ModelRenderer(this);
		knee12.setRotationPoint(0.0F, 5.0F, 0.0F);
		leg12.addChild(knee12);
		setRotationAngle(knee12, 0.0F, 0.0F, 0.1745F);
		knee12.cubeList.add(new ModelBox(knee12, 63, 34, -1.0F, -1.0F, -1.0F, 2, 6, 2, -0.25F, false));
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