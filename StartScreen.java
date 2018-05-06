import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StartScreen extends JPanel{
	JButton startButton;
	View view;
	boolean start = false;
	
	StartScreen(View view){
		startButton = new JButton("Start");
		startButton.setFocusable(false);
		this.view = view; 
		this.add(startButton);
	}

}
