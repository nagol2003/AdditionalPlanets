package io.github.nagol2003.util.handlers;

import io.github.nagol2003.Const;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler {
	public static SoundEvent ENTITY_PIGMAN_HURT;
	
	public static void registerSounds()
	{
		ENTITY_PIGMAN_HURT = registerSound("entity.pigman.hurt");
	}
	
	private static SoundEvent registerSound(String name)
	{
		ResourceLocation location = new ResourceLocation(Const.modID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}
}