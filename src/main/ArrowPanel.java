package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ArrowPanel extends JPanel {
	private BufferedImage img;
	private int xDrawLoc;
	private int yDrawLoc;
	/*Constructor for the Arrow. It draws the Arrow for the tutorial
	 * 
	 */
	ArrowPanel(){
		try {
		    img = ImageIO.read(new File("images/arrow.png"));
		} catch (IOException e) {
		}
	}
	/* Updates the Arrow panel with the Arrows x and y coordinate
	 * 
	 */
	void update(int x, int y) {
		xDrawLoc = x;
		yDrawLoc = y+1;
	}
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		Color c = new Color(0, 0, 0, 0); // transparent color
    	g.drawImage(img, xDrawLoc, yDrawLoc, c, this);
    }
}

