package ro.magyarkec.ui.window;

import ro.magyarkec.ui.menu.MainMenu;

import javax.swing.*;

/**
 * Created by Jano on 24-Feb-15.
 */
public class MainWindow extends JFrame implements MainMenu.MenuListener {

    public MainWindow(){
        super();
        setTitle("Adatkezelő X");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setJMenuBar(new MainMenu(this));
    }

    @Override
    public void onExitPressed() {
        System.exit(0);
    }
}
