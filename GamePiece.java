
public abstract class GamePiece implements Collidable{
	int xLoc;
	int yLoc;
	int xVel;
	int yVel;
	
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
	
	boolean withinXRange(GamePiece g2) {
		return (this.xLoc < g2.xLoc + 50) && (this.xLoc > g2.xLoc - 50);
	}
	
	boolean withinYRange(GamePiece g2) {
		return (this.yLoc < g2.yLoc + 50) && (this.yLoc > g2.yLoc - 50);
	}
	public int getYVel(){
		return this.yVel;
	}
	public int getXVel(){
		return this.xVel;
	}
	public void setXVel(int x){
		this.xVel+=x;
	}
	public void setYVel(int y){
		this.yVel+=y;
	}
	void update() {
		this.xLoc += this.xVel;
		this.yLoc += this.yVel;
	}
}
