package main;

/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class FishingBoat extends Vessel{
	/*Constructor for the fishing boat
	 * 
	 */
	FishingBoat() {
		super();
		type = VesselType.FISHINGBOAT;
		maxVel = 5;
		this.acceleration = 2;
		this.turnRate = 10; //degrees turned per update (should be a factor of 360)
		this.wakeStrength = 8;
	}

}