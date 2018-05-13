
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
/*
 * BuoyPanel that holds info on how to draw our buoy
 */

public class BuoyPanel extends JPanel{
	private BufferedImage img;
	private int xDrawLoc;
	private int yDrawLoc;
	/*Constructor for the BuoyPanel. It draws the buoy
	 * 
	 */
	BuoyPanel(){
		try {
		    img = ImageIO.read(new File("images/buoy.png"));
		} catch (IOException e) {
		}
	}
	/* Updates the buoy panel with the buoy's x and y coordinate
	 * @param x buoys x coordinate
	 * @param y buoy's y coordinate
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
		super.paintComponent(g);
		Color c = new Color(0, 0, 0, 0); // transparent color
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