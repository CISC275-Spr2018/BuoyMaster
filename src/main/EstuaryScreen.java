package main;
import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.JPanel;
/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class EstuaryScreen extends JPanel{
	private VesselPanel vesselPanel;
	private BuoyPanel buoyPanel;
	private TimerPanel timerPanel;
	private GameMessagePanel gameMessagePanel;
	private SandBarPanel sandBarPanel;
	private DockPanel dockPanel;
	WakePanel wp;
	ShorelinePanel slp;
	/**Constructor for the EstuaryScreen class
	 * 
	 */
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
	/**Updates the view based on the model
	 * @param bX x coordinate of buoy
	 * @param bY y coordinate of buoy
	 * @param dX x coordinate of dock
	 * @param dY y coordinate of dock
	 * @param pX x coordinate of player
	 * @param pY y coordinate of player
	 * @param vessel the type of boat the user selected
	 * @param sbc passes in the SandBarCollection necessary for making sandbars
	 * @param timerMessage passes in the time left on the timer
	 * @param message creates the game message depending on if the user collected data or not
	 * @param wc passes in the WakeCollection of the model in order to create wake behind the boat 
	 * @param sLX x coordinate of the shore line
	 * @param sLY y coordinate of the shore line
	 * @param rotationAngle rotation angle of vessel
 	 */
	public void update(int bX, int bY, int dX, int dY, int pX, int pY, VesselType vessel, double rotationAngle, SandBarCollection sbc, String timerMessage, String message, WakeCollection wc, int sLX, int sLY){
		buoyPanel.update(bX, bY);
		dockPanel.update( dX, dY);
		vesselPanel.update(pX, pY, vessel, rotationAngle);
		sandBarPanel.update(sbc);
		timerPanel.update(timerMessage);
		gameMessagePanel.update(message);
		slp.update(sLX, sLY);
		wp.setWakeCollection(wc);
		this.repaint();
	}
	public TimerPanel getTimerPanel(){
		return timerPanel;
	}
	/**
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		sandBarPanel.paintComponent(g);
		dockPanel.paintComponent(g);
		buoyPanel.paintComponent(g);
		timerPanel.paintComponent(g);
		gameMessagePanel.paintComponent(g);
		slp.paintComponent(g);
		wp.paintComponent(g); // May be pointless
		vesselPanel.paintComponent(g);
    }
}