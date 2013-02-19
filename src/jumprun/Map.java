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
        big.fillOval(100-c/2, 300-y+c, 100+c, 100-c);
        g2.drawImage(bi, 0, 0, this);
    }
    
    public void setPlayerY(int i) {
        y = i;
        System.out.println(i);
        this.repaint();
    }
    
    public void setJumpingState(boolean state) {
        isJumping = state;
    }
    
    public boolean getJumpingState() {
        return isJumping;
    }
    
    public void setCrouch(boolean crouch) {
        c = crouch ? 50 : 0;
        this.repaint();
    }
    
    private int y = 0, c = 0;
    private boolean isJumping = false;
}
