package net.mcmmorpg_server.flaggames.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.mcmmorpg_server.flaggames.FlagGames;
import net.mcmmorpg_server.flaggames.Utils.Enum.LanguageType;

public class ServerMessageChangeListener implements Listener {

	FlagGames plugin;

	public ServerMessageChangeListener (FlagGames plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String message = null;
		if (p.hasPlayedBefore()){
			if(plugin.getLanguage().getPlayerLang(p) == LanguageType.JP){
				message = plugin.getlang_JP().getString("JoinMessage");
				message = plugin.getLanguage().getReplaceText(message);
				message = plugin.getLanguage().getReplacePlayer(p, message);
			}else if(plugin.getLanguage().getPlayerLang(p) == LanguageType.US){
				message = plugin.getlang_US().getString("JoinMessage");
				message = plugin.getLanguage().getReplaceText(message);
				message = plugin.getLanguage().getReplacePlayer(p, message);
			}
		} else {
			if(plugin.getLanguage().getPlayerLang(p) == LanguageType.JP){
				message = plugin.getlang_JP().getString("FirstJoinMessage");
				message = plugin.getLanguage().getReplaceText(message);
				message = plugin.getLanguage().getReplacePlayer(p, message);
			}else if(plugin.getLanguage().getPlayerLang(p) == LanguageType.US){
				message = plugin.getlang_US().getString("FirstJoinMessage");
				message = plugin.getLanguage().getReplaceText(message);
				message = plugin.getLanguage().getReplacePlayer(p, message);
			}
		}
		e.setJoinMessage(message);
    }

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		String message = plugin.getlang_JP().getString("QuitMessage");
		message = plugin.getLanguage().getReplaceText(message);
		message = plugin.getLanguage().getReplacePlayer(p, message);
		e.setQuitMessage(message);
	}

	@EventHandler
	public void onPlayerKick(PlayerKickEvent e) {
		Player p = e.getPlayer();
		String message = null;
		if(plugin.getLanguage().getPlayerLang(p) == LanguageType.JP){
			message = plugin.getlang_JP().getString("KickMessage");
			message = plugin.getLanguage().getReplaceText(message);
			message = plugin.getLanguage().getReplacePlayer(p, message);
			message = message.replace("$Reason", e.getReason());
			message = plugin.getLanguage().getReplacePlayer(p, message);
		}else if(plugin.getLanguage().getPlayerLang(p) == LanguageType.US){
			message = plugin.getlang_US().getString("KickMessage");
			message = plugin.getLanguage().getReplaceText(message);
			message = plugin.getLanguage().getReplacePlayer(p, message);
			message = message.replace("$Reason", e.getReason());
		}
		e.setLeaveMessage(message);
    }
}
