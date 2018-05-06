
public class FishingBoat extends Vessel{
	
	FishingBoat() {
		super();
		type = VesselType.FISHINGBOAT;
		maxVel = 5;
		this.updatesBetweenWakes = 5;
	}

}
