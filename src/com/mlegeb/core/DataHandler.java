package com.mlegeb.core;

import com.mlegeb.frame.IndexFrame;
import com.mlegeb.state.*;
import com.mlegeb.udpservice.UdpManager;

/**
 * 名称: DataHandler.java
 * 描述: 数据控制器-负责数据分发
 *
 * @author a_xiang
 * @version v1.0
 * @created 2015年1月20日
 */
public class DataHandler{

	public final int INIT_STATE     = 0;  //初始化模式（休眠模式）
	public final int GAME_STATE     = 1;  //手柄模式
	public final int INPUT_STATE    = 2;  //输入模式
	public final int MOUSE_STATE    = 3;  //鼠标模式
	public final int MUSIC_STATE    = 4;  //播放器模式
	public final int PPT_STATE      = 5;  //PPT模式
	public final int SHUTDOWN_STATE = 6;  //关机模式
	public final int WINDOW_STATE   = 7;  //窗口模式


	/** PC端首页窗口 */
	private IndexFrame indexPanel;

	/** 模式工厂   */
	private StateFactory stateFactory;

	/**  所有模式基类 */
	private AppState appState;

	/** 游戏模式 */
	private GameState  gameState;

	/** 键盘模式 */
	private KeyboardState inputState;

	/** 鼠标模式 */
	private MouseState mouseState;

	/** 播放器模式 */
	private MusicState musicState;

	/** PPT 模式 */
	private PPTState pptState;

	/** CMD(电源)模式 */
	private ShutdownState shutdownState;

	/** 休眠模式 */
	private SleepState sleepState;
	//	private WaittingState waittingState;

	/** 窗口模式 */
	private WindowState windowState;

	/**
	 * 构造函数 初始化字段
	 * @param indexPanel  主页面窗体Frame
	 */
	public DataHandler(IndexFrame indexPanel){
		this.indexPanel = indexPanel;

		stateFactory = new StateFactory();

		gameState = stateFactory.getGameState();
		inputState = stateFactory.getInputState();
		mouseState = stateFactory.getMouseState();
		musicState = stateFactory.getMusicState();
		pptState = stateFactory.getPPTState();
		shutdownState = stateFactory.getShutdownState();
		sleepState = stateFactory.getSleepState(this);
		//waittingState = stateFactory.getWaittingState();
		windowState = stateFactory.getWindowState();

		//初始化为休眠状态
		appState = sleepState;                                                  
	}

	/**
	 * 确定模式分发数据
	 * @param msg 接收的数据
	 * @param udpManager   UDP管理类
	 */
	public void procesData(String msg, UdpManager udpManager){


		if(msg.startsWith("state")){
			//模式请求
			appState = sleepState;	
			appState.AcceptData(msg);
		}
		else if(msg.startsWith("link")){   
			//收到“link” 表示连接操作。
			indexPanel.stateText.setText("已连接");
			//返回successful 表示连接成功
			udpManager.send("Successful");                          
		}
		else{
			//确定模式（为了防止服务器端异常退出后，client端还没确定模式就发送数据）
			changeState(Integer.parseInt(msg.substring(0, 1)));
			//分发数据
			appState.AcceptData(msg.substring(2));
		}
		//窗体显示模式类型
		indexPanel.clientIPText.setText(udpManager.getAddresssIP());
	}

	/**
	 * 状态转变
	 * @param state 状态值
	 */
	public void changeState(int state){
		switch (state) {
		case INIT_STATE:
			appState = sleepState;
			indexPanel.stateText.setText("已连接");
			break;
		case GAME_STATE:
			appState = gameState;
			indexPanel.stateText.setText("手柄模式");
			break;
		case INPUT_STATE:
			appState = inputState;
			indexPanel.stateText.setText("键盘模式");
			break;
		case MOUSE_STATE:
			appState = mouseState;
			indexPanel.stateText.setText("鼠标模式");
			break;
		case MUSIC_STATE:
			appState = musicState;
			indexPanel.stateText.setText("播放器模式");
			break;
		case PPT_STATE:
			appState = pptState;
			indexPanel.stateText.setText("PPT模式");
			break;
		case SHUTDOWN_STATE:
			appState = shutdownState;
			indexPanel.stateText.setText("CMD模式");
			break;
		case WINDOW_STATE:
			appState = windowState;
			indexPanel.stateText.setText("窗口模式");
			break;
		default:
			appState = sleepState;
			indexPanel.stateText.setText("等待连接");
			break;
		}
	}

}
