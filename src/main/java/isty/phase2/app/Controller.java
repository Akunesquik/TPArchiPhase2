package isty.phase2.app;
import java.awt.EventQueue;

import isty.phase2.IHM.MainWindow;
import isty.phase2.Groupe.GroupeImplementation;

public class Controller {

public static void main(String[] args) {
	
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				MainWindow window = new MainWindow();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
		

	
}
