package com.automacraft.infinitefirework;

import org.bukkit.plugin.java.JavaPlugin;

import com.automacraft.infinitefirework.commands.InfiniteFireworkCommands;
import com.automacraft.infinitefirework.config.Config;
import com.automacraft.infinitefirework.events.PlayerInteract;
import com.automacraft.infinitefirework.util.DelayTracker;

public class InfiniteFireworkMain extends JavaPlugin {
	
	public static final String itemName = "§5§lInfinite Firework";

	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		
		Config.initialize();
		DelayTracker.initializeTracker();
		
		this.getCommand("infinitefirework").setExecutor(new InfiniteFireworkCommands());
		this.getCommand("if").setExecutor(new InfiniteFireworkCommands());
						
		getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
	}

	@Override
	public void onDisable() {
	}

}
