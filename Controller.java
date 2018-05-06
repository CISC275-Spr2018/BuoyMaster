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
		// boats start in different positions to test if the buttons actually work
		if (e.getSource() == view.selectionScreen.jetSki) {
			model.setVessel(new Jetski());
		}
		if (e.getSource() == view.selectionScreen.fishingBoat) {
			model.setVessel(new FishingBoat());
		}
		if (e.getSource() == view.selectionScreen.speedBoat) {
			model.setVessel(new Speedboat());
		}
		gkl = new GameKeyListener(model.getPlayer(), view);
		view.addKeyListener(gkl);
		start = true;
	}
	
	void update() {
		if (start && !model.gameOver) {
			view.layers.moveToFront(view.estuaryPanel);
			model.modelUpdate();
			view.update(model);
		}
	}
	
	public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable(){
			public void run(){
				final Controller c = new Controller();
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
