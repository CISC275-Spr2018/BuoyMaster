import java.awt.BorderLayout;
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

public class SelectionScreen extends JPanel implements ActionListener{
	JButton jetSki;
	JButton fishingBoat;
	JButton speedBoat;
	VesselType type;
	
	SelectionScreen(){
		
		jetSki = new JButton("Jet Ski");
		fishingBoat = new JButton("Fishing Boat");
		speedBoat = new JButton("Speed Boat");
		
		jetSki.setFocusable(false);
		fishingBoat.setFocusable(false);
		speedBoat.setFocusable(false); // Keeps focus on the game so arrow keys work
		
		jetSki.addActionListener(this);
		fishingBoat.addActionListener(this);
		speedBoat.addActionListener(this);
		
		
		this.add(jetSki);
		this.add(fishingBoat);
		this.add(speedBoat);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);	//The SelectionScreen disappears when a vessel button is pressed
	}
}
//JButton jetSki=null;
//JButton fishingBoat=null;
//JButton speedBoat=null;
//BufferedImage img1 = null;
//BufferedImage img2 = null;
//BufferedImage img3 = null;
//VesselType type;
//
//SelectionScreen(){
//	this.setLayout(new BorderLayout());
//	try {
//	    
//		img1 = ImageIO.read(new File("Images/vessels/speed_boat/east"));
//		img2 = ImageIO.read(new File("Images/vessels/jet_ski/east"));
//		img3 = ImageIO.read(new File("Images/vessels/fishing_boat/east"));
//		
//		//button1 attributes
//		speedBoat = new JButton(new ImageIcon(img1));
//		speedBoat.setBorder(BorderFactory.createEmptyBorder());
//		speedBoat.setContentAreaFilled(false);
//
//		
//		
//		//button2 attributes
//		jetSki = new JButton(new ImageIcon(img2));
//		jetSki.setBorder(BorderFactory.createEmptyBorder());
//		jetSki.setContentAreaFilled(false);
//		
//		//button3 attributes
//		fishingBoat =new JButton( new ImageIcon(img3));
//		fishingBoat.setBorder(BorderFactory.createEmptyBorder());
//		fishingBoat.setContentAreaFilled(false);   
//		
//	
//		//add buttons based on their layouts
//		//1 is top
//		//2 is center
//		//3 is south
//		jetSki.setFocusable(false);
//		fishingBoat.setFocusable(false);
//		speedBoat.setFocusable(false); // Keeps focus on the game so arrow keys work
//		
//		jetSki.addActionListener(this);
//		fishingBoat.addActionListener(this);
//		speedBoat.addActionListener(this);
//		this.add(speedBoat,BorderLayout.NORTH);
//		this.add(jetSki,BorderLayout.CENTER);
//		this.add(fishingBoat,BorderLayout.SOUTH);
//
//		
//		} catch (IOException e) {
//		
//		}
//	
//
//	
//
//
//	
//}