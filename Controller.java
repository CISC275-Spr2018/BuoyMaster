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
	private EstuaryView EView;
	GameKeyListener gkl;
	
	boolean start = false;
	
	public Controller(){
		model = new Model(width, height);
		EView = new EstuaryView(width, height);
		EView.addKeyListener(gkl);
		
		EView.selectionScreen.jetSki.addActionListener(this);
		EView.selectionScreen.fishingBoat.addActionListener(this);
		EView.selectionScreen.speedBoat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// boats start in different positions to test if the buttons actually work
		if (e.getSource() == EView.selectionScreen.jetSki) {
			model.setVessel(new Jetski());
		}
		if (e.getSource() == EView.selectionScreen.fishingBoat) {
			model.setVessel(new FishingBoat());
		}
		if (e.getSource() == EView.selectionScreen.speedBoat) {
			model.setVessel(new Speedboat());
		}
		gkl = new GameKeyListener(model.getPlayer(), EView);
		EView.addKeyListener(gkl);
		start = true;
	}
	
	void update() {
		if (start && !model.gameOver) {
			EView.layers.moveToFront(EView.estuaryPanel);
			model.modelUpdate();
			EView.update(model);
		}
	}
	
	public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable(){
			public void run(){
				final Controller c = new Controller();
				Timer t = new Timer(DRAWDELAY, new AbstractAction() {
					public void actionPerformed(ActionEvent e) {
						c.update();
						c.EView.repaint();
					}
				});
				t.start();
			}
		});
    }
}
