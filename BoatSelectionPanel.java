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
		frame.getContentPane().setLayout(new BorderLayout());
		this.setLayout(new BorderLayout());
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
		button1.addActionListener(new SpeedBoatListener());
		button2 = new JButton(new ImageIcon(img2));
		button2.addActionListener(new JetSkiListener());
		button2.setActionCommand("select");
		button2.setBorder(BorderFactory.createEmptyBorder());
		button2.setContentAreaFilled(false);
		button3 = new JButton(new ImageIcon(img3));
		button3.addActionListener(new FishingBoatListener());
		button3.setActionCommand("select");
		button3.setBorder(BorderFactory.createEmptyBorder());
		button3.setContentAreaFilled(false);   
		button1.setSize(20,20);
		button2.setSize(20,20);
		button3.setSize(30,30);
		this.add(button1,BorderLayout.NORTH);
		this.add(button2,BorderLayout.CENTER);
		this.add(button3,BorderLayout.SOUTH);
	
			 
		} catch (IOException e) {
		}
		this.frame.add(this);
		
	
	}
	protected void paintComponent(Graphics g) {
		
		
		String Speed = "Speed";
		String WakeSize = "Wake Size";
		String Turning = "Turning";
		int RectangleX = 120;
		int RectangleY = 15;
		
		super.paintComponent(g);
		g.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
    	g.drawString("Select Your Boat", 10, 40);
		Color c = new Color(0, 0, 0, 0);
//    	g.drawImage(img1, 10, 150, c, this);
//    	g.drawImage(img2, 10, 550, c, this);
//    	g.drawImage(img3, 10, 350, c, this);
    	g.drawRect(800, 50, RectangleX, RectangleY);
    	g.fillRect(800, 50, RectangleX-20, RectangleY); 
    	g.setFont(new Font("Times New Roman", Font.PLAIN,20));
    	g.drawString(Speed, 700, 60);
    	g.drawRect(800, 80, RectangleX, RectangleY);
    	g.fillRect(800, 80, RectangleX-20, RectangleY);
    	g.drawString(WakeSize, 700, 90);
    	g.drawRect(800, 110, RectangleX, RectangleY);
    	g.fillRect(800, 110, RectangleX-100, RectangleY);
    	g.drawString(Turning, 700, 120);
    	g.drawRect(800, 350, RectangleX, RectangleY);
    	g.fillRect(800, 350, RectangleX-50, RectangleY);
    	g.drawString(Speed, 700, 360);
    	g.drawRect(800, 380, RectangleX, RectangleY);
    	g.fillRect(800, 380, RectangleX-50, RectangleY);
    	g.drawString(WakeSize, 700, 390);
    	g.drawRect(800, 410, RectangleX, RectangleY);
    	g.fillRect(800, 410, RectangleX-50, RectangleY);
    	g.drawString(Turning, 700, 420);
    	g.drawRect(800, 620, RectangleX, RectangleY);
    	g.fillRect(800, 620, RectangleX-100, RectangleY);
    	g.drawString(Speed, 700, 630);
    	g.drawRect(800, 650, RectangleX, RectangleY);
    	g.fillRect(800, 650, RectangleX-100, RectangleY);
    	g.drawString(WakeSize, 700, 660);
    	g.drawRect(800, 680, RectangleX, RectangleY);
    	g.fillRect(800, 680, RectangleX-20, RectangleY);
    	g.drawString(Turning, 700, 690);

    }
}


