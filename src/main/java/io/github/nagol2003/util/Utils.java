package io.github.nagol2003.util;

import java.io.IOException;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class Utils {
	
	private static MinecraftServer serverCached;

	public static Random getRandom(BlockPos pos) {
		long blockSeed = (((pos.getY() << 28) + pos.getX() + 30000000) << 28) + pos.getZ() + 30000000;
		return new Random(blockSeed);
	}

	/**
	 * Check if this is the client side.
	 *
	 * @return True if and only if we are on the client side
	 */
	public static boolean isClient() {
		return FMLCommonHandler.instance().getSide().isClient();
	}

	/**
	 * Check if this is the server side.
	 *
	 * @return True if and only if we are on the server side
	 */
	public static boolean isServer() {
		return FMLCommonHandler.instance().getSide().isServer();
	}

	/**
	 * Check if this is a deobfuscated (development) environment.
	 *
	 * @return True if and only if we are running in a deobfuscated environment
	 */
	public static boolean isDeobfuscated() {
		try {
			return Launch.classLoader.getClassBytes("net.minecraft.world.World") != null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static MinecraftServer getServer() {
		MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
		if (server == null) {
			return serverCached;
		}
		return server;
	}

	public static Minecraft getClient() {
		return FMLClientHandler.instance().getClient();
	}
}
