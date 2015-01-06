package com.mlegeb.frame;


import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mlegeb.udpservice.UdpManager;

/**
 * 配置设置界面
 * @author Mine
 *
 */
public class IndexFrame extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel ipLabel = new JLabel("本机IP:");
	private JLabel localhostText = new JLabel();
	
	private JLabel stateLabel = new JLabel("状态：");
	public JLabel stateText = new JLabel("等待连接");
	
	private JLabel clientIPLabel = new JLabel("手机IP:"); 
	public JLabel clientIPText = new JLabel();
	private UdpManager udpManager;
	
	/**
	 *构造函数初始化
	 * @param udpManager
	 */
	public IndexFrame(UdpManager udpManager){
		this.setLayout(null );
		
		//本地ip
		this.ipLabel.setSize(45, 20);
		this.ipLabel.setLocation(20, 15);
		this.localhostText.setSize(200, 20);
		this.localhostText.setLocation(65, 15);
		
		//客户端IP
		this.clientIPLabel.setSize(45, 20);
		this.clientIPLabel.setLocation(160, 15);
		this.clientIPText.setSize(200, 20);
		this.clientIPText.setLocation(205, 15);
		
		//状态
		this.stateLabel.setSize(40, 20);
		this.stateLabel.setLocation(110, 45);
		this.stateText.setSize(200, 20);
		this.stateText.setLocation(160, 45);
		
		this.udpManager = udpManager;
		
		localhostText.setText(this.udpManager.getLocalhost());
		
		
		this.add(ipLabel);
		this.add(localhostText);
		this.add(clientIPLabel);
		this.add(clientIPText);
		this.add(stateLabel);
		this.add(stateText);
	}

}
