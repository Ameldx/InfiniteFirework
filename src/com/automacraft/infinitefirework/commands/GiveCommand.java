package com.automacraft.infinitefirework.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.automacraft.infinitefirework.InfiniteFireworkMain;

public class GiveCommand {

	public static boolean executeCommand(CommandSender sender, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}

		Player player = (Player) sender;

		if (sender.isOp() || sender.hasPermission("infinitefirework.give")) {
			ItemStack item = new ItemStack(Material.FIREWORK_ROCKET, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(InfiniteFireworkMain.itemName);
			ArrayList<String> loreList = new ArrayList<String>();
			loreList.add("§3§l-----------------------------");
			loreList.add("§3An unlimited firework for elytra boosting");
			loreList.add("§3§l-----------------------------");
			meta.setLore(loreList);
			item.setItemMeta(meta);
			if(args.length > 1) {
				if(sender.hasPermission("infinitefirework.give.others") || sender.isOp()) {
				Player otherPlayer = Bukkit.getPlayer(args[1]);
				if(otherPlayer == null) {
					sender.sendMessage(InfiniteFireworkCommands.notAPlayer);
					return false;
				}
				otherPlayer.getInventory().addItem(item);
				}else {
					sender.sendMessage("§cYou don't have permission to give that to others!");
				}
			}else {
				player.getInventory().addItem(item);
			}
			return true;
		}
		sender.sendMessage(InfiniteFireworkCommands.noPermission);
		return false;
	}

}
