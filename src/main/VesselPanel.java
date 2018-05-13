package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * PlayerPanel that holds info on how to draw our player's Vessel
 */
public class VesselPanel extends JPanel{
	private VesselType type;
	private Direction dir;
	private int xDrawLoc;
	private int yDrawLoc;
	/**@return returns the buffered image for the vessel based on type selected and direction 
	 * 
	 */
	BufferedImage getImage() {
		return createImage(type, dir);
	}
	/**Updates the view with the vessel based on updated aspects
	 * @param x x coordinate of the vessel
	 * @param y y coordinate of the vessel
	 * @param type the type of boat the user is using
	 * @param dir the direction the vessel is in
	 */
	void update(int x, int y, VesselType type, Direction dir) {
		xDrawLoc = x;
		yDrawLoc = y;
		this.type = type;
		this.dir = dir;
	}
	/**@param type the type of vessel the user is using
	 * @param dir the direction the vessel is going in
	 * @return returns a buffered image of the vessel 
	 * 
	 */
	BufferedImage createImage(VesselType type, Direction dir) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("images/vessels/" + type.getName() + "/" + dir.getName() + ".png"));
		} catch (IOException e) {
		}
		return img;
	}
	/**
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color c = new Color(0, 0, 0, 0); // transparent color
    	g.drawImage(getImage(), xDrawLoc, yDrawLoc, c, this);
    }
	/**
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	public Dimension getPreferredSize() {
		return new Dimension(250, 250);
	}
}