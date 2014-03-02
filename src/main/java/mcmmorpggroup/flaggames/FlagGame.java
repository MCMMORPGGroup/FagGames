package mcmmorpggroup.flaggames;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * FlagGameメインクラス
 * @author kojima1021, misterT2525 and mozipi
 */
public class FlagGame extends JavaPlugin implements Listener{
    //インスタンス
    private static FlagGame instance;
    /**
     * メインクラスを取得します
     * @return instance
     */
    public static FlagGame getInstance(){
        return instance;
    }
    //Plugin開始時
    @Override
    public void onEnable() {
        //リスナー登録
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new message(), this);
        //インスタンス設定
        instance = this;
        //コマンド登録
        getCommand("Killplayer").setExecutor(new Killplayer());
        getCommand("tpall").setExecutor(new TPALL());
        getCommand("heal").setExecutor(new HEAL());
        //初期設定完了
        getLogger().info("[Enable]プラグインを正常に起動しました。");
    }
    //Pluginun終了時
    @Override
    public void onDisable() {
        getLogger().info("[Disable]プラグインを正常に終了しました。");
    }
    //プレーヤーJoin時(PlayerJoinEvent)
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().setGameMode(GameMode.ADVENTURE);
    }
}