package com.automacraft.infinitefirework.events;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.automacraft.infinitefirework.InfiniteFireworkMain;
import com.automacraft.infinitefirework.util.DelayTracker;

public class PlayerInteract implements Listener {

	@EventHandler
	public void inventoryClick(PlayerInteractEvent event) {
		if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if (event.hasItem()) {
				ItemStack item = event.getItem();

				if (isInfiniteFirework(item)) {
					if (event.getPlayer().isGliding() && !event.hasBlock()) {
						if (item.getAmount() == 1) {
							if (DelayTracker.tryUse(event.getPlayer())) { // All conditions met, activate firework
								if (event.getPlayer().getGameMode() != GameMode.CREATIVE) {
									item.setAmount(2);
								}
							} else {
								if (DelayTracker.notifyOfRecharge) {
									event.getPlayer().sendMessage("§cThat item is still recharging!");
								}
								event.setCancelled(true);
							}
						} else {
							event.getPlayer().sendMessage("§cYou can not use more than one infinite firework at once!");
							event.setCancelled(true);
						}
					} else {
						event.setCancelled(true);
					}
				}
			}

		}
	}

	private boolean isInfiniteFirework(ItemStack item) {
		if (item != null) {
			ItemMeta meta = item.getItemMeta();
			if (meta != null) {
				if (meta.getDisplayName().equals(InfiniteFireworkMain.itemName)) {
					return true;
				}
			}
		}
		return false;
	}

}
