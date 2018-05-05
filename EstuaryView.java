import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/*
 * Main View class for the game.
 * Will hold all different Panels of objects - PlayerPanel, BuoyPanel, etc.
 */
public class EstuaryView extends JFrame{
	private final int width;
	private final int height;
	
	/*
	private JFrame frame;
	private VesselPanel vesselPanel;
	private BuoyPanel buoyPanel;
	private TimerPanel timerPanel
	private GameMessagePanel gameMessagePanel;
	private SandBarPanel sandBarPanel;
	private DockPanel dockPanel;
	WakePanel wp;
	*/
	EstuaryPanel estuaryPanel;
	StartScreen startScreen;
	SelectionScreen selectionScreen;
	FactScreen factScreen;
	JLayeredPane layers;
	
	EstuaryView(int width, int height){
		this.width = width;
		this.height = height;
		estuaryPanel = new EstuaryPanel();
		startScreen = new StartScreen(this);
		selectionScreen = new SelectionScreen(this);
		factScreen = new FactScreen();
		layers = new JLayeredPane();
		
		factScreen.setBounds(500, 500, 250, 250);
		estuaryPanel.add(factScreen);
		
		factScreen.setVisible(false);
		
		estuaryPanel.setBounds(0, 0, 1000, 1000);
		startScreen.setBounds(0, 0, 1000, 1000);
		selectionScreen.setBounds(0, 0, 1000, 1000);
		layers.add(estuaryPanel, new Integer(1), 2);
	    layers.add(startScreen, new Integer(1), 0);
	    layers.add(selectionScreen, new Integer(1), 1);
		
		setFocusable(true);
		
		this.add(layers);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setVisible(true);
	}
	
	/*
	// update all panels
	public void update(Model model){
		buoyPanel.update(model.getBuoy().getXLoc(), model.getBuoy().getYLoc());
		dockPanel.update(model.getDock().getXLoc(), model.getDock().getYLoc());
		vesselPanel.update(model.getPlayer().getXLoc(), model.getPlayer().getYLoc(), model.getPlayer().checkDirection());
		sandBarPanel.update(model);
		timerPanel.update(model.getTimer().message);
		gameMessagePanel.update(model.getGameMessage().message);
		wp.updateAll(model);
		this.repaint();
	}
	*/
	public void update(Model model){
		estuaryPanel.update(model);
		factScreen.setVisible(model.getBuoy().hasCollided(model.getPlayer()));
	}
	
	/*
	// all individual paint methods in central method
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		buoyPanel.paintComponent(g);
		wp.paintComponent(g);
		vesselPanel.paintComponent(g);
		timerPanel.paintComponent(g);
		gameMessagePanel.paintComponent(g);
		sandBarPanel.paintComponent(g);
		dockPanel.paintComponent(g);
    }
    */
	
}
