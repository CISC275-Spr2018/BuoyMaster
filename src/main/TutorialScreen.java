package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TutorialScreen extends JPanel {
	private VesselPanel vesselPanel;
	private BuoyPanel buoyPanel;
	private DockPanel dockPanel;
	private SandBarPanel sandBarPanel;
	private ArrowPanel arrowPanel;
	WakePanel wp;
	ShorelinePanel slp;
	
	TutorialScreen(){
		vesselPanel = new VesselPanel();
		buoyPanel = new BuoyPanel();
		sandBarPanel = new SandBarPanel();
		dockPanel = new DockPanel();
		wp = new WakePanel();
		slp = new ShorelinePanel();
		arrowPanel=new ArrowPanel();
		
		this.setBackground(Color.CYAN.darker().darker());
	}
	public void update(int bX, int bY, int dX, int dY, int pX, int pY, VesselType vessel, Direction direction, SandBarCollection sbc,  WakeCollection wc, int sLX, int sLY){
		buoyPanel.update(bX, bY);
		dockPanel.update( dX, dY);
		vesselPanel.update(pX, pY, vessel, direction);
		sandBarPanel.update(sbc);
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
		slp.paintComponent(g);
    }
}

