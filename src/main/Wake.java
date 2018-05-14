package main;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.awt.image.BufferedImage;
/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class Wake extends GamePiece implements Serializable{
	Direction dir;
	int wakeLife = 20;
	/**Constructor for the Wake Class
	 * @param x x coordinate of wake
	 * @param y y coordinate of wake
	 * @param xv x velocity of wake
	 * @param yv y velocity of wake
	 */
	Wake(int x, int y, int xv, int yv){
		this.xLoc = x;
		this.yLoc = y;
		this.xVel = xv;
		this.yVel = yv;
	}
	/**Updates the wake class by decrementing the life of each wake
	 * 
	 */
	void update() {
		super.updateLocation();
		wakeLife--;
		dir = checkDirection();
	}
	/**@return returns the direction of the wake
	 * 
	 */
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
	/**
	 * (non-Javadoc)
	 * @see Collidable#onCollide()
	 */
	@Override
	public void onCollide() {
		//nothing happens when a wake collides with another game object
	}
}