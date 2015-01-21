package com.mlegeb.config;

/**
 * 名称: GameConfigPoco.java
 * 描述: 游戏配置信息类
 *
 * @author a_xiang
 * @version v1.0
 * @created 2015年1月20日
 */
public class GameConfigPoco extends ConfigPoco {

	private static final long serialVersionUID = 1L;
	
	/** 保存的文件名 */
	private final String FILENAME = "GameConfig.txt";
	
	/** 设置对应的键字符串 */
	public String up,down,left,right,A,B,C,D,XX,YY;
	
	/** 对应的KeyCode值 */
	public int i_up, i_down, i_left, i_right, i_A, i_B, i_C, i_D, i_XX, i_YY;
	
	/**
	 *保存配置信息
	 */
	public void saveConfig(){
		saveConfig(FILENAME);
	}
	
	
	/**
	 * 读取配置信息
	 * @return
	 */
	public GameConfigPoco getConfig(){
		return (GameConfigPoco) getConfig(FILENAME);
	}


}
