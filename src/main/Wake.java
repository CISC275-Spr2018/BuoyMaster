package main;
import java.awt.image.BufferedImage;

import java.awt.image.BufferedImage;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class Wake extends GamePiece{
	final int originalWakeLife = 20;
	int wakeLife; // the number of updates that the wake will last
	float opacity = 1f; //fade starts at 1 and will go to 0;

	
	Wake(int x, int y, double velocity, double rotationAngle){
		this.xLoc = x;
		this.yLoc = y;
		this.wakeLife = originalWakeLife;//4*(int)Math.abs(velocity); //wakeLife dependent on the velocity of the vessel
		this.rotationAngle = rotationAngle;
	}
	
	//updates the location, decreases opacity and wakeLife
	void update(){
		updateLocation();
		opacity -= (float)(1.0/(originalWakeLife+1));
		wakeLife--;
	}
	
	
	
	@Override
	public void onCollide() {
		//nothing happens when a wake collides with another game object
	}
}