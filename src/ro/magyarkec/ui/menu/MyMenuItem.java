package ro.magyarkec.ui.menu;

import javax.swing.*;

/**
 * Created by Jano on 24-Feb-15.
 */
public class MyMenuItem extends JMenuItem {

    private MenuItems item;

    public MyMenuItem(MenuItems item){
        this.item = item;
        setText(item.getTitle());
    }

    public int getId(){
        return item.getId();
    }

    public MenuItems getItemData(){
        return item;
    }
}
