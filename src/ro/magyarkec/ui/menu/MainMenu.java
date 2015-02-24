package ro.magyarkec.ui.menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jano on 24-Feb-15.
 */
public class MainMenu extends JMenuBar implements ActionListener{

    private MenuListener mMenuListener;

    public MainMenu(MenuListener menuListener){
        this.mMenuListener = menuListener;
        fileMenu();
        nyilvantartoMenu();

    }

    private void fileMenu(){
        JMenu fileMenu = new JMenu("File");

        MyMenuItem fileExit = new MyMenuItem(MenuItems.FILE_EXIT);
        fileExit.addActionListener(this);






        fileMenu.add(fileExit);
        add(fileMenu);
    }

    private void nyilvantartoMenu(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MenuItems itemData = ((MyMenuItem)e.getSource()).getItemData();

        if(mMenuListener != null){

            switch (itemData){
                case FILE_EXIT:
                    mMenuListener.onExitPressed();
            }


        }

    }


    public interface MenuListener{

        public void onExitPressed();

    }

}
