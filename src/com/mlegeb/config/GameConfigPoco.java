package com.mlegeb.config;


public class GameConfigPoco extends ConfigPoco {

	private static final long serialVersionUID = 1L;
	
	private final String FILENAME = "GameConfig.txt";
	private String name;
	
	public void saveConfig(){
		saveConfig(FILENAME);
	}
	
	public GameConfigPoco getConfig(){
		return (GameConfigPoco) getConfig(FILENAME);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
