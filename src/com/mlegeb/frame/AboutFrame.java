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
	private JLabel iconLabel = new JLabel("Android<————>Windows");

	//version
	private JLabel versionLabel = new JLabel("软件版本：V 1.0");
	//创建时间
	private JLabel buildLabel = new JLabel("创建时间： 2014-12-23");
	//作者
	private JLabel authorLabel = new JLabel("作者：a_xiang"); 
	//内容 
	private JLabel contentLabel = new JLabel("<html><body>&nbsp&nbsp&nbsp&nbsp本客户端暂不支持除Windows以外的操作系统。<br>"
			+ "PPT模式支持WPS，音乐播放器支持QQ音乐。</body></html>");


	/**
	 * 构造函数
	 */
	public AboutFrame(){
		this.setLayout(null);

		//标识
		this.iconLabel.setFont(new Font("", 1, 15));
		this.iconLabel.setSize(300, 30);
		this.iconLabel.setLocation(55, 10);

		//version
		this.versionLabel.setSize(200, 20);
		this.versionLabel.setLocation(10, 50);

		//build in
		this.buildLabel.setSize(200, 20);
		this.buildLabel.setLocation(10, 80);
		
		//author
		this.authorLabel.setSize(200, 20);
		this.authorLabel.setLocation(10, 110);
		
		//content
		this.contentLabel.setSize(330, 50);
		this.contentLabel.setLocation(10, 140);

		this.add(iconLabel);
		this.add(versionLabel);
		this.add(buildLabel);
		this.add(authorLabel);
		this.add(contentLabel);
	}
}
