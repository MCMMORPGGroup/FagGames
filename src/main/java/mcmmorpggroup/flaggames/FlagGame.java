package mcmmorpggroup.flaggames;

import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author kojima1021, misterT and mozipi
 */
public class FlagGame extends JavaPlugin implements Listener{
	private static FlagGame instance;
	private OfflinePlayer event;

	/**
	    @return instance
	*/
	public static FlagGame getInstance(){
	    return instance;
	}

	//Plugin開始時
	@Override
	public void onEnable() {
	    getServer().getPluginManager().registerEvents(this, this);
	    instance = this;
	    getLogger().info("[Enable]FlagGames");
	}

	//Pluginun終了時
	@Override
	public void onDisable() {
	    getLogger().info("[Disable]FlagGames");
	}
	//プレーヤーJoin時(PlayerJoinEvent)
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
        event = null;
        Player player = event.getPlayer();

        if (!player.hasPermission("FlagGame.admin.mode")) {
        	e.getPlayer().setGameMode(GameMode.ADVENTURE);
        }
	}
}