package main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
