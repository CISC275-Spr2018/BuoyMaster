package main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
		try {
		 
		BufferedImage img1 = ImageIO.read(new File("Images/vessels/speed_boat/east.png"));
		BufferedImage img2 = ImageIO.read(new File("Images/vessels/jet_ski/east.png"));
		BufferedImage img3 = ImageIO.read(new File("Images/vessels/fishing_boat/east.png"));
		jetSki = new JButton(new ImageIcon(img2));
		fishingBoat = new JButton(new ImageIcon(img3));
		speedBoat = new JButton(new ImageIcon(img1));
		//button creation stuff;
		
		jetSki.setFocusable(false);
		jetSki.setBorder(BorderFactory.createEmptyBorder());
		jetSki.setContentAreaFilled(false);
		
		fishingBoat.setFocusable(false);
		fishingBoat.setBorder(BorderFactory.createEmptyBorder());
		fishingBoat.setContentAreaFilled(false);
		
		speedBoat.setFocusable(false); // Keeps focus on the game so arrow keys work
		speedBoat.setBorder(BorderFactory.createEmptyBorder());
		jetSki.setBorder(BorderFactory.createEmptyBorder());
		speedBoat.setContentAreaFilled(false);
		
		jetSki.addActionListener(this);
		fishingBoat.addActionListener(this);
		speedBoat.addActionListener(this);
		
	
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.CYAN.darker().darker());
		this.add(speedBoat,BorderLayout.NORTH);
		this.add(jetSki,BorderLayout.CENTER);
		this.add(fishingBoat,BorderLayout.SOUTH);
		} catch (IOException e) {
			
		}
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