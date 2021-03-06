package jumprun;

import java.awt.*;
import java.awt.event.*;

public class GameKeys implements KeyListener {
    public GameKeys(Map _map) {
        map = _map;
    }
    
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 40: //Key Down
                map.setCrouch(false);
                break;
            case 39:
            case 37:
                map.setHorMoving(false);
                break;
        }
    }
    
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 38: //Key Up
                Threading thread = new Threading();
                if (!map.getJumpingState()) {
                    map.setJumpingState(true);
                    thread.addPlayerMovementThread(map);
                }
                break;
                
            case 40: //Key Down
                map.setCrouch(true);
                break;
                
            case 39: //Key Right
                horMovement = new Threading();
                map.setHorMoving(true);
                horMovement.addPlayerRightMovementThread(map);
                break;
                
            case 37: //Key Left
                horMovement = new Threading();
                map.setHorMoving(true);
                horMovement.addPlayerLeftMovementThread(map);
                break;
        }
    }
    
    public void keyTyped(KeyEvent e) {
        
    }
    
    private Map map;
    private Threading horMovement;
}
