package main;
import java.util.ArrayList;
import java.util.HashSet;

public class WakeCollection {
	HashSet<Wake> wakes = new HashSet<Wake>();
	int wakeStagger;
	
	void addWake(int x, int y, int xv, int yv, int boatStrength) {
		if (wakeStagger % boatStrength == 0) {
			wakes.add(new Wake(x, y, xv, yv));
		}
	}
	
	void removeDeadWakes() {
		ArrayList<Wake> old = new ArrayList<Wake>();
		for (Wake w : wakes) {
			if (w.wakeLife <= 0) {
				old.add(w);
			}
		}
		wakes.removeAll(old);
	}
	
	void update() {
		removeDeadWakes();
		for (Wake w : wakes) {
			w.update();
		}
		wakeStagger++;
	}
}
