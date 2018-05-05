import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Main Model for entire state of the game.
 * Will hold all different parts - player Vessels, Sandbars, Buoy, etc.
 */
public class Model{
	private final int width;
	private final int height;
	private Vessel player;
	private Buoy buoy;
	private Timer timer;
	private GameMessage gameMessage;
	SandBarCollection sandBarCollection;
	private Dock dock;
	int health = 100000;
	
	boolean pause = false;
	
	Model(int x, int y){
		width = x;
		height = y;
		player = null;
		timer = new Timer();
		gameMessage = new GameMessage();
		buoy = new Buoy(width - 100, 100, gameMessage);
		sandBarCollection = new SandBarCollection();
		dock = new Dock(0, height/2);
		
	}
	
	// all individual model update methods in central method
	void modelUpdate() {
		if (!pause) {
			buoy.hasCollided(player);
			sandBarCollection.checkAllCollision(player);
			health -= player.wakeStrength;
			if (health > 0 && ThreadLocalRandom.current().nextInt(0, health + 1) % player.wakeStrength == 0){
				sandBarCollection.addRandomSandBar(player, timer, gameMessage);
			}
			if (timer.value > 0) {
				buoy.update();
				player.update();
				timer.update();
				sandBarCollection.updateAll();
				dock.update();
			}
			else {
				timer.message = "Game over kid";
			}
			
			System.out.print("Player location: " + player.xLoc + " ," + player.yLoc);
			System.out.println(" | Player increment: " + player.xVel + ", " + player.yVel);
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
