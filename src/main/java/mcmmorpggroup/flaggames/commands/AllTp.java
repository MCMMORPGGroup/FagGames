package mcmmorpggroup.flaggames.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mcmmorpggroup.flaggames.FlagGame;
import net.akaishi_teacher.util.lang.Language;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AllTp extends FlagGamesCommand {

	public AllTp(FlagGame flaggame, String pattern, String permission,
			String description) {
		super(flaggame, pattern, permission, description);
	}

	@Override
	public boolean execute(CommandSender sender, ArrayList<String> args) {
		Player toPlayer = null;

		//Get player.
		if (hasOption(args, 1)) {
			if ((toPlayer = Bukkit.getPlayer(args.get(1))) != null) {} else {
				sender.sendMessage(plugin.getLang().get("Err_PlayerNotFound"));
				return true;
			}
		} else {
			if ((toPlayer = castPlayer(sender)) != null);
			else //By console or cmdBlock.
				return true;
		}

		//All teleport.
		Player[] players = plugin.getServer().getOnlinePlayers();
		for (Player player : players) {
			player.teleport(toPlayer);
		}

		Map<String, String> replaceMap = new HashMap<>();
		replaceMap.put("Player", toPlayer.getName());
		sender.sendMessage(Language.replaceArgs(plugin.getLang().get("Cmd_Out_AllTp_Teleport"), replaceMap));

		return true;
	}

	@Override
	public String getUsage(CommandSender sender) {
		return plugin.getLang().get("Cmd_Usage_AllTp");
	}

}
