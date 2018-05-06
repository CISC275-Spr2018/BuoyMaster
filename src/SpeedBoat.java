
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class SpeedBoat extends Vessel{
	/*Constructor for the SpeedBoat
	 * 
	 */
	SpeedBoat(){
		super();
		type = VesselType.SPEEDBOAT;
		maxVel = 14;
		this.updatesBetweenWakes = 1;
	}
}
