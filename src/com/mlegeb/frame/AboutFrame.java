package com.mlegeb.frame;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * 名称: AboutFrame.java
 * 描述: 关于窗口页面
 *
 * @author a_xiang
 * @version v1.0
 * @created 2015年1月21日
 */
public class AboutFrame extends JPanel {

	private static final long serialVersionUID = 1L;

	//标示
	private JLabel iconLabel = new JLabel("Android <——  ⊙  ——>Windows");

	//version
	private JLabel versionLabel = new JLabel("软件版本：V 1.0");
	//创建时间
	private JLabel buildLabel = new JLabel("创建时间： 2014-12-23");
	//内容 
	private JLabel contentLabel = new JLabel("本软件的所有权归本人所有");


	/**
	 * 构造函数
	 */
	public AboutFrame(){
		this.setLayout(null);

		//标识
		this.iconLabel.setFont(new Font("", 1, 15));
		this.iconLabel.setSize(300, 30);
		this.iconLabel.setLocation(25, 10);

		//version
		this.versionLabel.setSize(200, 20);
		this.versionLabel.setLocation(10, 50);

		//build in
		this.buildLabel.setSize(200, 20);
		this.buildLabel.setLocation(10, 80);

		//build in
		this.contentLabel.setSize(250, 20);
		this.contentLabel.setLocation(10, 110);

		this.add(iconLabel);
		this.add(versionLabel);
		this.add(buildLabel);
		this.add(contentLabel);
	}
}
