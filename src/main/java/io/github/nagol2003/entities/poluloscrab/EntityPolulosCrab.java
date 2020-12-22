package io.github.nagol2003.entities.poluloscrab;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityPolulosCrab extends EntityAgeable {

	public EntityPolulosCrab(World worldIn) {
		super(worldIn);
		this.setSize(width, height);

	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(2, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIWander(this, 0.3D));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.5D, true));
		this.tasks.addTask(2, new EntityAIAvoidEntity<>(this, EntityMob.class, 4.0F, 2.2D, 2.2D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 1.0F));
	}
	
	@Override
	protected void applyEntityAttributes() {
		
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20115D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(10.0D);
	}
	
	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		
		this.setSize(0.5F, 0.5F);
		return new EntityPolulosCrab(world);
	}

	/*@Override
	protected SoundEvent getDeathSound() {
		
		return super.getDeathSound();
	}
	
	
	//soundhandlers with test sounds from turtywurty tutorial
	
	
	@Override
	protected SoundEvent getAmbientSound() {
		
		return super.getAmbientSound();
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		
		return super.getHurtSound(damageSourceIn);
	}
	
	@Override
	protected ResourceLocation getLootTable() {
		
		return super.getLootTable();
	} */

}





//canbe and Entity methods