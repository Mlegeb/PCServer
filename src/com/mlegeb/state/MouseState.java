package com.mlegeb.state;

import java.awt.event.InputEvent;

/**
 * 遥感控制状态
 * @author Mine
 */
public class MouseState extends ControlState{

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

	private void mouseMove(String data){
		String point[] = data.split(",");
		float moveX = Float.valueOf(point[0]);
		float moveY = Float.valueOf(point[1]);
		//		System.out.println("--->" + moveX + "," + moveY);
		massager.mouseMove(moveX, moveY);
	}

	private void leftButtonDownAndUp(){
		massager.mouseButtonDownAndUp(InputEvent.BUTTON1_MASK);
	}

	private void leftButtonDown(){
		massager.mouseButtonDown(InputEvent.BUTTON1_MASK);
	}

	private void leftButtonUp(){
		massager.mouseButtonUp(InputEvent.BUTTON1_MASK);
	}
	
	private void rightButton(){
		massager.mouseButtonDownAndUp(InputEvent.BUTTON3_MASK);
	}
}
