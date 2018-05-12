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
		this.acceleration = 2;
		this.turnRate = 6; //degrees turned per update (should be a factor of 360)
		this.updatesBetweenWakes = 1;
	}
}