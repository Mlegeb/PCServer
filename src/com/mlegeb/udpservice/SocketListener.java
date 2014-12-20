package com.mlegeb.udpservice;


/**
 * 监听数据接收接口
 * @author Mine
 */
public interface SocketListener {
	/**
	 * 接收信息事件处理函数
	 * @param e 接收的信息
	 */
	public void getSocketMessage(String e);
}
