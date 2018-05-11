package main;

/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class JetSki extends Vessel{
	/*Constructor for the jet ski boat
	 * 
	 */
	JetSki(){
		super();
		type = VesselType.JETSKI;
		maxVel = 10;
		this.updatesBetweenWakes = 2;
	}
}