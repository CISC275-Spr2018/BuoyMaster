
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class DockPanel extends JPanel{
	private int xDrawLoc;
	private int yDrawLoc;
	/*Sets the value of the x and y coordinates of the dock
	 * @param x x coordinate of dock
	 * @param y y coordinate of dock
	 */
	void update(int x, int y) {
		xDrawLoc = x;
		yDrawLoc = y;
	}
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("images/dock.png"));
		} catch (IOException e) {
		}
		super.paintComponent(g);
		Color c = new Color(0, 0, 0, 0);
    	g.drawImage(img, xDrawLoc, yDrawLoc, c, this);
    }
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	public Dimension getPreferredSize() {
		return new Dimension(250, 250);
	}
} 