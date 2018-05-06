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
		selectionScreen = new SelectionScreen();
		estuaryScreen = new EstuaryScreen();
		
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
	public void update(Model model){ //this method should take something other than the entire model object //// TO DO!!!!!!!!
		estuaryScreen.update(model);
		//factScreen.setVisible(model.getBuoy().hasCollided(model.getPlayer()));
	}
}
