package com.mlegeb.state;

import java.awt.event.KeyEvent;


/**
 * 窗口操作状态
 * @author Mine
 *
 */
public class WindowState extends ControlState{

	@Override
	public void AcceptData(String data) {
		switch (data) {
		case "-1":
			massager.winChange(-2);
			break;
		case "1":
			massager.winChange(0);
			break;
		case "2":
			massager.keyDown(KeyEvent.VK_WINDOWS);
			massager.keyDown(KeyEvent.VK_M);
			massager.keyUp(KeyEvent.VK_M );
			massager.keyUp(KeyEvent.VK_WINDOWS);
			break;
			
		case "3":
			massager.keyDown(KeyEvent.VK_WINDOWS);
			massager.keyDown(KeyEvent.VK_DOWN);
			massager.keyUp(KeyEvent.VK_DOWN);
			massager.keyUp(KeyEvent.VK_WINDOWS);
			break;
		case "-3":
			massager.keyDown(KeyEvent.VK_WINDOWS);
			massager.keyDown(KeyEvent.VK_UP);
			massager.keyUp(KeyEvent.VK_UP);
			massager.keyUp(KeyEvent.VK_WINDOWS);
			break;
		case "4":
			massager.keyWithAlt(KeyEvent.VK_F4);
			break;
		case "5":
			massager.keyDown(KeyEvent.VK_WINDOWS);
			massager.keyDown(KeyEvent.VK_E);
			massager.keyUp(KeyEvent.VK_E);
			massager.keyUp(KeyEvent.VK_WINDOWS);
			break;
			

		}
		
	}
	

}
