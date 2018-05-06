
public class SandBar extends GamePiece{
	private GameMessage gameMessage;
	Vessel player;
	boolean crashed = false; //If true, gameOver will become true.
	
	SandBar(int x, int y, int xVel, int yVel, GameMessage g, Vessel v){
		this.xLoc = x;
		this.yLoc = y;
		this.xVel = xVel;
		this.yVel = yVel;
		
		gameMessage = g;
		player = v;
	}
	
	SandBar(int x, int y, GameMessage g, Vessel v){
		this.xLoc = x;
		this.yVel = -5;
		this.yLoc = y;
		gameMessage = g;
		player = v;
	}

	@Override
	public void onCollide() {
		crashed = true;
		gameMessage.message = "you crashed!";
	}

}
