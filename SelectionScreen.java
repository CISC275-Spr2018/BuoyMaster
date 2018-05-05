import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectionScreen extends JPanel implements ActionListener{
	EstuaryView EView;
	JButton boat1;
	JButton boat2;
	JButton boat3;
	
	SelectionScreen(EstuaryView e){
		EView = e;
		EView.startScreen.startButton.addActionListener(this);
		
		boat1 = new JButton("boat1");
		boat2 = new JButton("boat2");
		boat3 = new JButton("boat3");
		
		boat1.setFocusable(false);
		boat2.setFocusable(false);
		boat3.setFocusable(false);
		
		this.add(boat1);
		this.add(boat2);
		this.add(boat3);
		
		boat1.addActionListener(this);
		boat2.addActionListener(this);
		boat3.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		EView.layers.moveToFront(EView.selectionScreen);
	}

}
