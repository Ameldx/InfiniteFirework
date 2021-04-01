package com.automacraft.infinitefirework.commands;

import org.bukkit.command.CommandSender;

public class HelpCommand {

	public static boolean executeCommand(CommandSender sender) {

		if (sender.isOp() || sender.hasPermission("infinitefirework.help")) {
			sender.sendMessage(new String[] { InfiniteFireworkCommands.lineSpacer, "§InfiniteFirework Commands:",
					"§9§lGive: §bGive yourself an infinite firework",
					"§9§lHelp: §bDisplay this help menu", InfiniteFireworkCommands.lineSpacer });
			return true;
		} else {
			sender.sendMessage(InfiniteFireworkCommands.noPermission);
		}
		return false;
	}

}
