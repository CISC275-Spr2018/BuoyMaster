import java.awt.image.BufferedImage;

public class Vessel extends GamePiece{

	Vessel(int x, int y){
		this.xLoc = x;
		this.yLoc = y;
	}
	
	void update() {
		checkDirection();
		super.update();
		System.out.print("Player location: " + this.xLoc + " ," + this.yLoc);
		System.out.println(" | Player increment: " + this.xVel + ", " + this.yVel);
	}
	
	String checkDirection() {
		if (xVel == 0 && yVel < 0) { // north
			return "boat_north";
		}
		if (xVel > 0 && yVel < 0) { // northeast
			return"boat_northeast";
		}
		if (xVel > 0 && yVel == 0) { // east
			return "boat_east";
		}
		if (xVel > 0 && yVel > 0) { // southeast
			return "boat_southeast";
		}
		if (xVel == 0 && yVel > 0) { // south
			return "boat_south";
		}
		if (xVel < 0 && yVel > 0) { // southwest
			return "boat_southwest";
		}
		if (xVel < 0 && yVel == 0) { // west
			return "boat_west";
		}
		if (xVel < 0 && yVel < 0) { // northwest
			return "boat_northwest";
		}
		else {
			return "boat_north";
		}
	}

	@Override
	public void onCollide() {
		// TODO Auto-generated method stub
	}
	
}
