public class Dock extends GamePiece{
	Timer timer;
	GameMessage gameMessage;
	boolean collected = false; // to be updated once the buoy collected is true
	Dock(int x, int y, Timer t, GameMessage g){
		this.xLoc = x;
		this.yLoc = y;
		this.xVel = 0;
		this.yVel = 0;
		gameMessage = g;
		timer = t;
	}

	@Override
	public void onCollide() {
		if (collected) {
			timer.value = 0;
			gameMessage.message = "You have successfully returned the data!";
		}
	}
	public void dataCollected(boolean buoyStatus){
		collected = buoyStatus;
	}
}