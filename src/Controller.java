
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Controller implements ActionListener, Serializable{
	private final int width = 1280;
	private final int height = 720;
	private final static int DRAWDELAY = 50;
	int reply;
	boolean restart=true;
	private Model model;
	private View view;
	GameKeyListener gkl;

	boolean start = false;
/*Constructor for the Controller class
 * 
 */
	public Controller(){
		model = new Model(width, height);
		view = new View(width, height);
		view.addKeyListener(gkl);

		view.selectionScreen.jetSki.addActionListener(this);
		view.selectionScreen.fishingBoat.addActionListener(this);
		view.selectionScreen.speedBoat.addActionListener(this);
	}
	public Model getModel(){
		return model;
	}
/*
 * (non-Javadoc)
 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
 */
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
	/*Updates the model and the view based on the updates which happened in the model
	 * 
	 */
	void update() {
		if (start && !model.gameOver) { //the game runs from start until gameOver is true
			model.modelUpdate();
			view.update(model.getBuoy().getXLoc(), model.getBuoy().getYLoc(),model.getDock().getXLoc(),model.getDock().getYLoc(),model.getPlayer().getXLoc(),model.getPlayer().getYLoc(),model.getPlayer().getVesselType(),model.getPlayer().getRotationAngle(),model.sandBarCollection,model.getTimer().message,model.getGameMessage().message,model.getPlayer().wakes,model.shoreline.getXLoc(),model.shoreline.getYLoc(), model.getPlayer().dir);
		}
		if (start && model.addTime){
			model.getTimer().increment();
		}
		if(model.gameOver){
			reply=JOptionPane.showConfirmDialog(null,"Would you like to retry?","Restart",reply);
				 
			if(reply==JOptionPane.YES_OPTION){
				model.gameOver=!model.gameOver;
				Controller c = new Controller();
				model = new Model(width, height);
				view = new View(width, height);
				c.model=model;
				c.view=view;
				c.view.addKeyListener(gkl);

				c.model.getPlayer().type=null;
				c.view.selectionScreen.jetSki.addActionListener(this);
				c.view.selectionScreen.fishingBoat.addActionListener(this);
				c.view.selectionScreen.speedBoat.addActionListener(this);
				
				
			}
			if(reply==JOptionPane.NO_OPTION){
				System.exit(0);
			}
		}
	} 
/*Main method starts the run method for the event queue 
 * 
 */
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
	public static void maine(String[] args) {
		
	}
}