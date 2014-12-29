package com.mlegeb.state;

import java.awt.event.KeyEvent;


/**
 * PPT状态
 * @author Mine
 *
 */
public class PPTState extends ControlState{

	private static final String PAGE_UP   = "0";
	private static final String PAGE_DOWN = "1";
	private static final String PLAY      = "2";
	private static final String EXIT      = "3";
	private static final String CLOSE     = "4";
	private static final String MODEL_N   = "5";
	private static final String MODEL_S   = "6";
	
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
