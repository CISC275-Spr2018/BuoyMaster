import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/*
 * PlayerPanel that holds info on how to draw our player's Vessel
 */
public class PlayerPanel extends JPanel{
	Vessel player;
	
	PlayerPanel(Vessel v){
		player = v;
	}
	
	BufferedImage getImage() {
		if (player.xVel == 0 && player.yVel < 0) { // north
			return createImage("boat_north.png");
		}
		if (player.xVel > 0 && player.yVel < 0) { // northeast
			return createImage("boat_northeast.png");
		}
		if (player.xVel > 0 && player.yVel == 0) { // east
			return createImage("boat_east.png");
		}
		if (player.xVel > 0 && player.yVel > 0) { // southeast
			return createImage("boat_southeast.png");
		}
		if (player.xVel == 0 && player.yVel > 0) { // south
			return createImage("boat_south.png");
		}
		if (player.xVel < 0 && player.yVel > 0) { // southwest
			return createImage("boat_southwest.png");
		}
		if (player.xVel < 0 && player.yVel == 0) { // west
			return createImage("boat_west.png");
		}
		if (player.xVel < 0 && player.yVel < 0) { // northwest
			return createImage("boat_northwest.png");
		}
		else {
			return createImage("boat_north.png");
		}
	}
	
	BufferedImage createImage(String filename) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("images\\" + filename));
		} catch (IOException e) {
		}
		return img;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color c = new Color(0, 0, 0, 0); // transparent color
    	g.drawImage(getImage(), player.xLoc, player.yLoc, c, this);
    }
	
	public Dimension getPreferredSize() {
		return new Dimension(250, 250);
	}
}
