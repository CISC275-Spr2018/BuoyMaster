package main;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public abstract class Vessel extends GamePiece{
	double maxVel;
	double acceleration;
	double turnRate; //The rate at which the boat will turn.
	VesselType type;
	WakeCollection wakes;
	int updatesBetweenWakes = 3; //How many times the model is updated between a wake being emitted behind the vessel
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
	/*Updates aspects of the vessel the user selected
	 * 
	 */
	void update() {
		wakes.addWake(this.xLoc, this.yLoc, -this.velocity, this.rotationAngle, this.updatesBetweenWakes); //wakeVelocity set to opposite of boat velocity
		wakes.update();
		super.updateLocation();
	}
	
	/*@return returns the current direction the user is going in 
	 * 
	 */
	
	/*
	 * (non-Javadoc)
	 * @see Collidable#onCollide()
	 */
	@Override
	public void onCollide() {
		// TODO Auto-generated method stub
	}
	/*@return returns the VesselType the user selected
	 * 
	 */
	public VesselType getVesselType(){
		return type;
	}
	
}