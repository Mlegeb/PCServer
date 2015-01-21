package com.mlegeb.state;

import com.mlegeb.config.GameConfigPoco;

/**
 * 名称: GameState.java
 * 描述: 手柄模式
 *
 * @author a_xiang
 * @version v1.0
 * @created 2015年1月21日
 */
public class GameState extends ControlState{

	private GameConfigPoco hcp;
	
	public GameState(){
		hcp = new GameConfigPoco().getConfig();
	}
	@Override
	public void AcceptData(String data) {
		if (data.startsWith("D")) {
            down(Integer.parseInt(data.substring(1)));
        }
        else if (data.startsWith("U")) {
            up(Integer.parseInt(data.substring(1)));
        }
	}
	
	private void down(int i) {
        switch (i)
        {
            case 1:
                massager.keyDown(hcp.i_up);  
                break;
            case 2:
                massager.keyDown(hcp.i_right);
                break;
            case 3:
                massager.keyDown(hcp.i_down);  
                break;
            case 4:
                massager.keyDown(hcp.i_left);
                break;
            case 5:
                massager.keyDown(hcp.i_A);
                break;
            case 6:
                massager.keyDown(hcp.i_B);
                break;
            case 7:
                massager.keyDown(hcp.i_C);
                break;
            case 8:
                massager.keyDown(hcp.i_D);
                break;
            case 9:
                massager.keyDown(hcp.i_XX);
                break;
            case 10:
                massager.keyDown(hcp.i_YY);
                break;
        }
    }

    private void up(int i)
    {
        switch (i)
        {
        case 1:
            massager.keyUp(hcp.i_up);  
            break;
        case 2:
            massager.keyUp(hcp.i_right);
            break;
        case 3:
            massager.keyUp(hcp.i_down);  
            break;
        case 4:
            massager.keyUp(hcp.i_left);
            break;
        case 5:
            massager.keyUp(hcp.i_A);
            break;
        case 6:
            massager.keyUp(hcp.i_B);
            break;
        case 7:
            massager.keyUp(hcp.i_C);
            break;
        case 8:
            massager.keyUp(hcp.i_D);
            break;
        case 9:
            massager.keyUp(hcp.i_XX);
            break;
        case 10:
            massager.keyUp(hcp.i_YY);
            break;        }
    
    }

}
