package main;

/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class SpeedBoat extends Vessel{
	/*Constructor for the SpeedBoat
	 * 
	 */
	public SpeedBoat(){
		super();
		type = VesselType.SPEEDBOAT;
		maxVel = 14;
		this.updatesBetweenWakes = 1;
	}
}