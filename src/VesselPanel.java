
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * PlayerPanel that holds info on how to draw our player's Vessel
 */
public class VesselPanel extends JPanel{
	private VesselType type;
	private Direction dir;
	private int xDrawLoc;
	private int yDrawLoc;
	private double drawAngle;
	/*@returns the buffered image for the vessel based on type selected and direction 
	 * 
	 */
	BufferedImage getImage() {
		return createImage(type, dir);
	}
	/*Updates the view with the vessel based on updated aspects
	 * @param x x coordinate of the vessel
	 * @param y y coordinate of the vessel
	 * @param type the type of boat the user is using
	 * @param dir the direction the vessel is in
	 */
	void update(int x, int y, VesselType type, double drawAngle) {
		xDrawLoc = x;
		yDrawLoc = y;
		this.type = type;
		this.drawAngle = drawAngle;
	}
	/*@param type the type of vessel the user is using
	 * @param dir the direction the vessel is going in
	 * @return returns a buffered image of the vessel 
	 * 
	 */
	BufferedImage createImage(VesselType type, Direction dir) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("images/vessels/" + type.getName() + "/east.png"));
		} catch (IOException e) {
		}
		return img;
	}
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		Color c = new Color(0, 0, 0, 0); // transparent color
		BufferedImage img = getImage();
    	
    	AffineTransform at = AffineTransform.getTranslateInstance(xDrawLoc,yDrawLoc);
		at.rotate(-Math.toRadians(drawAngle), img.getWidth()/2, img.getHeight()/2);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(img, at, null);
    	
    	
    	
    }
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	public Dimension getPreferredSize() {
		return new Dimension(250, 250);
	}
}