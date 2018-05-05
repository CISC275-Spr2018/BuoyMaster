
public class Speedboat extends Vessel{
	
	Speedboat(){
		super();
		maxXVel = 14;
		maxYVel = 16;
		this.wakeStrength = 1;
	}

	Speedboat(int x, int y) {
		super(x, y);
		this.wakeStrength = 1;
		// TODO Auto-generated constructor stub
	}

}
