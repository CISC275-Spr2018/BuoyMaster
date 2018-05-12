package main;

/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public abstract class GamePiece implements Collidable{
	protected int xLoc;
	protected int yLoc;
	protected double velocity;
	//protected double velocityAngle; //The angle that it is currently traveling in degrees.
	protected double rotationAngle; //The angle at which the image is drawn.
	protected int collisionRange =30; //Default set to 30 but will be changed for different pieces.

	/* Method to check if collision has occurred between to GamePieces
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
	/*Checks to see if two GamePieces are within the XRange of collision
	 * @param g2 second GamePiece which one GamePiece may come into contact with
	 * @return returns a boolean value of if there was a collision or not
	 * 
	 */
	boolean withinXRange(GamePiece g2) {
		return (this.xLoc < g2.xLoc + collisionRange) && (this.xLoc > g2.xLoc - collisionRange);
	}
	/*Checks to see if two GamePieces are within the YRange of collision
	 * @param g2 second GamePiece which one GamePiece may come into contact with
	 * @return returns a boolean value of if there was a collision or not
	 * 
	 */
	boolean withinYRange(GamePiece g2) {
		return (this.yLoc < g2.yLoc + collisionRange) && (this.yLoc > g2.yLoc - collisionRange);
	}
	/*
	 *@return returns the x location of a GamePiece 
	 */
	public int getXLoc() {
		return xLoc;
	}
	/*
	 * @return returns the y location of a GamePiece
	 */
	public int getYLoc() {
		return yLoc;
	}
	/*
	 *@return returns the x velocity of a GamePiece 
	 */
	public double getRotationAngle(){
		return rotationAngle;
	}
	public double getVelocity(){
		return velocity;
	}
	/*Updates the location of a GamePiece based on the x and y velocities
	 * 
	 */
	void updateLocation() {
		this.xLoc += (Math.cos(Math.toRadians(this.rotationAngle)))*(this.velocity);
		this.yLoc -= (Math.sin(Math.toRadians(this.rotationAngle)))*(this.velocity);
		//Note: y is reversed since for a JFrame, location (1,1) is where (1,-1) would be in regular Cartesian.
	}
}
