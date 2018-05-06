import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;

public abstract class Vessel extends GamePiece{
	int maxVel;
	Direction dir = Direction.EAST;
	String vesselType;
	WakeCollection wakes;
	int updatesBetweenWakes = 3; //How many times the model is updated between a wake being emitted behind the vessel

	Vessel(){
		maxVel = 0;
		this.xLoc = 0;
		this.yLoc = 300;
		wakes = new WakeCollection();
	}
	
	void update() {
		wakes.removeDeadWakes();
		checkDirection();
		wakes.addWake(this.xLoc, this.yLoc, -this.xVel, -this.yVel, this.updatesBetweenWakes);
		wakes.update();
		super.updateLocation();
	}
	
	
	Direction checkDirection() {
		if (xVel == 0 && yVel < 0) { // north
			dir = Direction.NORTH;
		}
		else if (xVel > 0 && yVel < 0) { // northeast
			dir = Direction.NORTHEAST;
		}
		else if (xVel > 0 && yVel == 0) { // east
			dir = Direction.EAST;
		}
		else if (xVel > 0 && yVel > 0) { // southeast
			dir = Direction.SOUTHEAST;
		}
		else if (xVel == 0 && yVel > 0) { // south
			dir = Direction.SOUTH;
		}
		else if (xVel < 0 && yVel > 0) { // southwest
			dir = Direction.SOUTHWEST;
		}
		else if (xVel < 0 && yVel == 0) { // west
			dir = Direction.WEST;
		}
		else if (xVel < 0 && yVel < 0) { // northwest
			dir = Direction.NORTHWEST;
		}
		else { // east
			dir = Direction.EAST;
		}
		return dir;
	}

	@Override
	public void onCollide() {
		// TODO Auto-generated method stub
	}
	
	public String getVesselType(){
		return vesselType;
	}
	
}
