package jumprun;

import java.util.*;

public class Enemy {
    public void startPositionThread() {
        setActive(true);
        enemyThread = new Threading();
        enemyThread.addEnemyMovementThread(this);
    }
    
    public int getPositionX() {
        return posX;
    }
    
    public int getPositionY() {
        return posY;
    }
    
    public void setPositionX(int _posX) {
        posX = _posX;
    }
    
    public void setPositionY(int _posY) {
        posY = _posY;
    }
    
    public void setActive(boolean _active) {
        active = _active;
    }
    
    public boolean isActive() {
        return active;
    }
    
    private Threading enemyThread;
    private int posX=0, posY=0;
    boolean active;
}
