package main;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
	boolean tutorial=true;

	boolean start = false;
/*Constructor for the Controller class
 * 
 */
	public Controller(){
		model = new Model(width, height,true);
		view = new View(width, height);
		view.addKeyListener(gkl);
		
		view.selectionScreen.jetSki.addActionListener(this);
		view.selectionScreen.fishingBoat.addActionListener(this);
		view.selectionScreen.speedBoat.addActionListener(this);
	}
	public Model getModel(){
		return model;
	}
	public View getView(){
		return view;
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
			view.update(model.getBuoy().getXLoc(), model.getBuoy().getYLoc(),model.getDock().getXLoc(),model.getDock().getYLoc(),model.getPlayer().getXLoc(),model.getPlayer().getYLoc(),model.getPlayer().getVesselType(),model.getPlayer().checkDirection(),model.sandBarCollection,model.getTimer().message,model.getGameMessage().message,model.getPlayer().wakes,model.shoreline.getXLoc(),model.shoreline.getYLoc(),model.getArrow().getXLoc(),model.getArrow().getYLoc());
		}
		//if the dock indicates the player has returned from buoy in tutorial
		if(!model.getDock().mt){
			JButton b=new JButton("Click here if you are ready to be a Buoy Master");
			b.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					model.getPlayer().xLoc=0;
					model.getPlayer().yLoc=300;
					model.getPlayer().xVel=0;
					model.getPlayer().yVel=0;
					model.sandBarCollection=new SandBarCollection();
					model.tutorial=false;
					
					view.setLayer(3);
					
					
					
				}
			});
			JPanel panel=new JPanel();
			panel.add(b);	
			Object[] options={b};
			if(tutorial){
				tutorial=false;
				int result=JOptionPane.showOptionDialog(null, panel, "Start Game", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

		}
		if (start && model.addTime){
			model.getTimer().increment();
		}
		if(model.gameOver){
			reply=JOptionPane.showConfirmDialog(null,"Would you like to retry?","Restart",reply);
				
			if(reply==JOptionPane.YES_OPTION){
				model=new Model(width, height,false);
				
			}
			if(reply==JOptionPane.NO_OPTION){
				System.exit(0);
			}
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
}