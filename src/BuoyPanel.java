import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/*
 * BuoyPanel that holds info on how to draw our buoy
 */

public class BuoyPanel extends JPanel{
	private BufferedImage img;
	private int xDrawLoc;
	private int yDrawLoc;
	
	BuoyPanel(){
		try {
		    img = ImageIO.read(new File("images\\buoy.png"));
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
	
	public Dimension getPreferredSize() {
		return new Dimension(250, 250);
	}
}
