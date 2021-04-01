package com.automacraft.infinitefirework.util;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

import com.automacraft.infinitefirework.config.Config;

public class DelayTracker {
	
	public static boolean notifyOfRecharge;
	public static HashMap<UUID, Long> useMap;
	private static int minimumDelay;
	
	public static void initializeTracker() {
		notifyOfRecharge = Config.getBoolean("NotifyOfRecharge");
		int minimumDelayTicks = (int) (Config.getDouble("MinimumDelay")*20);
		minimumDelay = minimumDelayTicks * 50;
		useMap = new HashMap<UUID, Long>();
	}
	
	public static boolean tryUse(Player p) {
		UUID id = p.getUniqueId();
		if(p.hasPermission("infinitefirework.nodelay") || p.isOp()) {
			return true;
		}
		if(!useMap.containsKey(id) || (useMap.get(id) + minimumDelay <= System.currentTimeMillis())) { //If the user hasn't used the item yet or the recharge period has elapsed...
			useMap.put(id, System.currentTimeMillis());
			return true;
		}
		return false;
	}

}
