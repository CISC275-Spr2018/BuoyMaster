
public class Vessel extends gamePiece{

	Vessel(int x, int y){
		this.xLoc = x;
		this.yLoc = y;
	}
	
	void update() {
		this.xLoc += this.xVel;
		this.yLoc += this.yVel;
		System.out.println(xLoc + ", " + yLoc);
	}
	
}
