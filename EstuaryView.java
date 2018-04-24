import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Main View class for the game.
 * Will hold all different Panels of objects - PlayerPanel, BuoyPanel, etc.
 */
public class EstuaryView extends JPanel{
	private final int width;
	private final int height;
	private JFrame frame;
	
	private VesselPanel vesselPanel;
	private BuoyPanel buoyPanel;
	private TimerPanel timerPanel;
	private GameMessagePanel gameMessagePanel;
	private SandBarPanel sandBarPanel;
	private DockPanel dockPanel;
	
	EstuaryView(int width, int height){
		this.width = width;
		this.height = height;
		vesselPanel = new VesselPanel();
		buoyPanel = new BuoyPanel();
		timerPanel = new TimerPanel();
		gameMessagePanel = new GameMessagePanel();
		sandBarPanel = new SandBarPanel();
		dockPanel = new DockPanel();
		
		setFocusable(true);
		
		this.frame = new JFrame();
		this.frame.add(this);
		
		this.setBackground(Color.CYAN.darker().darker());
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(width, height);
		this.frame.setVisible(true);
	}
	
	// update all panels
	public void update(Model model){
		buoyPanel.update(model.getBuoy().getXLoc(), model.getBuoy().getYLoc());
		dockPanel.update(model.getDock().getXLoc(), model.getDock().getYLoc());
		vesselPanel.update(model.getPlayer().getXLoc(), model.getPlayer().getYLoc(), model.getPlayer().checkDirection());
		sandBarPanel.update(model.getSandBar().getXLoc(), model.getSandBar().getYLoc());
		timerPanel.update(model.getTimer().message);
		gameMessagePanel.update(model.getGameMessage().message);
		this.repaint();
	}
	
	// all individual paint methods in central method
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		buoyPanel.paintComponent(g);
		vesselPanel.paintComponent(g);
		timerPanel.paintComponent(g);
		gameMessagePanel.paintComponent(g);
		sandBarPanel.paintComponent(g);
		dockPanel.paintComponent(g);
		
    }
	
}
