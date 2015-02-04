package com.mlegeb.state;

/**
 * 名称: MouseState.java
 * 描述: 关机模式
 *
 * @author a_xiang
 * @version v1.0
 * @created 2015年2月4日
 */
public class ShutdownState extends ControlState{

	@Override
	public void AcceptData(String data) {
		switch (data) {
		case "0":
			massager.shutdownPc();
			break;
		case "1":
			massager.sleepPc();
			break;
		default:
			massager.cmdCommand(data);
			break;
		}
	}

}
