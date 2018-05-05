import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JOptionPane;

/*
 * Main Model for entire state of the game.
 * Will hold all different parts - player Vessels, Sandbars, Buoy, etc.
 */
public class Model extends KeyAdapter {
	final int width = 2000;
	final int height = 1000;
	Vessel player;
	Buoy buoy;
	Timer timer;
	GameMessage gameMessage;
	SandBar sandBar;
	Dock dock;
	Random random=new Random();
	int rand;

	
	Model(){
		player = new Vessel(width/2, height - 100);
		timer = new Timer();
		gameMessage = new GameMessage();
		buoy = new Buoy(width/2, 100,rand,gameMessage);
		sandBar = new SandBar(100, height/2, timer, gameMessage);
		dock = new Dock(width/2 + 75, height-120);
		rand=random.nextInt(100000000)%15;
	}
		
	
//	void askQuestion(){
//		if(buoy.hasCollected){
//			if (player.yLoc==height/2){
//				
	// all individual model update methods in central method
	void modelUpdate() {
		buoy.hasCollided(player);
		sandBar.hasCollided(player);
		if (timer.value > 0) {
			buoy.update();
			player.update();
			timer.update();
			sandBar.update();
		}
		else {
			timer.message = "Game over kid";
		}
	}
}
