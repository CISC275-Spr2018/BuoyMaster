import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Timer;

public class Controller implements ActionListener {
	private final int width = 1280;
	private final int height = 720;
	private final static int DRAWDELAY = 50;
	private Model model;
	private View view;
	GameKeyListener gkl;

	boolean start = false;

	public Controller(){
		model = new Model(width, height);
		view = new View(width, height);
		view.addKeyListener(gkl);

		view.selectionScreen.jetSki.addActionListener(this);
		view.selectionScreen.fishingBoat.addActionListener(this);
		view.selectionScreen.speedBoat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//sets the boat type based on the button pressed
		if (e.getSource() == view.selectionScreen.jetSki) {
			model.setVessel(new JetSki());
		}
		if (e.getSource() == view.selectionScreen.fishingBoat) {
			model.setVessel(new FishingBoat());
		}
		if (e.getSource() == view.selectionScreen.speedBoat) {
			model.setVessel(new SpeedBoat());
		}
		gkl = new GameKeyListener(model.getPlayer(), view);
		view.addKeyListener(gkl);
		start = true;
	}

	void update() {
		if (start && !model.gameOver) { //the game runs from start until gameOver is true
			model.modelUpdate();
			view.update(model); //this method should take something other than the entire model object //// TO DO!!!!!!!!
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				final Controller c = new Controller(); //Needs to be final or it won't work on my computer -Greg
				Timer t = new Timer(DRAWDELAY, new AbstractAction() {
					public void actionPerformed(ActionEvent e) {
						c.update();
						c.view.repaint();
					}
				});
				t.start();
			}
		});
	}
}
