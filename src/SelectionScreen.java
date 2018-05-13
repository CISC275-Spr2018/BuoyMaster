
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class SelectionScreen  extends JPanel implements ActionListener {
    JFrame frame;
    BufferedImage image;
    JButton speedBoat;
    JButton jetSki;
    JButton fishingBoat;
	BufferedImage img1 = null;
	BufferedImage img2 = null;
	BufferedImage img3 = null;
	VesselType type;
	/*BoatSelectionPanel(){
		
		setFocusable(true);
		this.frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout());
		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLUE.darker().darker());
		this.frame.setSize(1000,1000);
	
		try {
		    
		img1 = ImageIO.read(new File("Images/boat_east.png"));
		img2 = ImageIO.read(new File("Images/boat_east.png"));
		img3 = ImageIO.read(new File("Images/boat_east.png"));
		
		//button1 attributes
		button1 = new JButton(new ImageIcon(img1));
		button1.setBorder(BorderFactory.createEmptyBorder());
		button1.setContentAreaFilled(false);
		button1.setActionCommand("select");
		button1.addActionListener(new SpeedBoatListener());
		//button2 attributes
		button2 = new JButton(new ImageIcon(img2));
		button2.addActionListener(new JetSkiListener());
		button2.setActionCommand("select");
		button2.setBorder(BorderFactory.createEmptyBorder());
		button2.setContentAreaFilled(false);
		//button3 attributes
		button3 = new JButton(new ImageIcon(img3));
		button3.addActionListener(new FishingBoatListener());
		button3.setActionCommand("select");
		button3.setBorder(BorderFactory.createEmptyBorder());
		button3.setContentAreaFilled(false);   
		
		button1.setSize(20,20);
		button2.setSize(20,20);
		button3.setSize(30,30);
		//add buttons based on their layouts
		//1 is top
		//2 is center
		//3 is south
		this.add(button1,BorderLayout.NORTH);
		this.add(button2,BorderLayout.CENTER);
		this.add(button3,BorderLayout.SOUTH);
	
			 
		} catch (IOException e) {
		
		}
		
		this.frame.add(this);
		
	
	}*/
	SelectionScreen(){
		//setFocusable(true);
		this.frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout());
		this.setLayout(new BorderLayout());
		this.setBackground(Color.CYAN.darker().darker());
		//this.frame.setSize(1000,1000);
		try { 
		    	BufferedImage img3 = ImageIO.read(new File("images/vessels/fishing_boat/east.png"));
		    	BufferedImage img2 = ImageIO.read(new File("images/vessels/jet_ski/east.png"));
			    BufferedImage img1 = ImageIO.read(new File("images/vessels/speed_boat/east.png"));

				speedBoat = new JButton(new ImageIcon(img1));
				speedBoat.setFocusable(false);
				speedBoat.setContentAreaFilled(false);
				speedBoat.setActionCommand("select");
			    speedBoat.addActionListener(this);
			    speedBoat.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			    //this.add(speedboat,BorderLayout.WEST);
			    //this.setLayout(null);
 
				jetSki = new JButton(new ImageIcon(img2));
				jetSki.setContentAreaFilled(false);
				jetSki.setFocusable(false);
				jetSki.setActionCommand("select");
			    jetSki.addActionListener(this);
			    jetSki.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			    //this.add(jetski, BorderLayout.NORTH);
			    //this.setLayout(null);
		    
				fishingBoat = new JButton(new ImageIcon(img3));
				fishingBoat.setContentAreaFilled(false);
				fishingBoat.setFocusable(false);
				fishingBoat.setActionCommand("select");			    
				fishingBoat.addActionListener(this);
			    fishingBoat.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			    
				this.add(speedBoat,BorderLayout.NORTH);
				this.add(jetSki,BorderLayout.CENTER);
				this.add(fishingBoat,BorderLayout.SOUTH);
			    //subPanel.add(fishingboat, BorderLayout.WEST);
		  	} catch (Exception ex) {
		  		System.out.println(ex);
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
		
		//create the stats 
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}
}