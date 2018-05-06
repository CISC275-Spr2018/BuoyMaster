package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DockPanel extends JPanel{
	private int xDrawLoc;
	private int yDrawLoc;
	
	void update(int x, int y) {
		xDrawLoc = x;
		yDrawLoc = y;
	}
	
	protected void paintComponent(Graphics g) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("images\\dock.png"));
		} catch (IOException e) {
		}
		super.paintComponent(g);
		Color c = new Color(0, 0, 0, 0);
    	g.drawImage(img, xDrawLoc, yDrawLoc, c, this);
    }
	
	public Dimension getPreferredSize() {
		return new Dimension(250, 250);
	}
} 