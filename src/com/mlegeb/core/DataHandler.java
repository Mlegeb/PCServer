package com.mlegeb.core;

import com.mlegeb.frame.IndexFrame;


/**
 * 数据控制器-负责数据分发
 * @author Mine
 */
public class DataHandler{

	private IndexFrame indexPanel;
	
	public DataHandler(IndexFrame indexPanel){
		this.indexPanel = indexPanel;
	}
	
	public void procesData(String e){
		this.indexPanel.stateField.setText("e");
	}

}
