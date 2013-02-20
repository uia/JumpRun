package jumprun;

import java.awt.*;
import javax.swing.*;

public class Menu extends JFrame {
    public Menu() {
        setSize(400,350);
        setLocation(200,200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("JumpRun Main Menu");
        getContentPane().setBackground(Color.GRAY);
        setResizable(false);
        
        title = new JLabel("JumpRun");
        title.setBounds(140,20,200,30);
        Font curFont = title.getFont();
        title.setFont(new Font(curFont.getName(), curFont.getStyle(), 24));
        add(title);
        
        startGame = new JButton("Start Game");
        startGame.setBounds(100,100,200,30);
        add(startGame);
        startGame.addActionListener(new MenuAction(0, this));
        
        credits = new JButton("Game Info");
        credits.setBounds(100,160,200,30);
        add(credits);
        credits.addActionListener(new MenuAction(2, this));
        
        exitGame = new JButton("Exit Game");
        exitGame.setBounds(100,220,200,30);
        add(exitGame);
        exitGame.addActionListener(new MenuAction(1, this));
    }
    
    public void noAction() {
        JOptionPane.showMessageDialog(null, "This GUI Component is not available!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private JButton startGame, exitGame, credits;
    private JLabel title;
}
