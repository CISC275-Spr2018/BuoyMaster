
public class Jetski extends Vessel{

	Jetski(){
		super();
		maxXVel = 10;
		maxYVel = 14;
		this.wakeStrength = 2;
	}
	
	Jetski(int x, int y) {
		super(x, y);
		this.wakeStrength = 2;
		// TODO Auto-generated constructor stub
	}

}
