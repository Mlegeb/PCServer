package com.mlegeb.state;

/**
 * 名称: AppState.java
 * 描述: 状态基类
 *
 * @author a_xiang
 * @version v1.0
 * @created 2015年1月21日
 */
public abstract class AppState {
	/**
	 * 处理数据
	 * @param data 数据 
	 */
	public abstract void AcceptData(String data);
}
