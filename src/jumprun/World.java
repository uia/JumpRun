package jumprun;

import java.util.*;

public class World extends Thread {
    public final int MAP_THREAD = 0;
    public final int SCORE_THREAD = 1;
    public final int PLAYER_THREAD = 2;
    public final int ENEMY_THREAD = 3;
    
    public void run() {
        for (int iterator = 0; iterator < action.size(); ++iterator) {
            switch (Integer.parseInt(action.get(iterator).toString())) {
                case MAP_THREAD:
                    map = new Map();
                    break;
                case SCORE_THREAD:
                    score = new Score();
                    break;
                case PLAYER_THREAD:
                    player = new Player();
                    break;
                case ENEMY_THREAD:
                    enemy = new Enemy();
                    break;
            }
        }
    }
    
    public void addAction(int id) {
        
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
