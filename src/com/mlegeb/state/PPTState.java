package com.mlegeb.state;

import java.awt.event.KeyEvent;


/**
 * 名称: MouseState.java
 * 描述: PPT模式
 *
 * @author a_xiang
 * @version v1.0
 * @created 2015年2月4日
 */
public class PPTState extends ControlState{

	private static final String PAGE_UP   = "0";//上一页
	private static final String PAGE_DOWN = "1";//下一页
	private static final String PLAY      = "2";//播放
	private static final String EXIT      = "3";//退出
	private static final String CLOSE     = "4";//关闭
	private static final String MODEL_N   = "5";//普通模式
	private static final String MODEL_S   = "6";//预览模式
	
	@Override
	public void AcceptData(String data) {
		switch (data) {
		case PAGE_UP:
			massager.keyDownAndUp(KeyEvent.VK_PAGE_UP);
			break;
		case PAGE_DOWN:
			massager.keyDownAndUp(KeyEvent.VK_PAGE_DOWN);
			break;
		case PLAY:
			massager.keyDownAndUp(KeyEvent.VK_F5);
			break;
		case EXIT:
			massager.keyDownAndUp(KeyEvent.VK_ESCAPE);
			break;
		case CLOSE:
			massager.keyWithAlt(KeyEvent.VK_F4);
			break;
		case MODEL_N:
			massager.keyWithAlt(KeyEvent.VK_V);
			massager.keyDownAndUp(KeyEvent.VK_N);
			break;
		case MODEL_S:
			massager.keyWithAlt(KeyEvent.VK_V);
			massager.keyDownAndUp(KeyEvent.VK_S);
			break;

		}
	}

}
