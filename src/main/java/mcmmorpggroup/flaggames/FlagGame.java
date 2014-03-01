package mcmmorpggroup.flaggames;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author kojima1021, misterT and mozipi
 */
public class FlagGame extends JavaPlugin implements Listener{
	private static FlagGame instance;
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
		getCommand("Killplayer").setExecutor(new Killplayer());
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new Killplayer(), this);
		getServer().getPluginManager().registerEvents(new message(), this);
	}

	//Pluginun終了時
	@Override
	public void onDisable() {
	    getLogger().info("[Disable]FlagGames");
	}
	//プレーヤーJoin時(PlayerJoinEvent)
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
        	e.getPlayer().setGameMode(GameMode.ADVENTURE);
        }
	}