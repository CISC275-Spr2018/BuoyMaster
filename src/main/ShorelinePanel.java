package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class ShorelinePanel extends JPanel{
	BufferedImage img;
	private int xDrawLoc;
	private int yDrawLoc;
	/**Constructor for the ShoreLinePanel class. Gets the ShoreLine image.
	 * 
	 */
	ShorelinePanel() {
		try {
		    img = ImageIO.read(new File("images/shoreline.png"));
		} catch (IOException e) {
		}
	}
	/**Updates the view when the ShoreLine moves
	 * @param x x coordinate of ShoreLine
	 * @param y y coordinate of ShoreLine
	 */
	
	void update(int x, int y) {
		xDrawLoc = x;
		yDrawLoc = y;
	}
	/**
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color c = new Color(0, 0, 0, 0); // transparent color
    	g.drawImage(img, xDrawLoc, yDrawLoc, c, this);
    }
	
}