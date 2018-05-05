import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
	
	Model(int x, int y){
		width = x;
		height = y;
		player = new Vessel(width/2, height - 100);
		timer = new Timer();
		gameMessage = new GameMessage();
		buoy = new Buoy(width/2, 100, gameMessage);
		sandBarCollection = new SandBarCollection();
		dock = new Dock(width/2 + 75, height-120);
		
		sandBarCollection.addSandBar(100, 200, timer, gameMessage);
		sandBarCollection.addRandomSandBar(timer, gameMessage);
		sandBarCollection.addRandomSandBar(timer, gameMessage);
	}
	
	// all individual model update methods in central method
	void modelUpdate() {
		buoy.hasCollided(player);
		sandBarCollection.checkAllCollision(player);
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
