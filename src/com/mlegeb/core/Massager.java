package com.mlegeb.core;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
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

	public void winChange(int data){
	
		if(winThread == null){
			winThread = new Thread(new my());
			winThread.start();
		}
		else{
			if(winThread.isAlive()){
				winThread.interrupt();
				winThread = new Thread(new my());
				winThread.start();
				robot.mouseWheel(data);
			}
			else{
				winThread = new Thread(new my());
				winThread.start();
				robot.mouseWheel(data);
			}
		}
		
	}
	/**
	 * 窗口切换线程
	 * @author Xiang_Zi
	 *
	 */
	class my implements Runnable{
		@Override
		public void run() {
			robot.keyPress(KeyEvent.VK_WINDOWS);
			keyDownAndUp(KeyEvent.VK_TAB);
			try {
				Thread.sleep(1200);
				robot.keyRelease(KeyEvent.VK_WINDOWS);
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
		}
	}
	private Thread winThread = null;
	

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
