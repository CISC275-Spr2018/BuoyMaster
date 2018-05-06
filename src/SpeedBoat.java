
public class SpeedBoat extends Vessel{
	
	SpeedBoat(){
		super();
		type = VesselType.SPEEDBOAT;
		maxVel = 14;
		this.updatesBetweenWakes = 1;
	}
}
