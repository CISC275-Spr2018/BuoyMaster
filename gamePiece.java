
public abstract class gamePiece {
	int xLoc;
	int yLoc;
	int xVel;
	int yVel;
	
	boolean hasCollided() {
		return false;
	}
	
	void update() {
		this.xLoc += this.xVel;
		this.yLoc += this.yVel;
	}
}
