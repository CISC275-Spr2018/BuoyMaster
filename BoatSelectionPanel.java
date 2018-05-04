import java.awt.BorderLayout;
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


public class BoatSelectionPanel  extends JPanel {
	private JFrame frame;
    private BufferedImage image;
    JButton button1=null;
    JButton button2=null;
	BufferedImage img1 = null;
	BufferedImage img2 = null;
	BufferedImage img3 = null;
    JButton button3=null;
	BoatSelectionPanel(){
		setFocusable(true);
		this.frame = new JFrame();
		this.frame.add(this);
		this.setBackground(Color.BLUE);
		this.frame.setSize(1000,1000);
	
		try {
		    
		img1 = ImageIO.read(new File("Images/boat_east.png"));
		img2 = ImageIO.read(new File("Images/boat_east.png"));
		img3 = ImageIO.read(new File("Images/boat_east.png"));
		    
		button1 = new JButton(new ImageIcon(img1));
			
		button1.setBorder(BorderFactory.createEmptyBorder());
		button1.setContentAreaFilled(false);
		button1.setActionCommand("select");
		button2 = new JButton(new ImageIcon(img2));
		button2.addActionListener(new JetSkiListener());
		button2.setActionCommand("select");
		button2.setBorder(BorderFactory.createEtchedBorder());
		button2.setContentAreaFilled(false);
		button3 = new JButton(new ImageIcon(img3));
		button3.addActionListener(new FishingBoatListener());
		button3.setActionCommand("select");
		button3.setBorder(BorderFactory.createEtchedBorder());
		button3.setContentAreaFilled(false);   
//		button1.setBounds(0, 150, 20, 20);
//		button2.setBounds(10, 350, 20, 20);
//		button3.setBounds(10,550,20,20);
		 
		    this.add(button1,BorderLayout.NORTH);
		    this.add(button2,BorderLayout.CENTER);
		    this.add(button3,BorderLayout.SOUTH);
//		    button1.setLocation(10, 150);
//		    button2.setLocation(10,350);
//		    button3.setLocation(10,550);
		} catch (IOException e) {
		}
		
		
	
	}
	protected void paintComponent(Graphics g) {
		
		
		String Speed = "Speed";
		String WakeSize = "Wake Size";
		String Turning = "Turning";
		int RectangleX = 120;
		int RectangleY = 15;
		
		super.paintComponent(g);
		g.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
    	g.drawString("Select Your Boat", 300, 40);
		Color c = new Color(0, 0, 0, 0);
//    	g.drawImage(img1, 10, 150, c, this);
//    	g.drawImage(img2, 10, 550, c, this);
//    	g.drawImage(img3, 10, 350, c, this);
    	g.drawRect(250, 150, RectangleX, RectangleY);
    	g.fillRect(250, 150, RectangleX-20, RectangleY); 
    	g.setFont(new Font("Times New Roman", Font.PLAIN,20));
    	g.drawString(Speed, 400, 160);
    	g.drawRect(250, 180, RectangleX, RectangleY);
    	g.fillRect(250, 180, RectangleX-20, RectangleY);
    	g.drawString(WakeSize, 400, 190);
    	g.drawRect(250, 210, RectangleX, RectangleY);
    	g.fillRect(250, 210, RectangleX-100, RectangleY);
    	g.drawString(Turning, 400, 220);
    	g.drawRect(250, 350, RectangleX, RectangleY);
    	g.fillRect(250, 350, RectangleX-50, RectangleY);
    	g.drawString(Speed, 400, 360);
    	g.drawRect(250, 380, RectangleX, RectangleY);
    	g.fillRect(250, 380, RectangleX-50, RectangleY);
    	g.drawString(WakeSize, 400, 390);
    	g.drawRect(250, 410, RectangleX, RectangleY);
    	g.fillRect(250, 410, RectangleX-50, RectangleY);
    	g.drawString(Turning, 400, 420);
    	g.drawRect(250, 550, RectangleX, RectangleY);
    	g.fillRect(250, 550, RectangleX-100, RectangleY);
    	g.drawString(Speed, 400, 560);
    	g.drawRect(250, 580, RectangleX, RectangleY);
    	g.fillRect(250, 580, RectangleX-100, RectangleY);
    	g.drawString(WakeSize, 400, 580);
    	g.drawRect(250, 610, RectangleX, RectangleY);
    	g.fillRect(250, 610, RectangleX-20, RectangleY);
    	g.drawString(Turning, 400, 620);

    }
}


