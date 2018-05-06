package main;
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
public class VesselPanel extends JPanel{
	private VesselType type;
	private Direction dir;
	private int xDrawLoc;
	private int yDrawLoc;
	
	BufferedImage getImage() {
		return createImage(type, dir);
	}
	
	void update(int x, int y, VesselType type, Direction dir) {
		xDrawLoc = x;
		yDrawLoc = y;
		this.type = type;
		this.dir = dir;
	}
	
	BufferedImage createImage(VesselType type, Direction dir) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("images\\vessels\\" + type.getName() + "\\" + dir.getName() + ".png"));
		} catch (IOException e) {
		}
		return img;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color c = new Color(0, 0, 0, 0); // transparent color
    	g.drawImage(getImage(), xDrawLoc, yDrawLoc, c, this);
    }
	
	public Dimension getPreferredSize() {
		return new Dimension(250, 250);
	}
}
