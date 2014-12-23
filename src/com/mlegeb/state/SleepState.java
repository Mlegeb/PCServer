package com.mlegeb.state;

import com.mlegeb.core.DataHandler;

/**
 * 休眠状态
 * @author Mine
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
