package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class TutorialScreen extends JPanel implements ActionListener {
	private VesselPanel vesselPanel;
	private BuoyPanel buoyPanel;
	private DockPanel dockPanel;
	private ArrowPanel arrowPanel;
	private SandBarPanel sandBarPanel;
	private GameMessagePanel gameMessagePanel;
	WakePanel wp;
	/**Constructor for the Tutorial view
	 * 
	 */
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
	/**Updates the view based on model input 
	 *  @param bX x coordinate of buoy
	 * @param bY y coordinate of buoy
	 * @param dX x coordinate of dock
	 * @param dY y coordinate of dock
	 * @param pX x coordinate of player
	 * @param pY y coordinate of player
	 * @param vessel the type of boat the user selected
	 * @param direction indicates the direction in which the users are moving
	 * @param sbc passes in the SandBarCollection necessary for making sandbars
	 * @param message creates the game message depending on if the user collected data or not
	 * @param wc passes in the WakeCollection of the model in order to create wake behind the boat 
	 * @param aX arrow x coordinate
	 * @param aY arrow y coordinate
	 */
	public void update(int bX, int bY, int dX, int dY, int pX, int pY, VesselType vessel, double rotationAngle, SandBarCollection sbc,String message,  WakeCollection wc, int sLX, int sLY, int aX, int aY){
		buoyPanel.update(bX, bY);
		dockPanel.update( dX, dY);
		vesselPanel.update(pX, pY, vessel, rotationAngle);
		wp.update();
		sandBarPanel.update(sbc);
		arrowPanel.update(aX,aY);
		gameMessagePanel.update("Use the arrow keys to guide yourself through the estuary.");
		this.repaint();
	}
	/**
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		arrowPanel.paintComponent(g);
		wp.paintComponent(g);
		dockPanel.paintComponent(g);		
		gameMessagePanel.paintComponent(g);
		vesselPanel.paintComponent(g);
		buoyPanel.paintComponent(g);
		sandBarPanel.paintComponent(g);
		
    }
	/**
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false); //The StartScreen disappears when the button is pressed
	}
}

