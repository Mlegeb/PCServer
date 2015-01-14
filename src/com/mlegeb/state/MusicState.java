package com.mlegeb.state;

import java.awt.event.KeyEvent;

/**
 * 音乐播放器状态
 * @author Mine
 *
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
