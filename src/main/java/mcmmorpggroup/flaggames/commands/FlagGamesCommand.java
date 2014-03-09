package mcmmorpggroup.flaggames.commands;

import mcmmorpggroup.flaggames.FlagGame;
import net.akaishi_teacher.util.command.AbstractCommand;

public abstract class FlagGamesCommand extends AbstractCommand {

	protected FlagGame plugin;

	public FlagGamesCommand(FlagGame flaggame, String pattern, String permission,
			String description) {
		super(pattern, permission, description);
		this.plugin = flaggame;
	}

}
