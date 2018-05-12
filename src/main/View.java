package main;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
/*
 * Main View class for the game.
 * Will hold all different Panels of objects - PlayerPanel, BuoyPanel, etc.
 */
public class View extends JFrame{
	EstuaryScreen estuaryScreen;
	StartScreen startScreen;
	SelectionScreen selectionScreen;
	FactScreen factScreen;
	JLayeredPane layers;
	/*Constructor for the view 
	 * @param width width of screen
	 * @param height height of screen
	 */
	View(int width, int height){
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		startScreen = new StartScreen();
		startScreen.setBackground(Color.CYAN.darker().darker());
		selectionScreen = new SelectionScreen();
		estuaryScreen = new EstuaryScreen();
		estuaryScreen.setBackground(Color.CYAN.darker().darker());
		startScreen.setBackground(Color.CYAN.darker().darker());
		layers = new JLayeredPane();
		
		//factScreen = new FactScreen();
		//factScreen.setBounds(500, 500, 250, 250);
		//estuaryScreen.add(factScreen);
		//factScreen.setVisible(false);
		
		startScreen.setBounds(0, 0, width, height); // Sets the size of each of the screens
		selectionScreen.setBounds(0, 0, width, height);
		estuaryScreen.setBounds(0, 0, width, height);
		
	    layers.add(startScreen, 1, 0); //Not certain why an integer is needed as a constraint but it is.
	    layers.add(selectionScreen, 1, 1);
	    layers.add(estuaryScreen, 1, 2);
		this.add(layers);
		
		this.setVisible(true);
	}
	
	/*Updates the view based on model input 
	 *  @param bX x coordinate of buoy
	 * @param bY y coordinate of buoy
	 * @param dX x coordinate of dock
	 * @param dY y coordinate of dock
	 * @param pX x coordinate of player
	 * @param pY y coordinate of player
	 * @param vessel the type of boat the user selected
	 * @param direction indicates the direction in which the users are moving
	 * @param sbc passes in the SandBarCollection necessary for making sandbars
	 * @param timerMessage passes in the time left on the timer
	 * @param message creates the game message depending on if the user collected data or not
	 * @param wc passes in the WakeCollection of the model in order to create wake behind the boat 
	 * @param sLX x coordinate of the shore line
	 * @param sLY y coordinate of the shore line
	 * 
	 */
	public void update(int bX, int bY, int dX, int dY, int pX, int pY, VesselType vessel, double drawAngle, SandBarCollection sbc, String message, String timerMessage, WakeCollection wc, int sLX, int sLY){ //this method should take something other than the entire model object //// TO DO!!!!!!!!
		estuaryScreen.update( bX,  bY,  dX,  dY,  pX,  pY,  vessel,  drawAngle,  sbc,  message,  timerMessage,  wc,  sLX,  sLY);
		//factScreen.setVisible(model.getBuoy().hasCollided(model.getPlayer()));
	}
}