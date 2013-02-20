package jumprun;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Map extends JFrame {
    public Map() {
        setSize(480,590);
        setLocation(200,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        this.addKeyListener(new GameKeys(this));
        mapPainting = new Threading();
        mapPainting.addMapPaintingThread(this);
        enemy = new Enemy();
        enemy.startPositionThread();
        setVisible(true);
    }
    
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        BufferedImage bi = new BufferedImage(5, 5, BufferedImage.TYPE_INT_RGB);
        Graphics2D big;
        bi = (BufferedImage) createImage(480,590);
        big = bi.createGraphics();
        big.setColor(Color.WHITE);
        big.fillRect(-5, -5, 600, 600);
        big.setColor(Color.BLACK);
        big.fillRect(-5, 400, 500, 600);
        big.setColor(Color.RED);
        big.fillOval(x-c/2, 300-y+c, getPlayerWidth(), 100-c);
        big.setColor(Color.BLACK);
        
        if (!enemy.isActive())
            enemy.startPositionThread();
        
        big.fillRect(enemy.getPositionX(), enemy.getPositionY(), 50, 50);
        g2.drawImage(bi, 0, 0, this);
    }
    
    public int getPlayerWidth() {
        return 100+c;
    }
    
    public void setPlayerY(int i) {
        y = i;
    }
    
    public void setJumpingState(boolean state) {
        isJumping = state;
    }
    
    public boolean getJumpingState() {
        return isJumping;
    }
    
    public void setCrouch(boolean crouch) {
        if (crouch) isJumping = true; else isJumping = false;
        c = crouch ? 50 : 0;
    }
    
    public boolean isHorMoving() {
        return horMoving;
    }
    
    public void setHorMoving(boolean hm) {
        horMoving = hm;
    }
    
    public int getPlayerX() {
        return x;
    }
    
    public void setPlayerX(int _x) {
        x = _x;
    }
    
    private int y = 0, c = 0, x = 100;
    private boolean isJumping = false, horMoving = false;
    private Enemy enemy;
    private Threading mapPainting;
}
