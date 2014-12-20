package com.mlegeb.state;

import com.mlegeb.core.Massager;

/**
 * 操作状态父类
 * @author Mine
 */
public abstract class ControlState extends AppState{

	public Massager massager;
	
	public ControlState(){
		massager = Massager.Instance();
	}
}
