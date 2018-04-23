import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SandBarPanel extends JPanel{
	SandBar sandBar;
	BufferedImage img;
	
	SandBarPanel(SandBar s){
		sandBar = s;
		try {
		    img = ImageIO.read(new File("images/sandbar.png"));
		} catch (IOException e) {
		}
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color c = new Color(0, 0, 0, 0); // transparent color
    	g.drawImage(img, sandBar.xLoc, sandBar.yLoc, c, this);
    }
}
