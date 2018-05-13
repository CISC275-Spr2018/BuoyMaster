package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartGamePanel extends JPanel implements ActionListener {
	JButton startButton;
	boolean start = false;
	View v;
	/**Constructor for the StartScreen
	 * 
	 */
	StartGamePanel(){
		JPanel logoPanel = new JPanel();
		JLabel startLabel = new JLabel("Time to start the Game!", JLabel.CENTER);
		startButton = new JButton("Start");
		startButton.setFocusable(false);
		add(startLabel);
		this.setLayout(new BorderLayout());
		this.add(startButton,BorderLayout.SOUTH);
		startButton.addActionListener((ActionListener) this);
		this.setBounds(0, 0, 100, 100);
		this.setBackground(Color.CYAN.darker());
		
		
		
	}
	/**
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		v.tutorialScreen.setVisible(false); //The StartScreen disappears when the button is pressed
	}
}

