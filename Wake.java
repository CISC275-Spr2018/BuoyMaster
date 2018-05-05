import java.awt.image.BufferedImage;

public class Wake extends gamePiece{
	int wakeLife = 20;
	String direct;
	
	Wake(int x, int y, int xv, int yv){
		this.xLoc = x;
		this.yLoc = y;
		this.xVel = xv;
		this.yVel = yv;
	}
	
	void update() {
		super.update();
		wakeLife--;
		direct = checkDirection();
	}
	
	String checkDirection() {
		if (xVel == 0 && yVel < 0) { // north
			return "wake_north";
		}
		if (xVel > 0 && yVel < 0) { // northeast
			return"wake_northeast";
		}
		if (xVel > 0 && yVel == 0) { // east
			return "wake_east";
		}
		if (xVel > 0 && yVel > 0) { // southeast
			return "wake_southeast";
		}
		if (xVel == 0 && yVel > 0) { // south
			return "wake_south";
		}
		if (xVel < 0 && yVel > 0) { // southwest
			return "wake_southwest";
		}
		if (xVel < 0 && yVel == 0) { // west
			return "wake_west";
		}
		if (xVel < 0 && yVel < 0) { // northwest
			return "wake_northwest";
		}
		else {
			return "";
		}
	}

	@Override
	public void onCollide() {
		// TODO Auto-generated method stub
		
	}

}
