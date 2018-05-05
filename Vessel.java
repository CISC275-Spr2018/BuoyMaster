import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;

public abstract class Vessel extends GamePiece{
	int maxXVel;
	int maxYVel;
	WakeCollection wakes;
	int wakeStrength = 3;

	Vessel(){
		maxXVel = 0;
		maxYVel = 0;
		this.xLoc = 0;
		this.yLoc = 300;
		wakes = new WakeCollection();
	}
	
	Vessel(int x, int y){
		maxXVel = 0;
		maxYVel = 0;
		this.xLoc = x;
		this.yLoc = y;
		wakes = new WakeCollection();
	}
	
	void update() {
		wakes.removeDeadWakes();
		checkDirection();
		wakes.addWake(this.xLoc, this.yLoc, -this.xVel, -this.yVel, this.wakeStrength);
		wakes.update();
		super.update();
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
			return "boat_east";
		}
	}

	@Override
	public void onCollide() {
		// TODO Auto-generated method stub
	}
	
}
