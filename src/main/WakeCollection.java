package main;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.ArrayList;
import java.util.HashSet;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class WakeCollection {
	ArrayList<Wake> wakes = new ArrayList<Wake>();
	int wakeStagger;
	/*Adds the wake to the WakeCollection
	 * @param x x coordinate of wake
	 * @param y y coordinate of wake
	 * @param xv x velocity of wake
	 * @param yv y velocity of wake
	 * @param boatStrength strength of boat to be used to mod wakeStagger
	 */	
	void addWake(int x, int y, double velocity, double rotationAngle, int boatStrength) {
		if (wakeStagger % boatStrength == 0) {
			wakes.add(new Wake(x, y, velocity, rotationAngle));
		}
	}
	/*Updates the WakeCollection class to remove wakes which have less than zero wake life 
	 * 
	 */
	void update() {
		for (Wake w : wakes) {
			w.update();
		}
		wakeStagger++;
	}
}