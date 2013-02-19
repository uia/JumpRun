package jumprun;

import java.awt.*;
import java.awt.event.*;

public class GameKeys implements KeyListener {
    public GameKeys(Map _map) {
        map = _map;
    }
    
    public void keyReleased(KeyEvent e) {
        
    }
    
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 38: //Key Up
                Threading thread = new Threading();
                if (!map.getJumpingState()) {
                    map.setJumpingState(true);
                    thread.addMovementThread(map);
                }
                break;
        }
    }
    
    public void keyTyped(KeyEvent e) {
        
    }
    
    private Map map;
}
