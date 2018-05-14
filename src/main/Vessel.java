package main;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public abstract class Vessel extends GamePiece implements Serializable{
	double maxVel;
	double acceleration;
	double turnRate; //The rate at which the boat will turn.
	VesselType type;
	WakeCollection wakes;
	double wakeStrength = 10;
	/*Constructor for the vessel class
	 * 
	 */
	Vessel(){
		maxVel = 0;
		rotationAngle = 0; //Boat starts still, facing east.
		this.xLoc = 0;
		this.yLoc = 300;
		wakes = new WakeCollection();
	}
	/**Updates aspects of the vessel the user selected
	 * 
	 */

	void update(int x, int y) {
		if(xVel > 0.1 || xVel < -0.1 || yVel > 0.1 || yVel < -0.1){ //Adds no wake if velocity is near 0
			wakes.addWake(this.xLoc + 48, this.yLoc + 48, this.wakeStrength, this.rotationAngle); //48 is half size of boat immage
		}
		wakes.update();
    if (outOfXBounds(x)) {
			this.xVel = -this.xVel;
		}
		if (outOfYBounds(y)) {
			this.yVel = -this.yVel;
		}
		super.updateLocationAndRotation();
	}
	
	boolean outOfXBounds(int x) {
		return this.xLoc < 0 || this.xLoc > x;
	}
	boolean outOfYBounds(int y) {
		return this.yLoc < 0 || this.yLoc > y;
	}
	
	/*
	 * (non-Javadoc)
	 * @see Collidable#onCollide()
	 */
	@Override
	public void onCollide() {
		// TODO Auto-generated method stub
	}
	/**@return returns the VesselType the user selected
	 * 
	 */
	public VesselType getVesselType(){
		return type;
	}
	
}