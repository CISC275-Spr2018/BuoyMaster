import java.awt.image.BufferedImage;

public class Wake extends GamePiece{
	Direction dir;
	int wakeLife = 20;
	
	Wake(int x, int y, int xv, int yv){
		this.xLoc = x;
		this.yLoc = y;
		this.xVel = xv;
		this.yVel = yv;
	}
	
	void update() {
		super.updateLocation();
		wakeLife--;
		dir = checkDirection();
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
		else if (xVel > 0 && yVel == 0){ // east
			dir = Direction.EAST;
		}
		else{
			return null;
		}
		return dir;
	}

	@Override
	public void onCollide() {
		//nothing happens when a wake collides with another game object
	}
}
