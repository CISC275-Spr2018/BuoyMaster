import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EstuaryView extends JPanel{

	
	JFrame frame;
	int xLoc;
	int yLoc;
	
	PlayerPanel playerPanel;
	BuoyPanel buoyPanel;
	
	EstuaryView(Model model){
		playerPanel = new PlayerPanel();
		buoyPanel = new BuoyPanel();
		
		setFocusable(true);
		
		this.frame = new JFrame();
		this.frame.add(playerPanel);
		this.frame.add(buoyPanel);
		this.frame.add(this);
		
		this.setBackground(Color.BLUE);
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(model.width, model.height);
		this.frame.setVisible(true);
	}
	
	// all individual view update methods in central method
	public void update(Model model){
		playerPanel.updateLocation(model.player);
		buoyPanel.updateLocation(model.buoy);
		this.repaint();
	}
	
	// all individual paint methods in central method
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		buoyPanel.paintComponent(g);
		playerPanel.paintComponent(g);
    }
	
}
