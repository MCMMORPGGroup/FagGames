package mcmmorpggroup.flaggames;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * 各メッセージを変更するクラス
 * @author kojima1021 and misterT2525
 */
public class message implements Listener {

    @EventHandler
    public void onPlayrrJoin(PlayerJoinEvent event2) {
        // サーバー参加メッセージを設定する。
        String message;
        if ( event2.getPlayer().hasPlayedBefore() ) {
            message = ChatColor.AQUA + "[FlagGames]"
                + ChatColor.GOLD + event2.getPlayer().getName()
                + ChatColor.AQUA + "さんがサーバーに参加しました。";
        } else {
            message = ChatColor.AQUA + "[FlagGames]"
                + ChatColor.GOLD + event2.getPlayer().getName()
                + ChatColor.AQUA + "さんがサーバーに参加しました。";
        }
        event2.setJoinMessage(message);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        // サーバー退出メッセージを設定する。
        String message = ChatColor.AQUA + "[FlagGames]"
            + ChatColor.GOLD + event.getPlayer().getName()
            + ChatColor.AQUA + "さんがサーバーから退出しました。";
        event.setQuitMessage(message);
    }
    @EventHandler
    public void onPlayerKick(PlayerKickEvent event1) {
        // Kick時の表示メッセージを設定する
        String message = ChatColor.AQUA + "[FlagGames]"
            + ChatColor.GOLD + event1.getPlayer().getName()
            + ChatColor.AQUA + "さんが"
            + ChatColor.AQUA + "Kickされました。" + "(" + event1.getReason() +")";
        event1.setLeaveMessage(message);
    }
}