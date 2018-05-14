package main;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Random;
/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class SandBarCollection implements Serializable{
	HashSet<SandBar> sandBars = new HashSet<SandBar>();
	/**@param min minimum number for range of random number
	 * @param max maximum number for range of random number
	 * @returns a random number between min and max
	 */
	static int randomNum(int min, int max){
		Random r = new Random();
		int i = r.nextInt((max - min) + 1) + min;
		return i;
	}
	/**Adds SandBar based on first constructor
	 * @param x SandBar x coordinate
	 * @param y SandBar y coordinate
	 * @param t SandBar timer
	 * @param g SandBar GameMessage
	 * @param v user's vessel selection
	 * 
	 */
	void addSandBar(int x, int y, Timer t, GameMessage g) {
		this.sandBars.add(new SandBar(x, y, t, g));
	}
	/**Adds SandBar based on second constructor 
	 * @param x SandBar x coordinate
	 * @param y SandBar y coordinate
	 * @param xVel x velocity of a SandBar
	 * @param yVel y velocity of a SandBar
	 * @param t SandBar timer
	 * @param g SandBar GameMessage
	 * @param v user's vessel selection
	 * 
	 */
	void addSandBar(int x, int y, int xVel, int yVel, Timer t, GameMessage g) {
		this.sandBars.add(new SandBar(x, y, xVel, yVel, t, g));
	}
	/**Creates a random SandBar
	 * 
	 */
	void addRandomSandBar(Vessel player, Timer t, GameMessage g, int buffer) {
		int chance = randomNum(0, 5);

		if (chance == 0 && buffer > 100) {
			this.sandBars.add(new SandBar(randomNum(0, player.xLoc) - 50, 620, t, g));
		}
	}
	void addOneRandomSandBar(Vessel player, Timer t, GameMessage g){
		this.sandBars.add(new SandBar(randomNum(0, player.xLoc) - 50, 620, t, g));
	}
	/** checks collisions from all sides of SandBar
	 * @param g GamePiece to check collisions for
	 */
	void checkAllCollision(GamePiece g) {
		for (SandBar s : sandBars) {
			s.hasCollided(g);
		}
	}
	/**updates all sandbars
	 * 
	 */
	void updateAll() {
		for (SandBar s : sandBars) {
			s.updateLocationAndRotation();
		}
	}
	
	void addShorelineBoundaries(Timer t, GameMessage g) {
		this.sandBars.add(new SandBar(200, 200, 0, 0, t, g));
	}
	
	boolean addRandomByWakeStrength(Vessel player, Timer t, GameMessage g, int buffer, int strength) {
		Random rnd = new Random();
		int i = rnd.nextInt(100);
		if (i < strength) {
			return this.sandBars.add(new SandBar(randomNum(0, player.xLoc) - 50, 620, t, g));
		}
		else {
			return false;
		}
	}
	
}