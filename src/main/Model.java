package main;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
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
	
	/*Constructor for the model 
	 * @param width width of the screen
	 * @param height hieght of the screen
	 * 
	 */
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
	
	/*All individual model update methods in central method
	 * 
	 */
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
	/*@return returns the vessel the player is using
	 * 
	 */
	public Vessel getPlayer() {
		return player;
	}
	/*@return returns the Buoy
	 * 
	 */
	public Buoy getBuoy() {
		return buoy;
	}
	/*@return returns the Timer
	 * 
	 */
	public Timer getTimer() {
		return timer;
	}
	/*@return returns the current GameMessage
	 * 
	 */
	public GameMessage getGameMessage() {
		return gameMessage;
	}
	/*@return returns the dock
	 * 
	 */
	public Dock getDock() {
		return dock;
	}
	/*@return returns the width of the screen
	 * 
	 */
	public int getWidth() {
		return width;
	}
	/*@return returns the height of the screen
	 * 
	 */
	public int getHeight() {
		return height;
	}
	/*Sets the user's vessel selection
	 * @param v user's vessel selection
	 * 
	 */
	void setVessel(Vessel v) {
		this.player = v;
	}

}
