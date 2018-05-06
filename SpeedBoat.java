
public class SpeedBoat extends Vessel{
	
	SpeedBoat(){
		super();
		vesselType = "speed_boat";
		maxXVel = 14;
		maxYVel = 16;
		this.wakeStrength = 1;
	}

	SpeedBoat(int x, int y) {
		super(x, y);
		this.wakeStrength = 1;
		// TODO Auto-generated constructor stub
	}

}
