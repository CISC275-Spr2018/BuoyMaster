
public class Vessel extends GamePiece{

	Vessel(int x, int y){
		this.xLoc = x;
		this.yLoc = y;
	}
	
	void update() {
		super.update();
		System.out.print("Player location: " + this.xLoc + " ," + this.yLoc);
		System.out.println(" | Player increment: " + this.xVel + ", " + this.yVel);
	}

	@Override
	public void onCollide() {
		// TODO Auto-generated method stub
	}
	
}
