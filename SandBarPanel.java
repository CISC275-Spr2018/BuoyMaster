import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SandBarPanel extends JPanel{
	private int xDrawLoc;
	private int yDrawLoc;
	BufferedImage img;
	
	SandBarPanel(){
		try {
		    img = ImageIO.read(new File("images\\sandbar.png"));
		} catch (IOException e) {
		}
	}
	
	void update(int x, int y) {
		xDrawLoc = x;
		yDrawLoc = y;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color c = new Color(0, 0, 0, 0); // transparent color
    	g.drawImage(img, xDrawLoc, yDrawLoc, c, this);
    }
}
