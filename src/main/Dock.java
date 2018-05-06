package main;
public class Dock extends GamePiece{
	boolean arrivedWithData = false;
	GameMessage gameMessage;
	boolean collected = false; // to be updated once the buoy collected is true
	Dock(int x, int y, GameMessage g){
		this.xLoc = x;
		this.yLoc = y;
		this.xVel = 0;
		this.yVel = 0;
		gameMessage = g;
	}

	@Override
	public void onCollide() {
		if (collected) {
			arrivedWithData = true;
			gameMessage.message = "You have successfully returned the data!";
		}
	}
	public void dataCollected(boolean buoyStatus){
		collected = buoyStatus;
	}
}