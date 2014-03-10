package net.mcmmorpg_server.flaggames.Utils.Enum;

public enum VersionType {

	v1_6("v1_6"),
	v1_7("v1_7"),
	UNKNOWN("UNKNOWN");

	private String name;

	VersionType(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}