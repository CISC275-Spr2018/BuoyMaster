import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*
 * Main Model for entire state of the game.
 * Will hold all different parts - player Vessels, Sandbars, Buoy, etc.
 */
public class Model extends KeyAdapter {
	private final int width;
	private final int height;
	private Vessel player;
	private Buoy buoy;
	private Timer timer;
	private GameMessage gameMessage;
	private SandBar sandBar;
	private Dock dock;
	
	Model(int x, int y){
		width = x;
		height = y;
		player = new Vessel(width/2, height - 100);
		timer = new Timer();
		gameMessage = new GameMessage();
		buoy = new Buoy(width/2, 100, gameMessage);
		sandBar = new SandBar(100, height/2, timer, gameMessage);
		dock = new Dock(width/2 + 75, height-120);
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
			dock.update();
		}
		else {
			timer.message = "Game over kid";
		}
	}
	
	public Vessel getPlayer() {
		return player;
	}
	public Buoy getBuoy() {
		return buoy;
	}
	public Timer getTimer() {
		return timer;
	}
	public GameMessage getGameMessage() {
		return gameMessage;
	}
	public SandBar getSandBar() {
		return sandBar;
	}
	public Dock getDock() {
		return dock;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
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
