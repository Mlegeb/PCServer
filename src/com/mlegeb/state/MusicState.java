package com.mlegeb.state;

import java.awt.event.KeyEvent;

/**
 * 名称: MouseState.java
 * 描述: 播放器模式
 *
 * @author a_xiang
 * @version v1.0
 * @created 2015年2月4日
 */
public class MusicState extends ControlState{

	@Override
	public void AcceptData(String data) {
		switch(data){
		case "0":
			massager.keyWithAlt_Ctrl(KeyEvent.VK_F5);
			break;
		case "1":
			massager.keyWithAlt_Ctrl(KeyEvent.VK_RIGHT);
			break;
		case "2":
			massager.keyWithAlt_Ctrl(KeyEvent.VK_LEFT);
			break;
		case "3":
			massager.keyWithAlt_Ctrl(KeyEvent.VK_UP);
			break;
		case "4":
			massager.keyWithAlt_Ctrl(KeyEvent.VK_DOWN);
			break;
		case "5":
//			未实现
			break;
		}
	}

}
