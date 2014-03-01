package mcmmorpggroup.flaggames;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPALL implements CommandExecutor {

		public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
			if(l.equalsIgnoreCase("tpall")) {
				if(!(s instanceof Player)) return false;
				if(!(s.hasPermission("FlagGame.admin.tpall"))) {
					return true;
				}
				for(Player p : Bukkit.getServer().getOnlinePlayers()) {
					p.teleport(((Player) s).getLocation());
				}
			}
			return true;
		}

	}
