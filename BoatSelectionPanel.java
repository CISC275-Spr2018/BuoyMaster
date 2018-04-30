import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoatSelectionPanel extends JPanel {
	private JFrame frame;
    private BufferedImage image;
	BoatSelectionPanel(){
		setFocusable(true);
		this.frame = new JFrame();
		this.frame.add(this);
		this.setBackground(Color.BLUE);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(1000,1000);
		this.frame.setVisible(true);
		JButton SpeedBoat = new JButton("Speed Boat");	
		this.add(SpeedBoat);
		SpeedBoat.setBounds(40, 40, 50, 10);
		JButton Jetski = new JButton("Jetski");
		Jetski.setBounds(10, 250, 50, 10);
		this.add(Jetski);
		JButton FishingBoat = new JButton("FishingBoat");
		FishingBoat.setBounds(50, 415, 50, 10);
		this.add(FishingBoat);
	}
	protected void paintComponent(Graphics g) {
		BufferedImage img1 = null;
		BufferedImage img2 = null;
		BufferedImage img3 = null;
		try {
		    img1 = ImageIO.read(new File("Image/boat_east.png"));
		    img2 = ImageIO.read(new File("Image/fishingboat.png"));
		    img3 = ImageIO.read(new File("Image/Jetski.png"));
		} catch (IOException e) {
		}
		super.paintComponent(g);
		Color c = new Color(0, 0, 0, 0);
    	g.drawImage(img1, 10, 10, c, this);
    	g.drawImage(img2, 10, 390, c, this);
    	g.drawImage(img3, 10, 200, c, this);
    }
}