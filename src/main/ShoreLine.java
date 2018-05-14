package main;

import java.io.Serializable;
import java.util.HashSet;

/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class ShoreLine extends GamePiece implements Serializable{
	HashSet<CollisionPoint> collisionPoints;
	private GameMessage gameMessage;
	Timer timer;
	
	/**
	 * (non-Javadoc)
	 * @see Collidable#onCollide()
	 */
	@Override
	public void onCollide() {
		timer.timeLeft = 0;
		gameMessage.message = "You crashed!";
	}
	
	/**Constructor for the ShorLine class. Sets the x velocity to zero, and y velocity to 10.
	 * @param x x coordinate of ShoreLine
	 * @param y y coordinate of ShoreLine
	 */
	ShoreLine(int x, int y, Timer t, GameMessage g){
		this.xLoc = x;
		this.yLoc = y;
		this.xVel = 0;
		this.yVel = 10;
		this.timer = t;
		this.gameMessage = g;
		
		this.collisionPoints = new HashSet<CollisionPoint>();
	}
	
	private class CollisionPoint implements Serializable{
		int x;
		int y;
		
		CollisionPoint(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	void shiftCollisionPoints(int factor) {
		for (CollisionPoint c : collisionPoints) {
			c.y += factor;
		}
	}
	
	void addCollisionPoints() {
		for (int i = 0; i <= 900; i++) {
			this.collisionPoints.add(new CollisionPoint(i, 400));
		}
		for (int i = 901; i <= 1280; i++) {
			this.collisionPoints.add(new CollisionPoint(i, 500));
		}
	}
	
	@Override
	boolean hasCollided(GamePiece g2) {
		for (CollisionPoint c : collisionPoints) {
			if (g2.xLoc == c.x  && g2.yLoc >= c.y) {
				this.onCollide();
				return true;
			}
		}
		return false;
	}

}