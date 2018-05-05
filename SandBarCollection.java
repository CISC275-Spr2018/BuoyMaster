import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class SandBarCollection {
	HashSet<SandBar> sandBars = new HashSet<SandBar>();
	
	static int randomNum(int min, int max){
		int n = ThreadLocalRandom.current().nextInt(min, max + 1);
		return n;
	}
	
	void addSandBar(int x, int y, Timer t, GameMessage g) {
		this.sandBars.add(new SandBar(x, y, t, g));
	}
	
	void addSandBar(int x, int y, int xVel, int yVel, Timer t, GameMessage g) {
		this.sandBars.add(new SandBar(x, y, xVel, yVel, t, g));
	}
	
	void addRandomSandBar(Vessel player, Timer t, GameMessage g) {
		int chance = randomNum(0, 5);
		if (chance == 0) {
			this.sandBars.add(new SandBar(randomNum(0, player.xLoc) - 50, randomNum(900, 1080), t, g));
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
