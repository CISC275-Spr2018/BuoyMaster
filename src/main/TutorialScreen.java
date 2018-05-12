package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TutorialScreen extends JPanel implements ActionListener {
	private VesselPanel vesselPanel;
	private BuoyPanel buoyPanel;
	private DockPanel dockPanel;
	private ArrowPanel arrowPanel;
	private SandBarPanel sandBarPanel;
	private GameMessagePanel gameMessagePanel;
	JButton b1;
	WakePanel wp;
	
	TutorialScreen(){
		vesselPanel = new VesselPanel();
		buoyPanel = new BuoyPanel();
		dockPanel = new DockPanel();
		sandBarPanel=new SandBarPanel();
		gameMessagePanel=new GameMessagePanel();
		wp = new WakePanel();
		arrowPanel=new ArrowPanel();
		this.setBackground(Color.CYAN.darker().darker());
	
	}
	public void update(int bX, int bY, int dX, int dY, int pX, int pY, VesselType vessel, Direction direction, SandBarCollection sbc,  WakeCollection wc, int sLX, int sLY, int aX, int aY){
		buoyPanel.update(bX, bY);
		dockPanel.update( dX, dY);
		vesselPanel.update(pX, pY, vessel, direction);
		wp.updateAll(wc);
		sandBarPanel.update(sbc);
		arrowPanel.update(aX,aY);
		this.repaint();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		arrowPanel.paintComponent(g);
		wp.paintComponent(g);
		dockPanel.paintComponent(g);
		vesselPanel.paintComponent(g);
		buoyPanel.paintComponent(g);
		sandBarPanel.paintComponent(g);
		
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false); //The StartScreen disappears when the button is pressed
	}
}

