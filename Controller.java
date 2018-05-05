import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Timer;

public class Controller implements ActionListener {
	private final int width = 1920;
	private final int height = 1080;
	private final static int DRAWDELAY = 50;
	private Model model;
	private EstuaryView EView;
	GameKeyListener gkl;
	
	boolean start = false;
	
	public Controller(){
		model = new Model(width, height);
		EView = new EstuaryView(width, height);
		EView.addKeyListener(gkl);
		
		EView.selectionScreen.boat1.addActionListener(this);
		EView.selectionScreen.boat2.addActionListener(this);
		EView.selectionScreen.boat3.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// boats start in different positions to test if the buttons actually work
		if (e.getSource() == EView.selectionScreen.boat1) {
			model.setVessel(new Speedboat());
		}
		if (e.getSource() == EView.selectionScreen.boat2) {
			model.setVessel(new Jetski());
		}
		if (e.getSource() == EView.selectionScreen.boat3) {
			model.setVessel(new FishingBoat());
		}
		gkl = new GameKeyListener(model.getPlayer(), EView);
		EView.addKeyListener(gkl);
		start = true;
	}
	
	void update() {
		if (start) {
			EView.layers.moveToFront(EView.estuaryPanel);
			model.modelUpdate();
			EView.update(model);
		}
	}
	
	public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable(){
			public void run(){
				Controller c = new Controller();
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
