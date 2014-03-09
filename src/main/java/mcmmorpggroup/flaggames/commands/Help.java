package mcmmorpggroup.flaggames.commands;

import java.util.ArrayList;
import java.util.HashSet;

import mcmmorpggroup.flaggames.FlagGame;
import net.akaishi_teacher.util.command.AbstractCommand;

import org.bukkit.command.CommandSender;

/**
 * コマンド一覧を表示するコマンドです。
 * @author mozipi
 */
public final class Help extends FlagGamesCommand {

	public Help(FlagGame flaggame, String pattern, String permission, String description) {
		super(flaggame, pattern, permission, description);
	}

	@Override
	public boolean execute(CommandSender sender, ArrayList<String> args) {
		HashSet<AbstractCommand> commandSet = plugin.getCmdExecutor().getCommandSet();
		for (AbstractCommand command : commandSet) {
			sender.sendMessage(command.getUsage(sender));
		}
		return true;
	}

	@Override
	public String getUsage(CommandSender sender) {
		return plugin.getLang().get("Cmd_Usage_Help");
	}

}
