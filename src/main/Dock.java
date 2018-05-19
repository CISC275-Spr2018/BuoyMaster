package main;

import javax.swing.JOptionPane;

/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class Dock extends GamePiece{
	boolean arrivedWithData = false;
	GameMessage gameMessage;
	boolean collected = false; // to be updated once the buoy collected is true
	boolean tutorial=true;
	boolean tutorialShow=true;
	boolean showStart=true;
	boolean mt=true;
	int reply;
	/**Buoy constructor
	 * @param x this is the x position of dock in the frame
	 * @param y this is the y position of the dock in the frame
	 * @param g this is the gamemessage which appears when the user makes contact with the dock telling them they have returned with the data
	 * 	
	 */
	Dock(int x, int y, GameMessage g){
		this.xLoc = x;
		this.yLoc = y;
		this.setxVel(0);
		this.setyVel(0);
		gameMessage = g;
	}
	public void setTutorial(boolean b){
		this.tutorial=b;
	}
	public boolean getTutorial(){
		return this.tutorial;
	}
	/**
	 * (non-Javadoc)
	 * @see Collidable#onCollide()
	 */
	@Override
	public void onCollide() {
		if (tutorial){
			if (showStart){
				 mt=false;
				
				}
			}

		
		if(!tutorial){
			if (collected) {
				arrivedWithData = true;
				gameMessage.message = "You have successfully returned the data!";
			}
		}
	
	}
	/**@param buoyStatus tells dock whether or not data has been collected
	 * 
	 */
	public void dataCollected(boolean buoyStatus){
		collected = buoyStatus;
	}
}