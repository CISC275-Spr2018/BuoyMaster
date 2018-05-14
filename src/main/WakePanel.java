package main;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class WakePanel extends JPanel{
	WakeCollection wakeCollection;
	
	/*updates all wakes in a wake collection
	 * @param wc WakeCollection to add to wakesPanel
	 * 
	 */
	void setWakeCollection(WakeCollection wc) {
		wakeCollection = wc;
	}
	
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
		for (Wake w : wakeCollection.wakes) {
			if(w.wakeLife <= 0){
				//something
			}
			double scaleFactor = (1+w.wakeStrength-w.wakeLife)/5;
			
			BufferedImage img = createImage();
			AffineTransform at = AffineTransform.getTranslateInstance(-scaleFactor*img.getWidth()/2 + w.xLoc, -scaleFactor*img.getHeight()/2 + w.yLoc);
			at.scale(scaleFactor, scaleFactor);
			at.rotate(-Math.toRadians(w.rotationAngle), img.getWidth()/2, img.getHeight()/2);
			Graphics2D g2d = (Graphics2D)g.create(); // casts g to Graphics2D rather than passing it as an argument and changing it
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, w.opacity));
			g2d.drawImage(img, at, null);
		}
	}
}