
public class SandBar extends GamePiece{
	private Timer timer;
	private GameMessage gameMessage;
	Vessel player;
	
	SandBar(int x, int y, int xVel, int yVel, Timer t, GameMessage g, Vessel v){
		this.xLoc = x;
		this.yLoc = y;
		this.xVel = xVel;
		this.yVel = yVel;
		
		timer = t;
		gameMessage = g;
		player = v;
	}
	
	SandBar(int x, int y, Timer t, GameMessage g, Vessel v){
		this.xLoc = x;
		this.yVel = -5;
		this.yLoc = y;
		timer = t;
		gameMessage = g;
		player = v;
	}

	@Override
	public void onCollide() {
		timer.value = 0;
		gameMessage.message = "you crashed!";
		
		/*
		this.xVel = player.xVel;
		this.yVel = player.yVel;
		player.xVel = 0;
		player.yVel = 0;
		*/
	}

}
