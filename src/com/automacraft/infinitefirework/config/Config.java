package com.automacraft.infinitefirework.config;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {

	private static File file;
	private static FileConfiguration messageFile;

	public static void initialize() {
		file = new File("plugins/InfiniteFirework/config.yml");
		messageFile = YamlConfiguration.loadConfiguration(file);
	}


	public static String getConfigMessage(String name) {
		String message = messageFile.getString(name);
		if (message == null) {
			return null;
		}
		message = message.replace("&", "§");
		return message;
	}
	
	public static boolean getBoolean(String name) {
		return messageFile.getBoolean(name);
	}
	
	public static double getDouble(String name) {
		return messageFile.getDouble(name);
	}

}
