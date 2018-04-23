import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DockPanel extends JPanel{
	int x;
	int y;
	Dock d;
	
	DockPanel(Dock d){
		this.d = d;
	}
	
	void updateLocation(Dock d) {
		x = d.xLoc;
		y = d.yLoc;
	}
	
	protected void paintComponent(Graphics g) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("images/dock.png"));
		} catch (IOException e) {
		}
		super.paintComponent(g);
		Color c = new Color(0, 0, 0, 0);
    	g.drawImage(img, d.xLoc, d.yLoc, c, this);
    }
	
	public Dimension getPreferredSize() {
		return new Dimension(250, 250);
	}
} 