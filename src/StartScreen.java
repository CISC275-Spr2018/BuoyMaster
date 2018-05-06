import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StartScreen extends JPanel implements ActionListener{
	JButton startButton;
	boolean start = false;
	
	StartScreen(){
		this.setLayout(new BorderLayout());
		startButton = new JButton("Start");
		startButton.setFocusable(false);
		this.add(startButton,BorderLayout.SOUTH);
		startButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false); //The StartScreen disappears when the button is pressed
	}
}
