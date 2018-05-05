
public class SandBar extends GamePiece{
	private Timer timer;
	private GameMessage gameMessage;
	
	SandBar(int x, int y, Timer t, GameMessage g){
		this.xLoc = x;
		//this.xVel = 3;
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
