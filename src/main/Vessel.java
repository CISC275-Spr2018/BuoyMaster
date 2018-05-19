package main;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public abstract class Vessel extends GamePiece implements Serializable{
	private double maxVel;
	double acceleration;
	double turnRate; //The rate at which the boat will turn.
	VesselType type;
	private WakeCollection wakes;
	double wakeStrength;
	/*Constructor for the vessel class
	 * 
	 */
	Vessel(){
		setMaxVel(0);
		rotationAngle = 0; //Boat starts still, facing east.
		this.xLoc = 0;
		this.yLoc = 300; // Starts 300 pixels south of origin
		setWakes(new WakeCollection());
	}
	
	public double getWakeStrength() {
		return this.wakeStrength;
	}
	
	/**Updates aspects of the vessel the user selected
	 * 
	 */

	public void update(int x, int y) {
		if(getxVel() > 0.1 || getxVel() < -0.1 || getyVel() > 0.1 || getyVel() < -0.1){ //Adds no wake if velocity is near 0
			getWakes().addWake(this.xLoc + 48, this.yLoc + 48, this.wakeStrength, this.rotationAngle); //48 is half size of boat immage
		}
		getWakes().update();
		if (outOfXBounds(x)) {
			this.setxVel(-this.getxVel());
		}
		if (outOfYBounds(y)) {
			this.setyVel(-this.getyVel());
		}
		super.updateLocationAndRotation();
	}
	
	public boolean outOfXBounds(int x) {
		return this.xLoc < 0 || this.xLoc + 95 > x; //Should be a collision range or something rather than 95
	}
	public boolean outOfYBounds(int y) {
		return this.yLoc < 0 || this.yLoc +95 > y;
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

	public double getMaxVel() {
		return maxVel;
	}

	public void setMaxVel(double maxVel) {
		this.maxVel = maxVel;
	}

	public WakeCollection getWakes() {
		return wakes;
	}

	public void setWakes(WakeCollection wakes) {
		this.wakes = wakes;
	}
	
}