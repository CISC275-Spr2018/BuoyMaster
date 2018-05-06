import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;

public abstract class Vessel extends GamePiece{
	int maxXVel;
	int maxYVel;
	String vesselType;
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
		super.updateLocation();
	}
	
	
	String checkDirection() {
		String direction;
		if (xVel == 0 && yVel < 0) { // north
			direction = "north";
		}
		else if (xVel > 0 && yVel < 0) { // northeast
			direction ="northeast";
		}
		else if (xVel > 0 && yVel == 0) { // east
			direction = "east";
		}
		else if (xVel > 0 && yVel > 0) { // southeast
			direction = "southeast";
		}
		else if (xVel == 0 && yVel > 0) { // south
			direction = "south";
		}
		else if (xVel < 0 && yVel > 0) { // southwest
			direction = "southwest";
		}
		else if (xVel < 0 && yVel == 0) { // west
			direction = "west";
		}
		else if (xVel < 0 && yVel < 0) { // northwest
			direction = "northwest";
		}
		else {
			direction = "east";
		}
		return vesselType + "\\" + direction;
	}

	@Override
	public void onCollide() {
		// TODO Auto-generated method stub
	}
	
}
