package net.mcmmorpg_server.flaggames.Listener;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.mcmmorpg_server.flaggames.FlagGames;

public class GamePlayerListener implements Listener {

	FlagGames plugin;

	public GamePlayerListener (FlagGames plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		e.getPlayer().setGameMode(GameMode.ADVENTURE);
	}
}
