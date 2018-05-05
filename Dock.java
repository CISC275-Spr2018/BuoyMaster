public class Dock extends GamePiece{
	Buoy buoy;
	Timer timer;
	GameMessage gameMessage;
	Dock(int x, int y, Buoy b, Timer t, GameMessage g){
		this.xLoc = x;
		this.yLoc = y;
		this.xVel = 0;
		this.yVel = 0;
		gameMessage = g;
		buoy = b;
		timer = t;
	}

	@Override
	public void onCollide() {
		if (buoy.collected) {
			timer.value = 0;
			gameMessage.message = "You returned the data!";
		}
	} 
}