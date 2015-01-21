package com.mlegeb.state;

import com.mlegeb.core.Massager;

/**
 * 名称: ControlState.java
 * 描述: 操控基类
 *
 * @author a_xiang
 * @version v1.0
 * @created 2015年1月21日
 */
public abstract class ControlState extends AppState{

	public Massager massager;
	
	public ControlState(){
		massager = Massager.Instance();
	}
	
}
