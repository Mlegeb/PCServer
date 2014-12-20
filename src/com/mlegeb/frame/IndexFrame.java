package com.mlegeb.frame;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mlegeb.udpservice.UdpManager;

/**
 * 配置设置界面
 * @author Mine
 *
 */
public class IndexFrame extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField localhostField;
	public JTextField stateField;
	private UdpManager udpManager;
	
	/**
	 *构造函数初始化
	 * @param udpManager
	 */
	public IndexFrame(UdpManager udpManager){
		this.udpManager = udpManager;
		
		localhostField = new JTextField();
		stateField = new JTextField();
		
		localhostField.setText(this.udpManager.getLocalhost());
		
		this.add(localhostField);
		this.add(stateField);
	}

}
