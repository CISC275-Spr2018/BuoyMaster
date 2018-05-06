import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Main Model for entire state of the game.
 * Will hold all different parts - player Vessels, Sandbars, Buoy, etc.
 */
public class Model{
	
	private final int width;
	private final int height;
	private Timer timer;
	private Vessel player;
	private Dock dock;
	private Buoy buoy;
	private GameMessage gameMessage;
	SandBarCollection sandBarCollection;
	int health = 100000;
	ShoreLine shoreline;
	boolean gameOver = false;
	
	
	Model(int width, int height){
		this.width = width;
		this.height = height;
		player = null;
		timer = new Timer();
		gameMessage = new GameMessage();
		buoy = new Buoy(width - 100, 100, gameMessage);
		sandBarCollection = new SandBarCollection();
		dock = new Dock(0, height/2, gameMessage);
		shoreline = new ShoreLine(0, 420);
	}
	
	// all individual model update methods in central method
	void modelUpdate() {
		Random r = new Random();
		int i = r.nextInt((health - 0) + 1) + 0;
		health -= player.updatesBetweenWakes;
		
		buoy.hasCollided(player);
		sandBarCollection.checkAllCollision(player);
		dock.hasCollided(player);
		
		if (health > 0 && i % player.updatesBetweenWakes == 0){
			sandBarCollection.addRandomSandBar(player, timer, gameMessage, player);
		}
		
		if (sandBarCollection.sandBars.size() % 5 == 1) {
			shoreline.yLoc++;
		}
		
		player.update();
		gameOver = timer.update() || dock.arrivedWithData;
		sandBarCollection.updateAll();
		dock.dataCollected(buoy.collectedStatus());
	
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
	public Dock getDock() {
		return dock;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	void setVessel(Vessel v) {
		this.player = v;
	}

}
