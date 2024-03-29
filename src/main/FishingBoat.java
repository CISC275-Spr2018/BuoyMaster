package main;

import java.io.Serializable;

/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class FishingBoat extends Vessel implements Serializable{
	/**Constructor for the fishing boat
	 * 
	 */
	public FishingBoat() {
		super();
		type = VesselType.FISHINGBOAT;
		setMaxVel(5);
		this.acceleration = 2;
		this.turnRate = 10; //degrees turned per update (should be a factor of 360)
		this.wakeStrength = 6;
	}

}