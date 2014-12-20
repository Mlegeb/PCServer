package com.mlegeb.core;

import com.mlegeb.state.*;


/**
 * 状态工厂
 * @author Mine
 */
public class StateFactory {
	public SleepState getSleepState(DataHandler dh) { return new SleepState(); }
    public WaittingState getWaittingState() { return new WaittingState(); }
    
    
    public GameState getGameState() { return new GameState(); }
    public InputState getInputState() { return new InputState(); }
    public MouseState getMouseState() { return new MouseState(); }
    public MusicState getMusicState() { return new MusicState(); }
    public PPTState getPPTState() { return new PPTState(); }
    public ShutdownState getShutdownState() { return new ShutdownState(); }
    public WindowState getWindowState() { return new WindowState(); }
}
