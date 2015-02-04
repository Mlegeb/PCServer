package com.mlegeb.state;

import com.mlegeb.core.DataHandler;

/**
 * 名称: MouseState.java
 * 描述: 休眠模式
 *
 * @author a_xiang
 * @version v1.0
 * @created 2015年2月4日
 */
public class SleepState extends AppState{

	DataHandler dataHandler;
	
	public SleepState(DataHandler dh){
		dataHandler = dh;
	}
	@Override
	public void AcceptData(String data) {
		if(data.startsWith("state")){
			int type = Integer.parseInt(data.substring(5, 6));
			dataHandler.changeState(type);
		}
	}

}
