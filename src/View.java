import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

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
	public void update(int bX, int bY, int dX, int dY, int pX, int pY, VesselType vessel, Direction direction, SandBarCollection sbc, String message, String timerMessage, WakeCollection wc, int sLX, int sLY){ //this method should take something other than the entire model object //// TO DO!!!!!!!!
		estuaryScreen.update( bX,  bY,  dX,  dY,  pX,  pY,  vessel,  direction,  sbc,  message,  timerMessage,  wc,  sLX,  sLY);
		//factScreen.setVisible(model.getBuoy().hasCollided(model.getPlayer()));
	}
}
