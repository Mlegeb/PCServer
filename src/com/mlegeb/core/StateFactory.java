package com.mlegeb.core;

import com.mlegeb.state.*;

/**
 * 名称: StateFactory.java
 * 描述: 模式工厂   返回各模式对象
 *
 * @author a_xiang
 * @version v1.0
 * @created 2015年1月21日
 */
public class StateFactory {
	public SleepState getSleepState(DataHandler dh) { return new SleepState(dh); }
    public WaittingState getWaittingState() { return new WaittingState(); }
   
    public GameState getGameState() { return new GameState(); }
    public InputState getInputState() { return new InputState(); }
    public MouseState getMouseState() { return new MouseState(); }
    public MusicState getMusicState() { return new MusicState(); }
    public PPTState getPPTState() { return new PPTState(); }
    public ShutdownState getShutdownState() { return new ShutdownState(); }
    public WindowState getWindowState() { return new WindowState(); }
}
