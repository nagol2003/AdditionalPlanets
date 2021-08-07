package io.github.nagol2003.entities.deniamammal;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityMammal extends EntityAgeable {

	public float rotation;
	public float prevRotation;
	private float randomMotionSpeed;
	private float rotationVelocity;
	private float rotateSpeed;
	private float randomMotionVecX;
	private float randomMotionVecY;
	private float randomMotionVecZ;

	public EntityMammal(World worldIn) {
		super(worldIn);
		this.setSize(2.0F, height);

	}

	public static void registerFixesSquid(DataFixer fixer) {
		EntityLiving.registerFixesMob(fixer, EntityMammal.class);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}
	
	 protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
	    {
	        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
	    }

	@Override
	public boolean isEntityInsideOpaqueBlock() {
		return super.isEntityInsideOpaqueBlock();
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		this.prevRotation = this.rotation;
		this.rotation += this.rotationVelocity;

		if (inWater) {
			if (this.rotation < (float) Math.PI) {
				float f = this.rotation / (float) Math.PI;

				if (f > 0.75D) {
					this.randomMotionSpeed = 1.5F;
					this.rotateSpeed = 1.0F;
				} else {
					this.rotateSpeed *= 0.8F;
				}
			} else {
				this.randomMotionSpeed *= 1.0F;
				this.rotateSpeed *= 0.99F;
			}

			if (!this.world.isRemote) {
				this.motionX = this.randomMotionVecX * this.randomMotionSpeed;
				this.motionY = this.randomMotionVecY * this.randomMotionSpeed;
				this.motionZ = this.randomMotionVecZ * this.randomMotionSpeed;
			}

			this.renderYawOffset += (-((float) MathHelper.atan2(this.motionX, this.motionZ)) * (180F / (float) Math.PI)
					- this.renderYawOffset) * 0.1F;
			this.rotationYaw = this.renderYawOffset;
			stepHeight = 3.0F;
		} else {
			if (!this.world.isRemote) {
				this.motionX = 0.0D;
				this.motionZ = 0.0D;

				this.motionY *= 0.9800000190734863D;
			}

			stepHeight = 1F;
		}
		super.onLivingUpdate();
	}

	@Override
	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAIPanic(this, 1.55D));
		this.tasks.addTask(2, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAIWander(this, 1.3D));
		this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.5D, true));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 1.0F));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.15D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(3.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(2.0D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.5D);
	}

	@Override
	protected float getJumpUpwardsMotion() {
		return 0.92F;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {

		this.setSize(0.5F, 0.5F);
		return new EntityMammal(world);
	}

	public void setMovementVector(float randomMotionVecXIn, float randomMotionVecYIn, float randomMotionVecZIn) {
		this.randomMotionVecX = randomMotionVecXIn;
		this.randomMotionVecY = randomMotionVecYIn;
		this.randomMotionVecZ = randomMotionVecZIn;
	}

	@Override
	protected boolean canTriggerWalking() {
		return true;
	}

	public boolean hasMovementVector() {
		return this.randomMotionVecX != 0.0F || this.randomMotionVecY != 0.0F || this.randomMotionVecZ != 0.0F;
	}

	@Override
	public void travel(float strafe, float vertical, float forward) {
		super.travel(strafe, vertical, forward);
	}

}
