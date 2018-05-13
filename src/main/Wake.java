package main;
import java.awt.image.BufferedImage;

import java.awt.image.BufferedImage;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class Wake extends GamePiece{
	double wakeStrength;
	int wakeLife; // the number of updates that the wake will last
	float opacity = 1f; //fade starts at 1 and will go to 0;

	
	Wake(int x, int y, double wakeStrength, double rotationAngle){
		this.wakeStrength = wakeStrength;
		this.xLoc = x;
		this.yLoc = y;
		this.wakeLife = (int) wakeStrength; //TEMPORARY VALUE  should be a function of strength and then decrement
		this.rotationAngle = rotationAngle;
	}
	
	//updates the location, decreases opacity and wakeLife
	void update(){
		opacity -= (float)(1.0/(wakeStrength + 1));
		wakeLife--;
	}
	
	@Override
	public void onCollide() {
		//nothing happens when a wake collides with another game object
	}
}