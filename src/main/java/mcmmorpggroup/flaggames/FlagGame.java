package mcmmorpggroup.flaggames;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import net.akaishi_teacher.util.lang.Language;
import net.akaishi_teacher.util.lang.LanguageManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class FlagGame extends JavaPlugin {

	/**
	 * 言語管理クラス
	 */
	private LanguageManager langManager;

	public FlagGame() {
		this.langManager =
				new LanguageManager(loadDefaultLocalizationFile());
		loadLangFiles();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		return super.onCommand(sender, command, label, args);
	}

	@Override
	public void onDisable() {
		super.onDisable();
	}

	@Override
	public void onEnable() {
		super.onEnable();
	}

	//Load default lang file.
	private Language loadDefaultLocalizationFile() {
		Language lang =  new Language(new File(getDataFolder().getAbsolutePath() + "/lang"), "default");
		try {
			lang.loadLangFile();
		} catch (IOException | URISyntaxException e) {
			//言語ファイルロード
			try {
				copyDefaultLocalizationFile(lang);
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
		return lang;
	}

	//Copy default lang file.
	private void copyDefaultLocalizationFile(Language lang) throws IOException {
		ClassLoader cl = getClass().getClassLoader();
		InputStream stream = cl.getResourceAsStream("default.txt");
		InputStreamReader isr = new InputStreamReader(stream, "UTF-8");
		lang.copyDefaultLanguage(isr);
		stream.close();
	}

	//Load lang files.
	private void loadLangFiles() {
		File langFolder = new File(getDataFolder().getAbsolutePath() + "/lang");
		File[] langFiles = langFolder.listFiles();
		for (File langFile : langFiles) {
			String langName = LanguageManager.removeFileExtension(langFile.getName());
			Language lang = new Language(langFolder, langName);
			try {
				lang.loadLangFile();
			} catch (IOException | URISyntaxException e) {
				getLogger().severe("Could not be loaded language file because unexpected.");
				onDisable();
				e.printStackTrace();
				return;
			}
			langManager.addLang(lang);
		}
	}

}
