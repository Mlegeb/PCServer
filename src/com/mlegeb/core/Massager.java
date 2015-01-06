package com.mlegeb.core;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 数据处理者
 * @author Mine
 */
public class Massager {
	private static Massager massager;
	private static Robot robot;

	private Massager() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			System.out.println("无法获取键盘");
			e.printStackTrace();
		}
	}

	/**
	 * 单例模式
	 * @return
	 */
	public static Massager Instance() {
		if (massager == null)
			return new Massager();
		return massager;
	}

	/**
	 * 按下
	 * @param key 按键值
	 */
	public void keyDown(int key){
		robot.keyPress(key);
	}

	public void keyUp(int key){
		robot.keyRelease(key);
	}

	public void keyDownAndUp(int key){
		robot.keyPress(key);
		robot.keyRelease(key);
	}

	public void keyWithAlt(int key){
		robot.keyPress(KeyEvent.VK_ALT);
		keyDownAndUp(key);
		robot.keyRelease(KeyEvent.VK_ALT);
	}

	public void keyWithAlt_Ctrl(int key){
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ALT);
		keyDownAndUp(key);
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	final Timer timer = new Timer();
	private static boolean is = true;
	public void winChange(int data){
		if(is){
			robot.keyPress(KeyEvent.VK_ALT);
			keyDownAndUp(KeyEvent.VK_TAB);	
			is = false;
		}
		keyDownAndUp(KeyEvent.VK_UP);

		TimerTask tt=new TimerTask() { 
			@Override
			public void run() {
				System.out.println("到点啦！");
				is = true;
				timer.cancel();
			}
		};
		timer.schedule(tt, 3000);
	}

	public void mouseMove(float x, float y){
	}

	public void clickMove(){

	}

	/**
	 * 关机操作
	 */
	public void shutdownPc(){

		String command = "cmd /c Shutdown -s -t 30";
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 休眠pc
	 */
	public void sleepPc(){
		String command = "Shutdown /h";
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 执行cmd命令
	 */
	public void cmdCommand(String command){
		try{
			Runtime.getRuntime().exec(command);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
