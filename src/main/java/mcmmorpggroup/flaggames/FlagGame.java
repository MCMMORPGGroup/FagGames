package mcmmorpggroup.flaggames;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import mcmmorpggroup.flaggames.commands.AllTp;
import mcmmorpggroup.flaggames.commands.Heal;
import mcmmorpggroup.flaggames.commands.Help;
import mcmmorpggroup.flaggames.commands.Slay;
import net.akaishi_teacher.util.command.CommandExecutor;
import net.akaishi_teacher.util.lang.Language;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * FlagGameメインクラス
 * @author kojima1021, misterT2525 and mozipi
 */
public final class FlagGame extends JavaPlugin implements Listener {

	/**
	 * Language機能のインスタンス
	 */
	private Language lang;

	/**
	 * 使用する言語
	 */
	private String langName;

	/**
	 * コマンド実行をするクラスのインスタンス
	 */
	private CommandExecutor cmdExecutor;

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		return cmdExecutor.onCommand(sender, args);
	}

    @Override
    public void onEnable() {
    	//Pre init処理
    	preInit();

    	//言語ファイルをロード
    	loadLocalizationFile(langName);

    	//CommandExecutorのインスタンス生成 > 代入
    	cmdExecutor = new CommandExecutor();

    	//コマンド登録
    	registerCommands();

        //リスナー登録
        getServer().getPluginManager().registerEvents(
        		new PlayerAdventureEventWhenLogin(), this);
        getServer().getPluginManager().registerEvents(new message(), this);

        getLogger().info("Plugin Enabled.");
    }



    @Override
    public void onDisable() {
    	//Configセーブ
    	setConfig();

        getLogger().info("Plugin Disabled.");
    }



    /**
     * PreInit処理
     */
    public void preInit() {
    	getConfig().addDefault("lang", "ja_JP");

    	langName = getConfig().getString("lang");
    }



    /**
     * Configセーブ処理
     */
    public void setConfig() {
    	getConfig().set("lang", langName);

    	saveConfig();
    }



    /**
     * コマンドを登録します
     */
    public void registerCommands() {
    	cmdExecutor.addCommand(new Help(this, "", null, "コマンド一覧を表示します"));
    	cmdExecutor.addCommand(new Slay(this, "slay", "flaggame.slay", "指定したプレイヤーを殺します"));
    	cmdExecutor.addCommand(new AllTp(this, "alltp", "flaggame.alltp", "すべてのプレイヤーを指定したプレイヤーにテレポートします"));
    	cmdExecutor.addCommand(new Heal(this, "heal", "flaggame.heal", "指定したプレイヤーを回復します"));
    }



	private void loadLocalizationFile(String langName) {
		lang = new Language(new File(getDataFolder().getAbsolutePath() + "/lang"), langName, getLogger());
		try {
			lang.loadLangFile();
		} catch (IOException | URISyntaxException e) {
			//言語ファイルロード
			try {
				copyDefaultLocalizationFile();
				try {
					lang.loadLangFile();
				} catch (URISyntaxException e1) {
					onDisable();
					e1.printStackTrace();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}



	private void copyDefaultLocalizationFile() throws IOException {
		ClassLoader cl = getClass().getClassLoader();
		InputStream stream = cl.getResourceAsStream("default.txt");
		InputStreamReader isr = new InputStreamReader(stream, "UTF-8");
		lang.copyDefaultLanguage(isr);
		stream.close();
	}



    /**
     * Language機能のインスタンスを返します。
     * @return Languageのインスタンス
     */
    public Language getLang() {
    	return lang;
    }



    /**
     * コマンド実行機能のクラスのインスタンスを返します。
     * @return CommandExecutorのインスタンス
     */
	public CommandExecutor getCmdExecutor() {
		return cmdExecutor;
	}



}