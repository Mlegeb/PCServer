package com.mlegeb.core;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

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
    	 robot.keyPress(key);
    	 robot.keyRelease(key);
    	 robot.keyRelease(KeyEvent.VK_ALT);
     }
     
     public void mouseMove(float x, float y){
    	 
     }
     
     public void clickMove(){
    	 
     }
}
