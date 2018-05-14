package main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class SelectionScreen extends JPanel implements ActionListener{
	JButton jetSki;
	JButton fishingBoat;
	JButton speedBoat;
	VesselType type;
	/**Constructor for the SelectionScreen class
	 * 
	 */
	SelectionScreen(){
		try {
		 
		BufferedImage img1 = ImageIO.read(new File("Images/vessels/speed_boat.png"));
		BufferedImage img2 = ImageIO.read(new File("Images/vessels/jet_ski.png"));
		BufferedImage img3 = ImageIO.read(new File("Images/vessels/fishing_boat.png"));
		BufferedImage img4 = ImageIO.read(new File("Images/fishingBoatStats.png"));
		BufferedImage img5 = ImageIO.read(new File("Images/jetSkiStats.png"));
		BufferedImage img6 = ImageIO.read(new File("Images/speedBoatStats.png"));
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
		
		JPanel stat1= new JPanel();
		
		
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.CYAN.darker().darker());
		this.add(speedBoat,BorderLayout.NORTH);
		this.add(jetSki,BorderLayout.CENTER);
		this.add(fishingBoat,BorderLayout.SOUTH);
		} catch (IOException e) {
			
		}
	}

	protected void paintComponent(Graphics g) {
		
		
		String Speed = "Speed";
		String WakeSize = "Wake Size";
		String Turning = "Turning";
		int RectangleX = 120;
		int RectangleY = 15;
		
		super.paintComponent(g);
		g.setFont(new Font("Times New Roman", Font.PLAIN, 50));
    	g.drawString("Select Your Boat", 10, 40);
		Color c = new Color(0, 0, 0, 0);
		
		//create the stats 
    	g.drawRect(800, 50, RectangleX, RectangleY);
    	g.fillRect(800, 50, RectangleX-20, RectangleY); 
    	g.setFont(new Font("Times New Roman", Font.PLAIN,20));
    	g.drawString(Speed, 700, 60);
    	g.drawRect(800, 80, RectangleX, RectangleY);
    	g.fillRect(800, 80, RectangleX-20, RectangleY);
    	g.drawString(WakeSize, 700, 90);
    	g.drawRect(800, 110, RectangleX, RectangleY);
    	g.fillRect(800, 110, RectangleX-100, RectangleY);
    	g.drawString(Turning, 700, 120);
    	g.drawRect(800, 350, RectangleX, RectangleY);
    	g.fillRect(800, 350, RectangleX-50, RectangleY);
    	g.drawString(Speed, 700, 360);
    	g.drawRect(800, 380, RectangleX, RectangleY);
    	g.fillRect(800, 380, RectangleX-50, RectangleY);
    	g.drawString(WakeSize, 700, 390);
    	g.drawRect(800, 410, RectangleX, RectangleY);
    	g.fillRect(800, 410, RectangleX-50, RectangleY);
    	g.drawString(Turning, 700, 420);
    	g.drawRect(800, 620, RectangleX, RectangleY);
    	g.fillRect(800, 620, RectangleX-100, RectangleY);
    	g.drawString(Speed, 700, 630);
    	g.drawRect(800, 650, RectangleX, RectangleY);
    	g.fillRect(800, 650, RectangleX-100, RectangleY);
    	g.drawString(WakeSize, 700, 660);
    	g.drawRect(800, 680, RectangleX, RectangleY);
    	g.fillRect(800, 680, RectangleX-20, RectangleY);
    	g.drawString(Turning, 700, 690);

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