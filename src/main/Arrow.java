package main;

public class Arrow extends GamePiece {
	boolean atBuouy=false;
	Arrow(int x, int y){
		this.xLoc=x;
		this.yLoc=y;
		this.xVel=0;
		this.yVel=0;
	}
	@Override
	public void onCollide() {
			
	}
	
	
}
