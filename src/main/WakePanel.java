package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class WakePanel extends JPanel{
	ArrayList<Wake> wakesPanel;
	
	
	WakePanel(){
		wakesPanel = new ArrayList<Wake>();
	}
	
	/*updates all wakes in a wake collection
	 * @param wc WakeCollection to add to wakesPanel
	 * 
	 */
	void updateAll(WakeCollection wc) {
		wakesPanel = wc.wakes;
	}
	/*@param dir Direction of wake 
	 * @return returns a buffered image of a wake based on direction
	 * 
	 * 
	 */
	BufferedImage createImage() {
		BufferedImage img = null;

		try {
			img = ImageIO.read(new File("images/wake/east.png"));
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
		for (Wake w : wakesPanel) {
			if(w.wakeLife <= 0){
				this.setVisible(false);
			}
			else if(w.velocity > 0.1 || w.velocity < -0.1){
				BufferedImage img = createImage();
				AffineTransform at = AffineTransform.getTranslateInstance(w.xLoc,w.yLoc);
				at.rotate(-Math.toRadians(w.rotationAngle), img.getWidth()/2, img.getHeight()/2);
				Graphics2D g2d = (Graphics2D)g;
				g2d.drawImage(img, at, null);
			}
		}
	}
}