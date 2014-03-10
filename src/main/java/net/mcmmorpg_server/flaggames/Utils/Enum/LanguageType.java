package net.mcmmorpg_server.flaggames.Utils.Enum;

public enum LanguageType {

	JP("ja_JP"),
	US("en_US");

	private String name;

	LanguageType(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}