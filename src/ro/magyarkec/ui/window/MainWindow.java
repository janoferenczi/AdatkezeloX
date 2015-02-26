package ro.magyarkec.ui.window;

import ro.magyarkec.ui.menu.MainMenu;
import ro.magyarkec.ui.widgets.dialogs.PersonDialog;

import javax.swing.*;
import java.awt.*;

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
    public void setVisible(boolean b) {
        super.setVisible(b);
        PersonDialog dialog = new PersonDialog();
        dialog.setTitle("Hello");
        dialog.setVisible(true);
    }

    @Override
    public void onExitPressed() {
        System.exit(0);
    }
}
