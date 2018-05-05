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
	
	void addRandomSandBar(Timer t, GameMessage g) {
		this.sandBars.add(new SandBar(randomNum(0, 500), randomNum(0, 500), t, g));
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
