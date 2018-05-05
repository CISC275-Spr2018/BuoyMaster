
public abstract class GamePiece implements Collidable{
	protected int xLoc;
	protected int yLoc;
	protected int xVel;
	protected int yVel;
	private final int range = 30;
	
	boolean hasCollided(GamePiece g2) {
		boolean collide = withinXRange(g2) && withinYRange(g2);
		if (collide) {
			this.onCollide();
			return collide;
		}
		else {
			return false;
		}
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

	boolean withinXRange(GamePiece g2) {
		return (this.xLoc < g2.xLoc + range) && (this.xLoc > g2.xLoc - range);
	}
	
	boolean withinYRange(GamePiece g2) {
		return (this.yLoc < g2.yLoc + range) && (this.yLoc > g2.yLoc - range);
	}
	
	void update() {
		this.xLoc += this.xVel;
		this.yLoc += this.yVel;
	}
}
