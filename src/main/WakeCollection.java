package main;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.ArrayList;
import java.util.HashSet;
/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class WakeCollection implements Serializable{
	HashSet<Wake> wakes = new HashSet<Wake>();
	int wakeStagger;
	/**Adds the wake to the WakeCollection
	 * @param x x coordinate of wake
	 * @param y y coordinate of wake
	 * @param xv x velocity of wake
	 * @param yv y velocity of wake
	 * @param boatStrength strength of boat to be used to mod wakeStagger
	 */	
	void addWake(int x, int y, int xv, int yv, int boatStrength) {
		if (wakeStagger % boatStrength == 0) {
			wakes.add(new Wake(x, y, xv, yv));
		}
	}
	/**Removes wakes which wake life is below zero
	 * 
	 */
	void removeDeadWakes() {
		ArrayList<Wake> old = new ArrayList<Wake>();
		for (Wake w : wakes) {
			if (w.wakeLife <= 0) {
				old.add(w);
			}
		}
		wakes.removeAll(old);
	}
	/**Updates the WakeCollection class to remove wakes which have less than zero wake life 
	 * 
	 */
	void update() {
		removeDeadWakes();
		for (Wake w : wakes) {
			w.update();
		}
		wakeStagger++;
	}
}