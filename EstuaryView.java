import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Main View class for the game.
 * Will hold all different Panels of objects - PlayerPanel, BuoyPanel, etc.
 */
public class EstuaryView extends JPanel{

	
	JFrame frame;
	int xLoc;
	int yLoc;
	
	PlayerPanel playerPanel;
	BuoyPanel buoyPanel;
	TimerPanel timerPanel;
	GameMessagePanel gameMessagePanel;
	SandBarPanel sandBarPanel;
	DockPanel dockPanel;
	
	EstuaryView(Model model){
		playerPanel = new PlayerPanel(model.player);
		buoyPanel = new BuoyPanel(model.buoy);
		timerPanel = new TimerPanel(model.timer);
		gameMessagePanel = new GameMessagePanel(model.gameMessage);
		sandBarPanel = new SandBarPanel(model.sandBar);
		dockPanel = new DockPanel(model.dock);
		
		setFocusable(true);
		
		this.frame = new JFrame();
		this.frame.add(this);
		
		this.setBackground(Color.BLUE);
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(model.width, model.height);
		this.frame.setVisible(true);
	}
	
	
	public void update(){
		this.repaint();
	}
	
	// all individual paint methods in central method
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		buoyPanel.paintComponent(g);
		playerPanel.paintComponent(g);
		timerPanel.paintComponent(g);
		gameMessagePanel.paintComponent(g);
		sandBarPanel.paintComponent(g);
		dockPanel.paintComponent(g);
		
    }
	
}
