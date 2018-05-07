package main;
import java.util.HashSet;
import java.util.Random;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class SandBarCollection {
	HashSet<SandBar> sandBars = new HashSet<SandBar>();
	/*@param min minimum number for range of random number
	 * @param max maximum number for range of random number
	 * @returns a random number between min and max
	 */
	static int randomNum(int min, int max){
		Random r = new Random();
		int i = r.nextInt((max - min) + 1) + min;
		return i;
	}
	/*Adds SandBar based on first constructor
	 * @param x SandBar x coordinate
	 * @param y SandBar y coordinate
	 * @param t SandBar timer
	 * @param g SandBar GameMessage
	 * @param v user's vessel selection
	 * 
	 */
	void addSandBar(int x, int y, Timer t, GameMessage g, Vessel v) {
		this.sandBars.add(new SandBar(x, y, t, g, v));
	}
	/*Adds SandBar based on second constructor 
	 * @param x SandBar x coordinate
	 * @param y SandBar y coordinate
	 * @param xVel x velocity of a SandBar
	 * @param yVel y velocity of a SandBar
	 * @param t SandBar timer
	 * @param g SandBar GameMessage
	 * @param v user's vessel selection
	 * 
	 */
	void addSandBar(int x, int y, int xVel, int yVel, Timer t, GameMessage g, Vessel v) {
		this.sandBars.add(new SandBar(x, y, xVel, yVel, t, g, v));
	}
	/*Creates a random SandBar
	 * 
	 */
	void addRandomSandBar(Vessel player, Timer t, GameMessage g, Vessel v) {
		int chance = randomNum(0, 5);
		if (chance == 0 && v.xLoc > 100) {
			this.sandBars.add(new SandBar(randomNum(0, player.xLoc) - 50, 620, t, g, v));
		}
	}
	/* checks collisions from all sides of SandBar
	 * @param g GamePiece to check collisions for
	 */
	void checkAllCollision(GamePiece g) {
		for (SandBar s : sandBars) {
			s.hasCollided(g);
		}
	}
	/*updates all sandbars
	 * 
	 */
	void updateAll() {
		for (SandBar s : sandBars) {
			s.updateLocation();
		}
	}
}