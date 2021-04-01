package com.automacraft.infinitefirework.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class InfiniteFireworkCommands implements CommandExecutor {

	protected static String lineSpacer = "§b§l----------------------------------";
	protected static String noPermission = "§cYou do not have permission to do that!";
	protected static String notAPlayer = "§cThat player is not online!";

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("infinitefirework") || label.equalsIgnoreCase("if")) {

			if (args.length == 0) {
				if (sender.isOp() || sender.hasPermission("infinitefirework.help")) {
					String[] response = { lineSpacer, "§bPlugin Developed By Ameldx.",
							"§bType /infinitefirework help for more info!", lineSpacer };
					sender.sendMessage(response);
				} else {
					sender.sendMessage(noPermission);
				}
				return false;
			} else {
				switch (args[0]) {
				case "help":
					HelpCommand.executeCommand(sender);
					break;
				case "give":
					GiveCommand.executeCommand(sender, args);
					break;
				default:
					if (sender.isOp() || sender.hasPermission("infinitefirework.help")) {
						sender.sendMessage(new String[] { lineSpacer,
								"§bUnknown Command. Type §3§l/infinitefirework help§b!", lineSpacer });
					} else {
						sender.sendMessage(noPermission);
					}
					break;
				}
			}
		}
		return false;
	}

}
