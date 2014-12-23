package com.mlegeb.frame;


import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.mlegeb.core.DataHandler;
import com.mlegeb.udpservice.SocketListener;
import com.mlegeb.udpservice.UdpManager;


/**
 * 主窗口界面
 * @author Mine
 */
public class MainFrame extends JFrame implements SocketListener{

	private static final long serialVersionUID = 1L;

	private UdpManager udpManager = new UdpManager();
	private DataHandler dataHandler;
	private GamePadFrame gamePadPanel;
	private IndexFrame indexPanel;
	private AboutFrame aboutPanel;

	/**
	 * 主界面初始化
	 */
	public MainFrame(){
		
		// 创建选项窗格
		JTabbedPane tabPane = new JTabbedPane();

		// 设置面板布局为网格布局
		this.setLayout(new GridLayout(1,1));
		this.setTitle("PC Server");
		this.setSize(330,450);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tabPane.setTabPlacement(JTabbedPane.TOP);// 设定选项卡放在上部
		this.add(tabPane);// 将选项窗格放置在面板中 
		
		// 创建一个Setting面板并添加到选项窗格,这是指定图标的方法
		indexPanel = new IndexFrame(udpManager);
		tabPane.addTab("主页", indexPanel);

		gamePadPanel = new GamePadFrame();
		tabPane.addTab("手柄", gamePadPanel);

		aboutPanel = new AboutFrame();
		tabPane.addTab("关于",  aboutPanel);

		// 选择第一个选项页为当前选择的选项页
		tabPane.setSelectedIndex(0);
		
		
		dataHandler = new DataHandler(indexPanel);
		//开启UDP监听
		udpManager.addSocketListener(this);
		udpManager.start();
	}


	
	@Override
	public void getSocketMessage(String msg) {
		dataHandler.procesData(msg, udpManager);
		System.out.println("receive: " + msg);
	}
}
