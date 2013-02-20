package jumprun;

import java.util.*;

public class Threading extends Thread {
    public final int PLAYER_MOVEMENT_THREAD = 0;
    public final int ENEMY_MOVEMENT_THREAD = 1;
    public final int MAP_PAINTING_THREAD = 2;
    public final int PLAYER_RIGHTMOVEMENT_THREAD = 3;
    public final int PLAYER_LEFTMOVEMENT_THREAD = 4;
    
    public void run() {
        for (int iterator = 0; iterator < action.size(); ++iterator) {
            switch (Integer.parseInt(action.get(iterator).toString())) {
                case PLAYER_MOVEMENT_THREAD:
                    for (int i = 0; i < 170; i++) {
                        map.setPlayerY(i);
                        try {
                            Thread.sleep(2);
                        } catch (Exception ex) {
                            //Handle Exception
                        }
                    }

                    for (int i = 170; i >= 0; i--) {
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
                    enemy.setPositionY(new Random().nextInt(100)+250);
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
                    
                case PLAYER_RIGHTMOVEMENT_THREAD:
                    while (map.isHorMoving()) {
                        if (map.getPlayerX() >= map.getWidth()-map.getPlayerWidth()-5) {
                            map.setHorMoving(false);
                            break;
                        } else {
                            map.setPlayerX(map.getPlayerX()+1);
                            try {
                                Thread.sleep(4);
                            } catch (Exception ex) {
                                //Handle Exception
                            }
                        }
                            
                    }
                    break;
                case PLAYER_LEFTMOVEMENT_THREAD:
                    while (map.isHorMoving()) {
                        if (map.getPlayerX() <= 5) {
                            map.setHorMoving(false);
                            break;
                        } else {
                            map.setPlayerX(map.getPlayerX()-1);
                            try {
                                Thread.sleep(4);
                            } catch (Exception ex) {
                                //Handle Exception
                            }
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
    
    public void addPlayerRightMovementThread(Map _map) {
        map = _map;
        action.add(PLAYER_RIGHTMOVEMENT_THREAD);
        this.start();
    }
    
    public void addPlayerLeftMovementThread(Map _map) {
        map = _map;
        action.add(PLAYER_LEFTMOVEMENT_THREAD);
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
