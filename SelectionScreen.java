import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectionScreen extends JPanel implements ActionListener{
	EstuaryView EView;
	JButton jetSki;
	JButton fishingBoat;
	JButton speedBoat;
	
	SelectionScreen(EstuaryView e){
		EView = e;
		EView.startScreen.startButton.addActionListener(this);
		
		jetSki = new JButton("Jet Ski");
		fishingBoat = new JButton("Fishing Boat");
		speedBoat = new JButton("Speed Boat");
		
		jetSki.setFocusable(false);
		fishingBoat.setFocusable(false);
		speedBoat.setFocusable(false);
		
		this.add(jetSki);
		this.add(fishingBoat);
		this.add(speedBoat);
		
		jetSki.addActionListener(this);
		fishingBoat.addActionListener(this);
		speedBoat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		EView.layers.moveToFront(EView.selectionScreen);
	}

}
