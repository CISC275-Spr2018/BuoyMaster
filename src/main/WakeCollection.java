package main;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.ArrayList;
import java.util.HashSet;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class WakeCollection {
	final int maximumWakesOnScreen = 50;
	ArrayList<Wake> wakes = new ArrayList<Wake>();
	int wakeStagger;
	int wakeIndex = 0;
	/*Adds the wake to the WakeCollection
	 * @param x x coordinate of wake
	 * @param y y coordinate of wake
	 * @param xv x velocity of wake
	 * @param yv y velocity of wake
	 * @param boatStrength strength of boat to be used to mod wakeStagger
	 */	


	void addWake(int x, int y, double wakeStrength, double rotationAngle) {
		if(wakeStagger %(int)(100.0/wakeStrength) == 0){
			if(wakes.size() < maximumWakesOnScreen){
				wakes.add(new Wake(x, y, wakeStrength, rotationAngle));
			}
			else{ //Replaces existing wakes if the maximumWakesOnScreen has been reached
				if(wakeIndex >= maximumWakesOnScreen) wakeIndex = 0;
				wakes.set(wakeIndex, new Wake(x, y, wakeStrength, rotationAngle));
				wakeIndex ++;
			}	
		}
		wakeStagger++;
	}
	
	//Removes old wakes (This can't be done while iterating the wakes ArrayList)
	void removeDeadWakes() {
		HashSet<Wake> oldWakes = new HashSet<Wake>();
		for (Wake w : wakes) {
			if (w.wakeLife <= 0) {
				oldWakes.add(w);
			}
		}
		wakes.removeAll(oldWakes);
	}
	

	/*Updates the position and decrements the life of each wake
	 * 
	 */
	void update() {
		removeDeadWakes();
		for (Wake w : wakes) {
			w.update();
		}
		wakeStagger+=5;
	}
}