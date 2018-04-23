
public class SandBar extends gamePiece{
	Timer timer;
	GameMessage gameMessage;
	
	SandBar(int x, int y, Timer t, GameMessage g){
		this.xLoc = x;
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
