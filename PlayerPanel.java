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
	int x;
	int y;
	Vessel player;
	
	PlayerPanel(Vessel v){
		player = v;
	}
	
	protected void paintComponent(Graphics g) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("boat.png"));
		} catch (IOException e) {
		}
		super.paintComponent(g);
		g.setColor(Color.gray);
    	g.drawImage(img, player.xLoc, player.yLoc, Color.BLUE, this);
    }
	
	public Dimension getPreferredSize() {
		return new Dimension(250, 250);
	}
}
