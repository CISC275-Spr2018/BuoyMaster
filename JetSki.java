
public class JetSki extends Vessel{

	JetSki(){
		super();
		vesselType = "jet_ski";
		maxXVel = 10;
		maxYVel = 14;
		this.wakeStrength = 2;
	}
	
	JetSki(int x, int y) {
		super(x, y);
		this.wakeStrength = 2;
		// TODO Auto-generated constructor stub
	}

}
