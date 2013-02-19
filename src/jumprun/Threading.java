package jumprun;

import java.util.*;

public class Threading extends Thread {
    public final int PLAYER_MOVEMENT_THREAD = 0;
    
    public void run() {
        for (int iterator = 0; iterator < action.size(); ++iterator) {
            switch (Integer.parseInt(action.get(iterator).toString())) {
                case PLAYER_MOVEMENT_THREAD:
                    for (int i = 0; i < 100; i++) {
                        map.setPlayerY(i);
                        try {
                            Thread.sleep(4);
                        } catch (Exception ex) {
                            //Handle Exception
                        }
                    }

                    for (int i = 100; i >= 0; i--) {
                        map.setPlayerY(i);
                        try {
                            Thread.sleep(4);
                        } catch (Exception ex) {
                            //Handle Exception
                        }
                    }
                    map.setJumpingState(false);
                    break;
            }
        }
    }
    
    public void addMovementThread(Map _map) {
        map = _map;
        action.add(PLAYER_MOVEMENT_THREAD);
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
