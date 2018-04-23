import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*
 * Main Model for entire state of the game.
 * Will hold all different parts - player Vessels, Sandbars, Buoy, etc.
 */
public class Model extends KeyAdapter {
	final int width = 1000;
	final int height = 1000;
	Vessel player;
	Buoy buoy;
	Timer timer;
	GameMessage gameMessage;
	SandBar sandBar;
	Dock dock;
	
	Model(){
		player = new Vessel(width/2, height - 100);
		timer = new Timer();
		gameMessage = new GameMessage();
		buoy = new Buoy(width/2, 100, gameMessage);
		sandBar = new SandBar(100, height/2, timer, gameMessage);
		dock = new Dock(800, height/2+150);
	}
	
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
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT && player.xVel > -5) {
			player.xVel -= 4;
		}
		if (key == KeyEvent.VK_RIGHT && player.xVel < 5) {
			player.xVel += 4;
		}	
		if (key == KeyEvent.VK_UP && player.yVel > -7) {
			player.yVel -= 4;
		}
		if (key == KeyEvent.VK_DOWN && player.yVel < 7) {
			player.yVel += 4;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
		}
		if (key == KeyEvent.VK_RIGHT) {
		}
		if (key == KeyEvent.VK_UP) {
		}
		if (key == KeyEvent.VK_DOWN) {
		}
	}
}
