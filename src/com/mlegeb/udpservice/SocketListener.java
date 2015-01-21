package com.mlegeb.udpservice;


/**
 * 名称: SocketListener.java
 * 描述: 监听数据接收接口-实现接口回调
 *
 * @author a_xiang
 * @version v1.0
 * @created 2015年1月21日
 */
public interface SocketListener {
	/**
	 * 接收信息事件处理函数
	 * @param e 接收的信息
	 */
	public void getSocketMessage(String e);
}
