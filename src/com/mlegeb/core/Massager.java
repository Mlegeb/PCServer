package com.mlegeb.core;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;


/**
 * 名称: Massager.java
 * 描述: 数据处理者
 *
 * @author a_xiang
 * @version v1.0
 * @created 2015年1月20日
 */
public class Massager {
	/** 单例模式  */
	private static Massager massager;
	
	/** 键盘控制 */
	private static Robot robot;

	/**
	 * 构造函数 初始化变量
	 */
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
	 * 按下key
	 * @param keycode
	 */
	public void keyDown(int key){
		robot.keyPress(key);
	}

	/**
	 * 释放key
	 * @param keycode
	 */
	public void keyUp(int key){
		robot.keyRelease(key);
	}

	/**
	 * 按下和释放key
	 * @param keycode
	 */
	public void keyDownAndUp(int key){
		robot.keyPress(key);
		robot.keyRelease(key);
	}

	/**
	 * ALT+按下释放key
	 * @param key
	 */
	public void keyWithAlt(int key){
		robot.keyPress(KeyEvent.VK_ALT);
		keyDownAndUp(key);
		robot.keyRelease(KeyEvent.VK_ALT);
	}

	/**
	 * ALT+CTRL+按下释放key
	 * @param key
	 */
	public void keyWithAlt_Ctrl(int key){
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ALT);
		keyDownAndUp(key);
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	/**
	 * 窗口切换
	 * @param data
	 */
	public void winChange(int data){
	
		
		if(winThread == null){
			//第一次启动线程
			winThread = new Thread(new my());
			winThread.start();
		}
		else{
			if(winThread.isAlive()){
				//如果线程还未结束-结束线程并启动新线程
				winThread.interrupt();
				winThread = new Thread(new my());
				winThread.start();
				//操作滚轮
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
	 * 名称: Massager.java
	 * 描述: 窗口切换线程
	 *
	 * @author a_xiang
	 * @version v1.0
	 * @created 2015年1月20日
	 */
	class my implements Runnable{
		@Override
		public void run() {
			robot.keyPress(KeyEvent.VK_WINDOWS);
			keyDownAndUp(KeyEvent.VK_TAB);
			try {
				//1200毫秒无操作自动选择当前窗口
				Thread.sleep(1200);
				robot.keyRelease(KeyEvent.VK_WINDOWS);
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
		}
	}
	/** 窗口线程 */
	private Thread winThread = null;
	
	/**
	 * 鼠标移动
	 * @param x x轴移动量
	 * @param y y轴移动量
	 */
	public void mouseMove(float x, float y){
		PointerInfo pinfo = MouseInfo.getPointerInfo();
		Point p = pinfo.getLocation();
		double mouseX = p.getX();
		double mouseY = p.getY();
		
		robot.mouseMove((int)mouseX + (int)x, (int)mouseY + (int)y);
	}

	/**
	 * 鼠标按键按下
	 * @param key
	 */
	public void mouseButtonDown(int key){
		robot.mousePress(key);
	}
	
	/**
	 * 鼠标按键释放
	 * @param key
	 */
	public void mouseButtonUp(int key){
		robot.mouseRelease(key);
	}
	
	/**
	 * 鼠标按键按下+释放
	 * @param key
	 */
	public void mouseButtonDownAndUp(int key){
		robot.mousePress(key);
		robot.mouseRelease(key);
	}

	/**
	 * 关机操作 30秒后
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
	 * @param command 命令
	 */
	public void cmdCommand(String command){
		try{
			Runtime.getRuntime().exec(command);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
