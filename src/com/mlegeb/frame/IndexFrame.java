package com.mlegeb.frame;


import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mlegeb.udpservice.UdpManager;

/**
 * 名称: IndexFrame.java
 * 描述: 首页
 *
 * @author a_xiang
 * @version v1.0
 * @created 2015年1月21日
 */
public class IndexFrame extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel titleLabel = new JLabel("基于手机APP的\"虚拟主机控制器\"");
	
	private JLabel ipLabel = new JLabel("本机IP:");
	private JLabel localhostText = new JLabel();
	
	private JLabel stateLabel = new JLabel("状态：");
	public JLabel stateText = new JLabel("等待连接");
	
	private JLabel clientIPLabel = new JLabel("手机IP:"); 
	public JLabel clientIPText = new JLabel();
	private UdpManager udpManager;
	
	//标题大小
	private static final int lableSizeX = 45;
	private static final int lableSizeY = 20;
	
	//标题位置
	private static final int lableLocationX = 80;
	private static final int lableLocationY = 100;
	
	//文本大小
	private static final int textSizeX = 200;
	private static final int textSizeY = 20;
	
	//文本位置
	private static final int textLocationX =150;
	private static final int textLocationY = 100;
	
	//相对位置差
	private static final int movePixels = 30;
	
	/**
	 *构造函数初始化
	 * @param udpManager
	 */
	public IndexFrame(UdpManager udpManager){
		this.setLayout(null );
		
		//标题
		this.titleLabel.setFont(new Font("", 1, 15));
		this.titleLabel.setSize(250, 30);
		this.titleLabel.setLocation(45, 30);
		
		//本地IP
		this.ipLabel.setSize(lableSizeX, lableSizeY);
		this.ipLabel.setLocation(lableLocationX, lableLocationY);
		this.localhostText.setSize(textSizeX, textSizeY);
		this.localhostText.setLocation(textLocationX, textLocationY);
		
		//客户端IP
		this.clientIPLabel.setSize(lableSizeX, lableSizeY);
		this.clientIPLabel.setLocation(lableLocationX, lableLocationY+movePixels);
		this.clientIPText.setSize(textSizeX, textSizeY);
		this.clientIPText.setLocation(textLocationX, textLocationY+movePixels);
		
		//状态
		this.stateLabel.setSize(lableSizeX, lableSizeY);
		this.stateLabel.setLocation(lableLocationX, lableLocationY+ 2*movePixels);
		this.stateText.setSize(textSizeX, textSizeY);
		this.stateText.setLocation(textLocationX, textLocationY+ 2*movePixels);
		
		this.udpManager = udpManager;
		
		localhostText.setText(this.udpManager.getLocalhost());
		
		this.add(titleLabel);
		this.add(ipLabel);
		this.add(localhostText);
		this.add(clientIPLabel);
		this.add(clientIPText);
		this.add(stateLabel);
		this.add(stateText);
	}

}
