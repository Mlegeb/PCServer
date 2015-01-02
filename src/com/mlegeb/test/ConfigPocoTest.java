package com.mlegeb.test;

import org.junit.Test;

import com.mlegeb.config.GameConfigPoco;

public class ConfigPocoTest {

	@Test
	public void savetest() {
		GameConfigPoco gameConfig = new GameConfigPoco();
		gameConfig.setName("haha");
		
		gameConfig.saveConfig();
	}
	
	@Test
	public void getTest(){
		GameConfigPoco gameConfig = new GameConfigPoco();
		gameConfig = gameConfig.getConfig();
		
		System.out.println(gameConfig.getName());
	}
	

}
