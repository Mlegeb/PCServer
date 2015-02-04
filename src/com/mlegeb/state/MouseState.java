package com.mlegeb.state;

import java.awt.event.InputEvent;

/**
 * 名称: MouseState.java
 * 描述: 鼠标模式
 *
 * @author a_xiang
 * @version v1.0
 * @created 2015年2月4日
 */
public class MouseState extends ControlState{

	/**
	 * 消息分类
	 */
	@Override
	public void AcceptData(String data) {
		String type = data.substring(0, 1);
		//		System.out.println("--->" + type);
		switch (type) {
		case "0":
			mouseMove(data.substring(1));
			break;
		case "1":
			leftButtonDownAndUp();
			break;
		case "2":
			leftButtonDown();
			break;
		case "3":
			leftButtonUp();
			break;
		case "4":
			rightButton();
			break;
		}
	}

	/**
	 * 鼠标移动
	 * @param data
	 */
	private void mouseMove(String data){
		String point[] = data.split(",");
		float moveX = Float.valueOf(point[0]);
		float moveY = Float.valueOf(point[1]);
		//		System.out.println("--->" + moveX + "," + moveY);
		massager.mouseMove(moveX, moveY);
	}

	/**
	 * 点击并松开左键
	 */
	private void leftButtonDownAndUp(){
		massager.mouseButtonDownAndUp(InputEvent.BUTTON1_MASK);
	}

	/**
	 * 点击左键
	 */
	private void leftButtonDown(){
		massager.mouseButtonDown(InputEvent.BUTTON1_MASK);
	}

	/**
	 * 松开左键
	 */
	private void leftButtonUp(){
		massager.mouseButtonUp(InputEvent.BUTTON1_MASK);
	}
	
	/**
	 * 点击并松开右键
	 */
	private void rightButton(){
		massager.mouseButtonDownAndUp(InputEvent.BUTTON3_MASK);
	}
}
