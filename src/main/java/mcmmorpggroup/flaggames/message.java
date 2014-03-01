package mcmmorpggroup.flaggames;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class message implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {

	    // サーバー参加メッセージを設定する。
	    // ただし、初参加プレイヤーなら、初参加メッセージを設定する。
	    String message;
	    if ( event.getPlayer().hasPlayedBefore() ) {
	        message = ChatColor.AQUA + "[FlagGames]"
	                + ChatColor.GOLD + "event.getPlayer().getName()"
	                + ChatColor.AQUA + "さんがサーバーに参加しました。";
	    } else {
	        message = ChatColor.AQUA + "[FlagGames]"
	                + ChatColor.GOLD + "event.getPlayer().getName()"
	                + ChatColor.AQUA + "さんがサーバーに参加しました。";
	    }
	    event.setJoinMessage(message);
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {

	    // サーバー退出メッセージを設定する。
	    String message = ChatColor.AQUA + "[FlagGames]"
                + ChatColor.GOLD + "event.getPlayer().getName()"
	            + ChatColor.AQUA + "さんがサーバーから退出しました。";
	    event.setQuitMessage(message);
	}
}
