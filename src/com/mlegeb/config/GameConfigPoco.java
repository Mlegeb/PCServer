package com.mlegeb.config;


public class GameConfigPoco extends ConfigPoco {

	private static final long serialVersionUID = 1L;
	
	private final String FILENAME = "GameConfig.txt";
	public String up,down,left,right,A,B,C,D,XX,YY;
	public int i_up, i_down, i_left, i_right, i_A, i_B, i_C, i_D, i_XX, i_YY;
	
	public void saveConfig(){
		saveConfig(FILENAME);
	}
	
	public GameConfigPoco getConfig(){
		return (GameConfigPoco) getConfig(FILENAME);
	}


}
