package jumprun;

import java.awt.event.*;

public class MenuAction implements ActionListener {
    public MenuAction(int _id, Menu _menu) {
        id = _id;
        menu = _menu;
    }
    
    public void actionPerformed(ActionEvent e) {
        switch (id) {
            case 0:
                //Start Game;
                break;
            case 1: 
                menu.dispose();
                break;
            default:
                menu.noAction();
        }
    }
    
    private int id;
    private Menu menu;
}
