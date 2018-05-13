package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class WakePanel extends JPanel{
	HashSet<Wake> wakesPanel;
	/**Creates the HashSet of wakes
	 * 
	 */
	WakePanel(){
		wakesPanel = new HashSet<Wake>();
	}
	/**updates all wakes in a wake collection
	 * @param wc WakeCollection to add to wakesPanel
	 * 
	 */
	void updateAll(WakeCollection wc) {
		wakesPanel = wc.wakes;
	}
	/**@param dir Direction of wake 
	 * @return returns a buffered image of a wake based on direction
	 * 
	 * 
	 */
	BufferedImage createImage(Direction dir) {
		BufferedImage img = null;
		if(dir != null){ //If direction is null, the boat isn't moving and there is no wake.
			try {
			    img = ImageIO.read(new File("images/wake/" + dir.getName() + ".png"));
			} catch (IOException e) {
			}
		}
		return img;
	}
	/**Remvoes wakes which wakeLife is below zero. 
	 * 
	 */
	void removeDeadWakes() {
		ArrayList<Wake> old = new ArrayList<Wake>();
		for (Wake w : wakesPanel) {
			if (w.wakeLife <= 0) {
				old.add(w);
			}
		}
		wakesPanel.removeAll(old);
	}
	/**
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color c = new Color(0, 0, 0, 0); // transparent color
		for (Wake w : wakesPanel) {
			BufferedImage img = createImage(w.dir);
			g.drawImage(img, w.xLoc + 10, w.yLoc + 10, c, this);
		}
	}
}