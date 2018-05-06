import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class EstuaryPanel extends JPanel{
	private VesselPanel vesselPanel;
	private BuoyPanel buoyPanel;
	private TimerPanel timerPanel;
	private GameMessagePanel gameMessagePanel;
	private SandBarPanel sandBarPanel;
	private DockPanel dockPanel;
	WakePanel wp;
	ShorelinePanel slp;
	
	EstuaryPanel() {
		vesselPanel = new VesselPanel();
		buoyPanel = new BuoyPanel();
		timerPanel = new TimerPanel();
		gameMessagePanel = new GameMessagePanel();
		sandBarPanel = new SandBarPanel();
		dockPanel = new DockPanel();
		wp = new WakePanel();
		slp = new ShorelinePanel();
		this.setBackground(Color.CYAN.darker().darker());
	}
	
	public void update(Model model){
		buoyPanel.update(model.getBuoy().getXLoc(), model.getBuoy().getYLoc());
		dockPanel.update(model.getDock().getXLoc(), model.getDock().getYLoc());
		vesselPanel.update(model.getPlayer().getXLoc(), model.getPlayer().getYLoc(), model.getPlayer().getVesselType(), model.getPlayer().checkDirection());
		sandBarPanel.update(model);
		timerPanel.update(model.getTimer().message);
		
		gameMessagePanel.update(model.getGameMessage().message);
		wp.updateAll(model);
		slp.update(model.shoreline.xLoc, model.shoreline.yLoc);
		this.repaint();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		sandBarPanel.paintComponent(g);
		wp.paintComponent(g);
		dockPanel.paintComponent(g);
		vesselPanel.paintComponent(g);
		buoyPanel.paintComponent(g);
		timerPanel.paintComponent(g);
		gameMessagePanel.paintComponent(g);
		slp.paintComponent(g);
    }
}
