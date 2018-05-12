package main;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public abstract class Vessel extends GamePiece{
	int maxVel;
	Direction dir = Direction.EAST;
	VesselType type;
	WakeCollection wakes;
	int updatesBetweenWakes = 3; //How many times the model is updated between a wake being emitted behind the vessel
	/*Constructor for the vessel class
	 * 
	 */
	Vessel(){
		maxVel = 0;
		this.xLoc = 0;
		this.yLoc = 300;
		wakes = new WakeCollection();
	}
	/*Updates aspects of the vessel the user selected
	 * 
	 */
	void update() {
		wakes.removeDeadWakes();
		wakes.addWake(this.xLoc, this.yLoc, -this.xVel, -this.yVel, this.updatesBetweenWakes);
		wakes.update();
		super.updateLocation();
	}
	
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