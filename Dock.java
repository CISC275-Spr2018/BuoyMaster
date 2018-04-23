public class Dock extends gamePiece{
	Timer timer;
	GameMessage gameMessage;
	Dock(int x, int y,Timer t, GameMessage gameMessage){
		this.xLoc = x;
		this.yLoc = y;
		this.xVel = 0;
		this.yVel = 0;
		this.timer=t;
		this.gameMessage=gameMessage;
	}

	@Override
	public void onCollide() {
			timer.value = 0;
			gameMessage.message = "you returned with the data!";
		}
	} 
