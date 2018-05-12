package main;
import java.awt.image.BufferedImage;

import java.awt.image.BufferedImage;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class Wake extends GamePiece{
	int wakeLife = 20; // wake will stay around for 20 updates

	
	Wake(int x, int y, double velocity, double rotationAngle){
		this.xLoc = x;
		this.yLoc = y;
		this.velocity = velocity;
		this.rotationAngle = rotationAngle;
	}
	
	@Override
	public void onCollide() {
		//nothing happens when a wake collides with another game object
	}
}