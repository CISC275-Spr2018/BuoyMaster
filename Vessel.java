
public class Vessel extends gamePiece{

	Vessel(int x, int y){
		this.xLoc = x;
		this.yLoc = y;
	}
	
	void update() {
		super.update();
		System.out.println("Player location: " + this.xLoc + " ," + this.yLoc);
	}
	
}
