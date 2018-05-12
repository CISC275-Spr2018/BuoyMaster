package main;
import java.awt.image.BufferedImage;

import java.awt.image.BufferedImage;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class Wake extends GamePiece{
	int wakeLife = 20; // wake will staty around for 20 updates
	/*Constructor for the Wake Class
	 * @param x x coordinate of wake
	 * @param y y coordinate of wake
	 * @param xv x velocity of wake
	 * @param yv y velocity of wake
	 */
	Wake(int x, int y, double velocity, double rotationAngle){
		this.xLoc = x;
		this.yLoc = y;
		this.velocity = velocity;
		this.rotationAngle = rotationAngle;
	}
	/*Updates the position and decrements the life of each wake
	 * 
	 */
	void update() {
		super.updateLocation();
		wakeLife--;
	}
	/*@return returns the direction of the wake
	 * 
	 */
	/*
	 * (non-Javadoc)
	 * @see Collidable#onCollide()
	 */
	@Override
	public void onCollide() {
		//nothing happens when a wake collides with another game object
	}
}