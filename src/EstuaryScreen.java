import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class EstuaryScreen extends JPanel{
	private VesselPanel vesselPanel;
	private BuoyPanel buoyPanel;
	private TimerPanel timerPanel;
	private GameMessagePanel gameMessagePanel;
	private SandBarPanel sandBarPanel;
	private DockPanel dockPanel;
	WakePanel wp;
	ShorelinePanel slp;
	
	EstuaryScreen() {
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
	
	public void update(int bX, int bY, int dX, int dY, int pX, int pY, VesselType vessel, Direction direction, SandBarCollection sbc, String message, String timerMessage, WakeCollection wc, int sLX, int sLY){
		buoyPanel.update(bX, bY);
		dockPanel.update( dX, dY);
		vesselPanel.update(pX, pY, vessel, direction);
		sandBarPanel.update(sbc);
		timerPanel.update(timerMessage);
		gameMessagePanel.update(message);
		wp.updateAll(wc);
		slp.update(sLX, sLY);
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
