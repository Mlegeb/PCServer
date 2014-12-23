package com.mlegeb.udpservice;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;



/**
 * Udp通信管理类
 * @author Mine
 */
public class UdpManager implements Runnable{
	/**
	 * 本机IP地址（获取）
	 */
	private String localhost=null;//本机IP地址（获取）
	
	/**
	 * ClientIP地址（赋值）
	 */
	private String addresssIP=null;//对方IP地址（赋值）
	
	/**
	 * Client接收数据端口（赋值）
	 */
	private int yListenerPort = 7590 ;//Client接收数据端口（赋值）

	/**
	 * 接收数据端口（赋值）
	 */
	private int iListenerPort = 7590;//接收数据端口（赋值）

	/**
	 * 接收数据的对象（接收数据端口）
	 */
	private DatagramSocket in=null;//接收数据的对象（接收数据端口）
	
	/**
	 * 发送数据的对象（我方发送数据端口）
	 */
	private DatagramSocket out=null;//发送数据的对象（我方发送数据端口）


	/**
	 * 构造函数
	 * @param iListenerPort 接收数据端口
	 */
	public UdpManager()
	{
		try 
		{
			this.localhost=InetAddress.getLocalHost().getHostAddress();
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		} 
	}

	private SocketListener handle=null;

	/**
	 * 接收信息事件绑定函数
	 * @param handle 绑定事件处理函数所在对象的地址
	 */
	public void addSocketListener(SocketListener handle)
	{
		this.handle=handle;
	}

	private Thread thread=null;

	/**
	 * 启动监听
	 */
	public void start()
	{
		try 
		{
			this.in=new DatagramSocket(this.iListenerPort);//接收数据的对象
			this.thread=new Thread(this);
			this.thread.start();
		} 
		catch (SocketException e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * 接收信息
	 */
	@Override
	public void run() //接收信息（死循环，自定义线程中运行）
	{
		try
		{
			String str = new String();
			while (true)
			{
				byte[] buf = new byte[1024*16];//发送接收信息的最大值，单位字节（16KB）
				DatagramPacket op = new DatagramPacket(buf,buf.length);//收包
				this.in.receive(op);//接收信息（监听，一直监视端口是否有数据发送过来）
				//获取对方的IP地址
				
				str = op.getAddress().toString();
				str = str.substring(1);
				this.addresssIP = str;
				String msgList = new String(buf).trim();
				this.handle.getSocketMessage(msgList);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	

	/**
	 * 关闭监听
	 */
	@SuppressWarnings("deprecation")
	public void close()
	{
		this.thread.stop();
		this.in.close();
		this.out.close();
	}
	
	
	/**
	 * 发送信息
	 * @param msg 发送的消息
	 */
	public void send(String msg)
	{
		
		this.send(this.addresssIP,msg);
	}
	
	/**
	 * 发送信息
	 * @param addresssIP 接收信息的IP地址
	 * @param msg 发送的消息
	 */
	public void send(String addresssIP,String msg)
	{
		try
		{
			byte[] buf = msg.getBytes();
			DatagramPacket op = 
					new DatagramPacket(buf,buf.length,
							InetAddress.getByName(addresssIP),
							this.yListenerPort);//封包（对方接收数据端口）
			this.out.send(op);//发送信息
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String getAddresssIP() {
		return addresssIP;
	}

	public String getLocalhost() {
		return localhost;
	}

	public void setLocalhost(String localhost) {
		this.localhost = localhost;
	}

	public int getiListenerPort() {
		return iListenerPort;
	}

	public void setiListenerPort(int iListenerPort) {
		this.iListenerPort = iListenerPort;
	}

}
