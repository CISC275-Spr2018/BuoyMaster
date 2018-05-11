package main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class SelectionScreen extends JPanel implements ActionListener{
	JButton jetSki;
	JButton fishingBoat;
	JButton speedBoat;
	VesselType type;
	/*Constructor for the SelectionScreen class
	 * 
	 */
	SelectionScreen(){
		
		jetSki = new JButton("Jet Ski");
		fishingBoat = new JButton("Fishing Boat");
		speedBoat = new JButton("Speed Boat");
		
		jetSki.setFocusable(false);
		fishingBoat.setFocusable(false);
		speedBoat.setFocusable(false); // Keeps focus on the game so arrow keys work
		
		jetSki.addActionListener(this);
		fishingBoat.addActionListener(this);
		speedBoat.addActionListener(this);
		
		
		this.add(jetSki);
		this.add(fishingBoat);
		this.add(speedBoat);
	}
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);	//The SelectionScreen disappears when a vessel button is pressed
	}
}