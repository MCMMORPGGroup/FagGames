package net.mcmmorpg_server.flaggames.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import net.mcmmorpg_server.flaggames.FlagGames;
import net.mcmmorpg_server.flaggames.Utils.Enum.LanguageType;

public class Language {

	FlagGames plugin;

	public Language (FlagGames plugin) {
		this.plugin = plugin;
	}

	/**
	 * プレイヤーの言語をLanguageTypeで返す
	 * @param Player
	 * @return LanguageType
	 */
	public LanguageType getPlayerLang(Player p){
		String lang = plugin.getReflection().getPlayerLanguage(p);
		if(LanguageType.JP.getName().equalsIgnoreCase(lang)){
			return LanguageType.JP;
		}
		return LanguageType.US;
	}

	/**
	 * 言語ファイルの'$Prefix'を置き換えるのとカラーコードの変換
	 * @param String
	 * @return ReplaceString
	 */
	public String getReplaceText(String txt){
		txt = ChatColor.translateAlternateColorCodes('&', txt);
		txt = txt.replace("$Prefix", plugin.getPrefix());
		return txt;
	}

	/**
	 * '$Player'を名前に変換
	 * @param p
	 * @param String
	 * @return ReplaceString
	 */
	public String getReplacePlayer(Player p, String txt){
		txt = txt.replace("$Player", p.getDisplayName());
		return txt;
	}
}
