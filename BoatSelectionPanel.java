import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
	} 
	protected void paintComponent(Graphics g) {
		BufferedImage img1 = null;
		BufferedImage img2 = null;
		BufferedImage img3 = null;
		String Speed = "Speed";
		String WakeSize = "Wake Size";
		String Turning = "Turning";
		int ImageX = 10;
		int RectangleWidth = 120;
		int RectangleHeight = 15;
		int RectangleX = 250;
		int RectangleY = 150;
		int StringX = 400;
		int StringY = 160;
		try {
		    img1 = ImageIO.read(new File("images/boat_east.png"));
		    img2 = ImageIO.read(new File("images/fishingboat.png"));
		    img3 = ImageIO.read(new File("images/Jetski.png"));
		    JButton button1 = new JButton(new ImageIcon(img1));
		    button1.setBorder(BorderFactory.createEmptyBorder());
		    button1.setContentAreaFilled(false);
		    JButton button2 = new JButton(new ImageIcon(img2));
		    button2.setBorder(BorderFactory.createEtchedBorder());
		    button2.setContentAreaFilled(false);
		    JButton button3 = new JButton(new ImageIcon(img3));
		    button3.setBorder(BorderFactory.createEtchedBorder());
		    button3.setContentAreaFilled(false);   
		} catch (IOException e) {
		}
		super.paintComponent(g);
		g.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
    	g.drawString("Select Your Boat", 300, 40);
		Color c = new Color(0, 0, 0, 0);
    	g.drawImage(img1, ImageX, 150, c, this);
    	g.drawImage(img2, ImageX, 550, c, this);
    	g.drawImage(img3, ImageX, 350, c, this);
    	g.drawRect(RectangleX, RectangleY, RectangleWidth, RectangleHeight);
    	g.fillRect(RectangleX, RectangleY, RectangleWidth-20, RectangleHeight); 
    	g.setFont(new Font("Times New Roman", Font.PLAIN,20));
    	g.drawString(Speed, StringX, StringY);
    	g.drawRect(RectangleX, RectangleY+30, RectangleWidth, RectangleHeight);
    	g.fillRect(RectangleX, RectangleY+30, RectangleWidth-20, RectangleHeight);
    	g.drawString(WakeSize, StringX, StringY+30);
    	g.drawRect(RectangleX, RectangleY+60, RectangleWidth, RectangleHeight);
    	g.fillRect(RectangleX, RectangleY+60, RectangleWidth-100, RectangleHeight);
    	g.drawString(Turning, StringX, StringY+60);
    	g.drawRect(RectangleX, RectangleY+200, RectangleWidth, RectangleHeight);
    	g.fillRect(RectangleX, RectangleY+200, RectangleWidth-50, RectangleHeight);
    	g.drawString(Speed, StringX, StringY+120);
    	g.drawRect(RectangleX, RectangleY+230, RectangleWidth, RectangleHeight);
    	g.fillRect(RectangleX, RectangleY+230, RectangleWidth-50, RectangleHeight);
    	g.drawString(WakeSize, StringX, StringY+150);
    	g.drawRect(RectangleX, RectangleY+260, RectangleWidth, RectangleHeight);
    	g.fillRect(RectangleX, RectangleY+260, RectangleWidth-50, RectangleHeight);
    	g.drawString(Turning, StringX, StringY+180);
    	g.drawRect(RectangleX, RectangleY+400, RectangleWidth, RectangleHeight);
    	g.fillRect(RectangleX, RectangleY+400, RectangleWidth-100, RectangleHeight);
    	g.drawString(Speed, StringX, StringY+260);
    	g.drawRect(RectangleX, RectangleY+430, RectangleWidth, RectangleHeight);
    	g.fillRect(RectangleX, RectangleY+430, RectangleWidth-100, RectangleHeight);
    	g.drawString(WakeSize, StringX, StringY+290);
    	g.drawRect(RectangleX, RectangleY+460, RectangleWidth, RectangleHeight);
    	g.fillRect(RectangleX, RectangleY+460, RectangleWidth-20, RectangleHeight);
    	g.drawString(Turning, StringX, StringY+320);
    }
}