package main;

public class SpeedBoat extends Vessel{
	
	public SpeedBoat(){
		super();
		type = VesselType.SPEEDBOAT;
		maxVel = 14;
		this.updatesBetweenWakes = 1;
	}
}
