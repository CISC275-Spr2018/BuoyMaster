import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SandBarPanel extends JPanel{
	HashSet<SandBar> sandBars;
	BufferedImage img;
	
	SandBarPanel(){
		try {
		    img = ImageIO.read(new File("images\\sandbar.png"));
		} catch (IOException e) {
		}
	}
	
	void update(SandBarCollection sbc) {
		sandBars = sbc.sandBars;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color c = new Color(0, 0, 0, 0); // transparent color
    	for (SandBar s : sandBars) {
    		g.drawImage(img, s.xLoc + 10, s.yLoc + 10, c, this);
    	}
    }
}
