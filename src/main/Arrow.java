package main;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class Arrow extends GamePiece {
	boolean atBuoy = true;
	boolean atDock = false;
	/**
	 * 
	 * @param x location of arrow x
	 * @param y location of arrow y
	 */
	Arrow(int x, int y){
		this.xLoc=x;
		this.yLoc=y;
		this.xVel=0;
		this.yVel=0;
	}
	/**
	 * 
	 */
	@Override
	public void onCollide() {
		//Nothing happens if you collide with the arrow
	}
	
	/**
	 * sets the locations from buoy and dock
	 */
	public void goToDock(){
		atBuoy = false;
		atDock = true;
	}
}
