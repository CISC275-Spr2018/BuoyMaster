package main;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class StartScreen extends JPanel implements ActionListener{
	JButton startButton;
	boolean start = false;
	/**Constructor for the StartScreen
	 * 
	 */
	StartScreen(){
		JPanel logoPanel = new JPanel();
		JLabel logoLabel = new JLabel("", JLabel.CENTER);
		add(logoLabel);
		ImageIcon title = new ImageIcon("images/logo.png");
		logoLabel.setIcon(title);
		
		startButton = new JButton("Start");
		startButton.setFocusable(false);
		this.add(startButton);
		startButton.addActionListener(this);
		
		
		
	}
	/**
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false); //The StartScreen disappears when the button is pressed
	}
}