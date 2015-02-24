package ro.magyarkec;

import ro.magyarkec.database.DBGeneral;
import ro.magyarkec.ui.window.MainWindow;

import java.util.logging.Logger;

public class Main {

	public static void main(String argv[]) {
//        DBGeneral.getInstance();
		new MainWindow().setVisible(true);
	}

}
