import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class WakePanel extends JPanel{
	HashSet<Wake> wakesPanel;
	
	WakePanel(){
		wakesPanel = new HashSet<Wake>();
	}
	
	void updateAll(Model model) {
		wakesPanel = model.getPlayer().wakes.wakes;
	}
	
	BufferedImage createImage(String filename) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("images\\" + filename + ".png"));
		} catch (IOException e) {
		}
		return img;
	}
	
	void removeDeadWakes() {
		ArrayList<Wake> old = new ArrayList<Wake>();
		for (Wake w : wakesPanel) {
			if (w.wakeLife <= 0) {
				old.add(w);
			}
		}
		wakesPanel.removeAll(old);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color c = new Color(0, 0, 0, 0); // transparent color
		for (Wake w : wakesPanel) {
			BufferedImage img = createImage(w.direct);
			g.drawImage(img, w.xLoc + 10, w.yLoc + 10, c, this);
		}
	}
}
