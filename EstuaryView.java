import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

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
		
		estuaryPanel.setBounds(0, 0, width, height);
		startScreen.setBounds(0, 0, width, height);
		selectionScreen.setBounds(0, 0, width, height);
		layers.add(estuaryPanel, new Integer(1), 2);
	    layers.add(startScreen, new Integer(1), 0);
	    layers.add(selectionScreen, new Integer(1), 1);
		
		setFocusable(true);
		
		this.add(layers);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setVisible(true);
	}
	public void update(Model model){
		estuaryPanel.update(model);
		factScreen.setVisible(model.getBuoy().hasCollided(model.getPlayer()));
	}
	
}
