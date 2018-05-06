import java.awt.image.BufferedImage;

public class Wake extends GamePiece{
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
		String direction;
		if (xVel == 0 && yVel < 0) { // north
			direction = "north";
		}
		else if (xVel > 0 && yVel < 0) { // northeast
			direction = "northeast";
		}
		else if (xVel > 0 && yVel == 0) { // east
			direction = "east";
		}
		else if (xVel > 0 && yVel > 0) { // southeast
			direction = "southeast";
		}
		else if (xVel == 0 && yVel > 0) { // south
			direction = "south";
		}
		else if (xVel < 0 && yVel > 0) { // southwest
			direction = "southwest";
		}
		else if (xVel < 0 && yVel == 0) { // west
			direction = "west";
		}
		else if (xVel < 0 && yVel < 0) { // northwest
			direction = "northwest";
		}
		else {
			direction = "";
		}
		return direction;
	}

	@Override
	public void onCollide() {
		// TODO Auto-generated method stub
		
	}

}
