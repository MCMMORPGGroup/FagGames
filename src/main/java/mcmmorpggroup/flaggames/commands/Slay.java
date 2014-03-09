package mcmmorpggroup.flaggames.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mcmmorpggroup.flaggames.FlagGame;
import net.akaishi_teacher.util.lang.Language;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Slay extends FlagGamesCommand {

	public Slay(FlagGame flaggame, String pattern, String permission,
			String description) {
		super(flaggame, pattern, permission, description);
	}

	@Override
	public boolean execute(CommandSender sender, ArrayList<String> args) {
		Player player = plugin.getServer().getPlayer(args.get(1));
		player.setHealth(0);

		Map<String, String> replaceMap = new HashMap<>();
		replaceMap.put("Player", player.getName());
		sender.sendMessage(Language.replaceArgs(plugin.getLang().get("Cmd_Out_Slay_Slay"), replaceMap));

		return true;
	}

	@Override
	public String getUsage(CommandSender sender) {
		return plugin.getLang().get("Cmd_Usage_Slay");
	}

}
