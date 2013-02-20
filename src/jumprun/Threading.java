package jumprun;

import java.util.*;

public class Threading extends Thread {
    public final int PLAYER_MOVEMENT_THREAD = 0;
    public final int ENEMY_MOVEMENT_THREAD = 1;
    public final int MAP_PAINTING_THREAD = 2;
    
    public void run() {
        for (int iterator = 0; iterator < action.size(); ++iterator) {
            switch (Integer.parseInt(action.get(iterator).toString())) {
                case PLAYER_MOVEMENT_THREAD:
                    for (int i = 0; i < 260; i++) {
                        map.setPlayerY(i);
                        try {
                            Thread.sleep(2);
                        } catch (Exception ex) {
                            //Handle Exception
                        }
                    }

                    for (int i = 260; i >= 0; i--) {
                        map.setPlayerY(i);
                        try {
                            Thread.sleep(2);
                        } catch (Exception ex) {
                            //Handle Exception
                        }
                    }
                    map.setJumpingState(false);
                    break;
                    
                case ENEMY_MOVEMENT_THREAD:
                    enemy.setPositionY(new Random().nextInt(180)+110);
                    for (int x = 600; x >= -100; x--) {
                        enemy.setPositionX(x);
                        try {
                            Thread.sleep(4);
                        } catch (Exception ex) {
                            //Handle Exception
                        }
                    }
                    enemy.setActive(false);
                    break;
                    
                case MAP_PAINTING_THREAD:
                    while (true) {
                        map.repaint();
                        try {
                            Thread.sleep(4);
                        } catch (Exception ex) {
                            //Handle Exception
                        }
                    }
            }
        }
    }
    
    public void addPlayerMovementThread(Map _map) {
        map = _map;
        action.add(PLAYER_MOVEMENT_THREAD);
        this.start();
    }
    
    public void addEnemyMovementThread(Enemy _enemy) {
        enemy = _enemy;
        action.add(ENEMY_MOVEMENT_THREAD);
        this.start();
    }
    
    public void addMapPaintingThread(Map _map) {
        map = _map;
        action.add(MAP_PAINTING_THREAD);
        this.start();
    }
    
    public void clearActions() {
        action = new LinkedList<Integer>();
    }
    
    private List action = new LinkedList<Integer>();
    private Player player;
    private Map map;
    private Enemy enemy;
    private Score score;
}
