package com.mlegeb.state;

/**
 * 关机状态
 * @author Mine
 *
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
		}
	}

}
