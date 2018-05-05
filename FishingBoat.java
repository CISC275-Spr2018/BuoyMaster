
public class FishingBoat extends Vessel{
	
	FishingBoat() {
		super();
		vesselType = "fishing_boat";
		maxXVel = 5;
		maxYVel = 7;
		this.wakeStrength = 5;
	}

	FishingBoat(int x, int y) {
		super(x, y);
		this.wakeStrength = 5;
		// TODO Auto-generated constructor stub
	}

}
