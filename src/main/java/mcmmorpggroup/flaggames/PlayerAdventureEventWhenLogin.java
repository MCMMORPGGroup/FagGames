package mcmmorpggroup.flaggames;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerAdventureEventWhenLogin implements Listener {

	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().setGameMode(GameMode.ADVENTURE);
    }

}
