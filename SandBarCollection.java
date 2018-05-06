import java.util.HashSet;
import java.util.Random;

public class SandBarCollection {
	HashSet<SandBar> sandBars = new HashSet<SandBar>();
	
	static int randomNum(int min, int max){
		Random r = new Random();
		int i = r.nextInt((max - min) + 1) + min;
		return i;
	}
	
	void addSandBar(int x, int y, GameMessage g, Vessel v) {
		this.sandBars.add(new SandBar(x, y, g, v));
	}
	
	void addSandBar(int x, int y, int xVel, int yVel, GameMessage g, Vessel v) {
		this.sandBars.add(new SandBar(x, y, xVel, yVel, g, v));
	}
	
	void addRandomSandBar(Vessel player, GameMessage g, Vessel v) {
		int chance = randomNum(0, 5);
		if (chance == 0 && v.xLoc > 100) {
			this.sandBars.add(new SandBar(randomNum(0, player.xLoc) - 50, 620, g, v));
		}
	}
	
	void checkAllCollision(GamePiece g) {
		for (SandBar s : sandBars) {
			s.hasCollided(g);
		}
	}
	
	void updateAll() {
		for (SandBar s : sandBars) {
			s.update();
		}
	}
}
