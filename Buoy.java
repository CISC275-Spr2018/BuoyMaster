
public class Buoy extends GamePiece{
	private GameMessage gameMessage;
	boolean collected = false;
	
	Buoy(int x, int y, GameMessage g){
		this.xLoc = x;
		this.yLoc = y;
		this.xVel = 0;
		this.yVel = 0;
		this.gameMessage = g;
	}

	@Override
	public void onCollide() {
		gameMessage.message = "you got the data, now return!";
		collected = true;
		//this.yVel = -1;
	}
}
