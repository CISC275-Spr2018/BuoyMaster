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
	BufferedImage img;
	HashSet<Wake> wakesPanel;
	
	WakePanel(){
		wakesPanel = new HashSet<Wake>();
		try {
		    img = ImageIO.read(new File("images\\wake.png"));
		} catch (IOException e) {
		}
	}
	
	void updateAll(Model model) {
		removeDeadWakes();
		for (Wake w : model.getPlayer().wakes.wakes) {
			w.img = createImage(w.direct);
			wakesPanel.add(w);
		}
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
			g.drawImage(w.img, w.xLoc + 10, w.yLoc + 10, c, this);
		}
	}
}
