package main;

import java.io.Serializable;

/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class FishingBoat extends Vessel implements Serializable{
	/*Constructor for the fishing boat
	 * 
	 */
	FishingBoat() {
		super();
		type = VesselType.FISHINGBOAT;
		maxVel = 5;
		this.updatesBetweenWakes = 5;
	}

}