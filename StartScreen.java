import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StartScreen extends JPanel{
	JButton startButton;
	EstuaryView EView;
	boolean start = false;
	
	StartScreen(EstuaryView e){
		startButton = new JButton("Start");
		startButton.setFocusable(false);
		EView = e; 
		this.add(startButton);
	}

}
