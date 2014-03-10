package net.mcmmorpg_server.flaggames;

import net.mcmmorpg_server.flaggames.Utils.Enum.LanguageType;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commander implements CommandExecutor {

	FlagGames plugin;

	public Commander (FlagGames plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("flaggames")) {

		}
		if (label.equalsIgnoreCase("slay")) {
			if(args.length == 0){
				if(!(sender instanceof Player) ||
						plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.US){
					String message = plugin.getlang_US().getString("Slay_Cmd_Help");
					sender.sendMessage(message);
				}else if(plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.JP){
					String message = plugin.getlang_JP().getString("Slay_Cmd_Help");
					sender.sendMessage(message);
				}
			}else if(args.length == 1){
				Player slayer = Bukkit.getPlayer(args[0]);
				if(slayer !=null){
					slayer.setHealth(0);
					if(!(sender instanceof Player) ||
							plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.US){
						String message = plugin.getlang_US().getString("Slay_Cmd_Success");
						message = plugin.getLanguage().getReplaceText(message);
						message = plugin.getLanguage().getReplacePlayer(slayer, message);
						sender.sendMessage(message);
					}else if(plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.JP){
						String message = plugin.getlang_JP().getString("Slay_Cmd_Success");
						message = plugin.getLanguage().getReplaceText(message);
						message = plugin.getLanguage().getReplacePlayer(slayer, message);
						sender.sendMessage(message);
					}
				}else{
					if(!(sender instanceof Player) ||
							plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.US){
						String message = plugin.getlang_US().getString("PlayerNotFoundMessage");
						sender.sendMessage(message);
					}else if(plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.JP){
						String message = plugin.getlang_JP().getString("PlayerNotFoundMessage");
						sender.sendMessage(message);
					}
				}
			}else{
				if(!(sender instanceof Player) ||
						plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.US){
					String message = plugin.getlang_US().getString("CommandError");
					sender.sendMessage(message);
				}else if(plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.JP){
					String message = plugin.getlang_JP().getString("CommandError");
					sender.sendMessage(message);
				}
			}
		}
		if (label.equalsIgnoreCase("alltp")) {
			if(args.length == 0){
				if(!(sender instanceof Player) ||
						plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.US){
					String message = plugin.getlang_US().getString("Alltp_Cmd_Help");
					sender.sendMessage(message);
				}else if(plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.JP){
					String message = plugin.getlang_JP().getString("Alltp_Cmd_Help");
					sender.sendMessage(message);
				}
			}else if(args.length == 1){
				Player teleporter = Bukkit.getPlayer(args[0]);
				if(teleporter !=null){
					for(Player online: Bukkit.getOnlinePlayers()){
						online.teleport(teleporter);
					}
					if(!(sender instanceof Player) ||
							plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.US){
						String message = plugin.getlang_US().getString("Alltp_Cmd_Success");
						message = plugin.getLanguage().getReplaceText(message);
						message = plugin.getLanguage().getReplacePlayer(teleporter, message);
						sender.sendMessage(message);
					}else if(plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.JP){
						String message = plugin.getlang_JP().getString("Alltp_Cmd_Success");
						message = plugin.getLanguage().getReplaceText(message);
						message = plugin.getLanguage().getReplacePlayer(teleporter, message);
						sender.sendMessage(message);
					}
				}else{
					if(!(sender instanceof Player) ||
							plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.US){
						String message = plugin.getlang_US().getString("PlayerNotFoundMessage");
						sender.sendMessage(message);
					}else if(plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.JP){
						String message = plugin.getlang_JP().getString("PlayerNotFoundMessage");
						sender.sendMessage(message);
					}
				}
			}else{
				if(!(sender instanceof Player) ||
						plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.US){
					String message = plugin.getlang_US().getString("CommandError");
					sender.sendMessage(message);
				}else if(plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.JP){
					String message = plugin.getlang_JP().getString("CommandError");
					sender.sendMessage(message);
				}
			}
		}
		if (label.equalsIgnoreCase("heal")) {
			if(args.length == 0){
				if(!(sender instanceof Player) ||
						plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.US){
					String message = plugin.getlang_US().getString("Heal_Cmd_Help");
					sender.sendMessage(message);
				}else if(plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.JP){
					String message = plugin.getlang_JP().getString("Heal_Cmd_Help");
					sender.sendMessage(message);
				}
			}else if(args.length == 1){
				Player healer = Bukkit.getPlayer(args[0]);
				if(healer !=null){
					healer.setHealth(healer.getMaxHealth());
	                healer.setFoodLevel(20);
					if(!(sender instanceof Player) ||
							plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.US){
						String message = plugin.getlang_US().getString("Heal_Cmd_Success");
						message = plugin.getLanguage().getReplaceText(message);
						message = plugin.getLanguage().getReplacePlayer(healer, message);
						sender.sendMessage(message);
					}else if(plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.JP){
						String message = plugin.getlang_JP().getString("Heal_Cmd_Success");
						message = plugin.getLanguage().getReplaceText(message);
						message = plugin.getLanguage().getReplacePlayer(healer, message);
						sender.sendMessage(message);
					}
				}else{
					if(!(sender instanceof Player) ||
							plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.US){
						String message = plugin.getlang_US().getString("PlayerNotFoundMessage");
						sender.sendMessage(message);
					}else if(plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.JP){
						String message = plugin.getlang_JP().getString("PlayerNotFoundMessage");
						sender.sendMessage(message);
					}
				}
			}else{
				if(!(sender instanceof Player) ||
						plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.US){
					String message = plugin.getlang_US().getString("CommandError");
					sender.sendMessage(message);
				}else if(plugin.getLanguage().getPlayerLang((Player)sender) == LanguageType.JP){
					String message = plugin.getlang_JP().getString("CommandError");
					sender.sendMessage(message);
				}
			}
		}
		return true;
	}
}
