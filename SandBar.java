
public class SandBar extends GamePiece{
	private GameMessage gameMessage;
	Vessel player;
	Timer timer; //There is a better way to communicate crashing into a sandbar back to the controller. However, it is 7am and I'm too tired to figure it out right now. - Greg
	
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
		timer.timeLeft = 0;
		gameMessage.message = "You crashed!";
	}

}
