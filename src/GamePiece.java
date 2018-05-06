
public abstract class GamePiece implements Collidable{
	protected int xLoc;
	protected int yLoc;
	protected int xVel;
	protected int yVel;
	private int collisionRange =30; //Default set to 30 but will be changed for different pieces.
	
	boolean hasCollided(GamePiece g2) { //checks to see if g2 is within collisionRange of this gamePiece. If so, calls onCollide.
		boolean withinCollisionRange = withinXRange(g2) && withinYRange(g2); //calls helper functions to check if g2 is within range
		if(withinCollisionRange){
			this.onCollide();
		}
		return withinCollisionRange;
	}
	boolean withinXRange(GamePiece g2) {
		return (this.xLoc < g2.xLoc + collisionRange) && (this.xLoc > g2.xLoc - collisionRange);
	}
	boolean withinYRange(GamePiece g2) {
		return (this.yLoc < g2.yLoc + collisionRange) && (this.yLoc > g2.yLoc - collisionRange);
	}
	
	public int getXLoc() {
		return xLoc;
	}
	public int getYLoc() {
		return yLoc;
	}
	public int getXVel() {
		return xVel;
	}
	public int getYVel() {
		return yVel;
	}
	
	void updateLocation() {
		this.xLoc += this.xVel;
		this.yLoc += this.yVel;
	}
}
