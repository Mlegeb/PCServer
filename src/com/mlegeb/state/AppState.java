package com.mlegeb.state;

/**
 * 状态父类
 * @author Mine
 */
public abstract class AppState {
	/**
	 * 处理数据
	 * @param data 数据 
	 */
	public abstract void AcceptData(String data);
}
