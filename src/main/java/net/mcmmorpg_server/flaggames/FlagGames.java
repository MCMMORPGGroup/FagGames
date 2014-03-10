package net.mcmmorpg_server.flaggames;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

import net.mcmmorpg_server.flaggames.Listener.GamePlayerListener;
import net.mcmmorpg_server.flaggames.Listener.ServerMessageChangeListener;
import net.mcmmorpg_server.flaggames.Utils.Language;
import net.mcmmorpg_server.flaggames.Utils.Reflection;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class FlagGames extends JavaPlugin {

	public Logger log;
	public JavaPlugin plugin;

	private File lang_JPFile;
	private File lang_USFile;
	private File ConfigFile;
	private FileConfiguration lang_JP;
	private FileConfiguration lang_US;
	private FileConfiguration Config;

	private String prefix = "§b[FlagGames]§r ";

	private Language Language;
	private Reflection Reflection;

	@Override
	public void onEnable() {

		/**
		 * Config Register
		 */
		lang_JPFile = new File(this.getDataFolder()+"/lang", "ja_JP.yml");
		lang_USFile = new File(this.getDataFolder()+"/lang", "en_US.yml");
		ConfigFile = new File(this.getDataFolder(), "config.yml");

		try {
			CheckData();
		} catch (Exception e) {
			e.printStackTrace();
		}

		lang_JP = new YamlConfiguration();
		lang_US = new YamlConfiguration();
		Config = new YamlConfiguration();

		loadData();

		/**
		 * Register Class
		 */
		Language = new Language(this);
		Reflection = new Reflection(this);

		/**
		 * Register Commands
		 */
		getCommand("flaggames").setExecutor(new Commander(this));
		getCommand("slay").setExecutor(new Commander(this));
		getCommand("alltp").setExecutor(new Commander(this));
		getCommand("heal").setExecutor(new Commander(this));

		/**
		 * Register Event Listener
		 */
		new GamePlayerListener(this);
		new ServerMessageChangeListener(this);
	}

	@Override
	public void onDisable(){

	}

	/**
	 * Get Prefix
	 */
	public String getPrefix(){
		return prefix;
	}

	/**
	 * Get Class
	 */
	public Language getLanguage(){
		return Language;
	}
	public Reflection getReflection(){
		return Reflection;
	}

	/**
	 * Get FileConfiguration
	 */
	public FileConfiguration getlang_JP() {
		return lang_JP;
	}
	public FileConfiguration getlang_US() {
		return lang_US;
	}
	public FileConfiguration getFlagGameConfig() {
		return Config;
	}

	/**
	 * Check Config
	 */
	private void CheckData() throws Exception {
		if(!this.getDataFolder().exists()){
			this.getDataFolder().mkdirs();
		}
		if(!lang_JPFile.exists()){
			copy(getResource("ja_JP.yml"), lang_JPFile);
		}
		if(!lang_USFile.exists()){
			copy(getResource("en_US.yml"), lang_USFile);
		}
		if(!ConfigFile.exists()){
			copy(getResource("config.yml"), ConfigFile);
		}
    }

	/**
	 * Config Copy
	 * @param InputStream
	 * @param File
	 */
	private void copy(InputStream in, File file) {
		try {
			OutputStream out = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int len;
			while((len=in.read(buf))>0){
				out.write(buf,0,len);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Save Config
	 */
	public void saveData() {
		try {
			lang_JP.save(lang_JPFile);
			lang_US.save(lang_USFile);
			Config.save(ConfigFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Load Config
	 */
	public void loadData() {
		try {
			lang_JP.load(lang_JPFile);
			lang_US.load(lang_USFile);
			Config.load(ConfigFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
