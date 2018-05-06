package main;

public class ShoreLine extends GamePiece{

	@Override
	public void onCollide() {
		// TODO Auto-generated method stub
		
	}
	
	ShoreLine(int x, int y){
		this.xLoc = x;
		this.yLoc = y;
		this.xVel = 0;
		this.yVel = 10;
	}

}
