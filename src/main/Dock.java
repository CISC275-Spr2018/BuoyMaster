package main;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class Dock extends GamePiece{
	boolean arrivedWithData = false;
	GameMessage gameMessage;
	boolean collected = false; // to be updated once the buoy collected is true
	/*Buoy constructor
	 * @param x this is the x position of dock in the frame
	 * @param y this is the y position of the dock in the frame
	 * @param g this is the gamemessage which appears when the user makes contact with the dock telling them they have returned with the data
	 * 	
	 */
	Dock(int x, int y, GameMessage g){
		this.xLoc = x;
		this.yLoc = y;
		this.velocity = 0;
		gameMessage = g;
	}
	/*
	 * (non-Javadoc)
	 * @see Collidable#onCollide()
	 */
	@Override
	public void onCollide() {
		if (collected) {
			arrivedWithData = true;
			gameMessage.message = "You have successfully returned the data!";
		}
	}

	
	public void dataCollected(boolean buoyStatus){
		collected = buoyStatus;
	}
}