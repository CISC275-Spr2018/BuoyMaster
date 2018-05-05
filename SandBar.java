
public class SandBar extends GamePiece{
	private Timer timer;
	private GameMessage gameMessage;
	
	SandBar(int x, int y, int xVel, int yVel, Timer t, GameMessage g){
		this.xLoc = x;
		this.yLoc = y;
		this.xVel = xVel;
		this.yVel = yVel;
		
		timer = t;
		gameMessage = g;
	}
	
	SandBar(int x, int y, Timer t, GameMessage g){
		this.xLoc = x;
		this.yVel = -3;
		this.yLoc = y;
		timer = t;
		gameMessage = g;
	}

	@Override
	public void onCollide() {
		timer.value = 0;
		gameMessage.message = "you crashed!";
	}

}
