package main;

import java.io.Serializable;

/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public abstract class GamePiece implements Collidable, Serializable{
	protected int xLoc;
	protected int yLoc;
	private double xVel;
	private double yVel;
	protected double rotationAngle;
	protected int collisionRange =30; //Default set to 30 but will be changed for different pieces.

	/** Method to check if collision has occurred between to GamePieces
	 * @param g2 second GamePiece which one GamePiece may come into contact with
	 * @return returns a boolean value of if there was a collision or not
	 */
	boolean hasCollided(GamePiece g2) { //checks to see if g2 is within collisionRange of this gamePiece. If so, calls onCollide.
		boolean withinCollisionRange = withinXRange(g2) && withinYRange(g2); //calls helper functions to check if g2 is within range
		if(withinCollisionRange){
			this.onCollide();
		}
		return withinCollisionRange;
	}
	/**Checks to see if two GamePieces are within the XRange of collision
	 * @param g2 second GamePiece which one GamePiece may come into contact with
	 * @return returns a boolean value of if there was a collision or not
	 * 
	 */
	boolean withinXRange(GamePiece g2) {
		return (this.xLoc < g2.xLoc + collisionRange) && (this.xLoc > g2.xLoc - collisionRange);
	}
	/**Checks to see if two GamePieces are within the YRange of collision
	 * @param g2 second GamePiece which one GamePiece may come into contact with
	 * @return returns a boolean value of if there was a collision or not
	 * 
	 */
	boolean withinYRange(GamePiece g2) {
		return (this.yLoc < g2.yLoc + collisionRange) && (this.yLoc > g2.yLoc - collisionRange);
	}
	/**
	 *@return returns the x location of a GamePiece 
	 */
	public int getXLoc() {
		return xLoc;
	}
	/**
	 * @return returns the y location of a GamePiece
	 */
	public int getYLoc() {
		return yLoc;
	}
	/**
	 *@return returns the x velocity of a GamePiece 
	 */
	public double getXVel() {
		return getxVel();
	}
	/**
	 *@return returns the y velocity of a GamePiece 
	 */
	public double getYVel() {
		return getyVel();
	}
	
	public double getRotationAngle() {	
		return rotationAngle;
	}
	/*Updates the location of a GamePiece based on the x and y velocities
	 * 
	 */
	void updateLocationAndRotation() {
		this.rotationAngle = -Math.toDegrees(Math.atan2(this.getyVel(), this.getxVel())); //Sets the rotation angle based on the velocity
		this.xLoc += this.getxVel();
		this.yLoc += this.getyVel();
	}
	public double getxVel() {
		return xVel;
	}
	public void setxVel(double xVel) {
		this.xVel = xVel;
	}
	public double getyVel() {
		return yVel;
	}
	public void setyVel(double yVel) {
		this.yVel = yVel;
	}
}