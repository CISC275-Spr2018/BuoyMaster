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
	Buoy buoy;
	
	BuoyPanel(Buoy b){
		buoy = b;
	}
	
	protected void paintComponent(Graphics g) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("images\\buoy.png"));
		} catch (IOException e) {
		}
		super.paintComponent(g);
		g.setColor(Color.gray);
    	g.drawImage(img, buoy.xLoc, buoy.yLoc, Color.BLUE, this);
    }
	
	public Dimension getPreferredSize() {
		return new Dimension(250, 250);
	}
}
