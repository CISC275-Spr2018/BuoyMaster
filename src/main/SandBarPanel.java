package main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class SandBarPanel extends JPanel{
	HashSet<SandBar> sandBars=new HashSet<SandBar>();
	BufferedImage img;
	/**Constructor for the SandBar panel creates an image of a SandBar
	 * 
	 */
	SandBarPanel(){
		try {
		    img = ImageIO.read(new File("images/sandbar.png"));
		} catch (IOException e) {
		}
	}
	/**Updates the panel with the SandBarCollection
	 * @param sbc SandBarCollection from model
	 * 
	 */
	void update(SandBarCollection sbc) {
		sandBars = sbc.sandBars;
	}
	/**
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color c = new Color(0, 0, 0, 0); // transparent color
    	for (SandBar s : sandBars) {
    		g.drawImage(img, s.xLoc + 10, s.yLoc + 10, c, this);
    	}
    }
}