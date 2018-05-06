package main;

public class Buoy extends GamePiece{
	private GameMessage gameMessage;
	boolean collected = false; // Set true once the player makes contact with the buoy and collects the data
	
	Buoy(int x, int y, GameMessage g){
		this.xLoc = x;
		this.yLoc = y;
		this.xVel = 0;
		this.yVel = 0;
		this.gameMessage = g;
	}

	@Override
	public void onCollide() {
		gameMessage.message = "You have retrieved the data, now return to the dock before sunset!";
		collected = true;
	}
	
	public boolean collectedStatus(){
		return collected;
	}
}
