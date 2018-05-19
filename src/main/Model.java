package main;
import java.io.Serializable;
import java.util.Random;

import java.util.concurrent.ThreadLocalRandom;


import javax.swing.JOptionPane;
/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 *
 *
 * Main Model for entire state of the game.
 * Will hold all different parts - player Vessels, Sandbars, Buoy, etc.
 */
public class Model implements Serializable{

	private final int width;
	private final int height;
	private Timer timer;
	private Vessel player;
	private Dock dock;
	private Buoy buoy;
	private Arrow arrow;
	private GameMessage gameMessage;
	SandBarCollection sandBarCollection;
	int health = 100000;
	ShoreLine shoreline;
	boolean gameOver = false;
	boolean addTime=false;
	private boolean tutorial;
	private boolean tutorialSandbar=true;
	boolean startShow=false;
	boolean gameStart=false;

	/**Constructor for the model 
	 * @param width width of the screen
	 * @param height height of the screen
	 * @param tutorial tells model whether or not it is in tutorial mode
	 */
	public Model(int width, int height, boolean tutorial){
		this.width = width;
		this.height = height;
		player = null;
		timer = new Timer();
		this.setTutorial(tutorial);
		gameMessage = new GameMessage(true);
		buoy = new Buoy(width - 600, 100, gameMessage);
		sandBarCollection = new SandBarCollection();
		dock = new Dock(0, height/2, gameMessage);
		shoreline = new ShoreLine(0, 420, timer, gameMessage);
		arrow=new Arrow(width-585, 20);
	}
	/**All individual model update methods in central method
	 * 
	 */

	public static int randomNum(int min, int max){
		Random r = new Random();
		System.out.println(min+" "+max);
		int i = r.nextInt((max - min) + 1) + min;
		return i;
	}
	public void modelUpdate() {
		//model logic for tutorial
		if (isTutorial()){
			Random r = new Random();
			int l = r.nextInt((health - 0) + 1) + 0;
			health -= player.wakeStrength;
			buoy.setTutorial(true);
			buoy.hasCollided(player);
			player.update(width, height);
			dock.hasCollided(player);
			shoreline.hasCollided(player);
			if (buoy.sandBar){
				if (isTutorialSandbar()){
					sandBarCollection.addSandBar(randomNum(10, player.xLoc) - 50, 620, timer, gameMessage);
					setTutorialSandbar(false);
				}
			}
			//sandBarCollection.checkAllCollision(player);
			sandBarCollection.updateAll();

			if (buoy.moveArrow){
				arrow=new Arrow(10, height/2-75);
			}
		
    // MAY BE OUTDATED
		}
		
			//model settings for when player has completed the tutorial
			if(!isTutorial()){
				gameMessage=new GameMessage(false);
				buoy.xLoc=width-100;
				buoy.yLoc=100;
				buoy.setTutorial(false);
				dock.setTutorial(false);
				buoy.hasCollided(player);
				sandBarCollection.checkAllCollision(player);
				dock.hasCollided(player);
				shoreline.hasCollided(player);
				Random rnd = new Random();
				int chance = rnd.nextInt(100);
				if(player.getXLoc()>20){
					if (chance < player.wakeStrength*2) {
						sandBarCollection.addOneRandomSandBar(player, timer, gameMessage);
						shoreline.yLoc++;
						shoreline.shiftCollisionPoints(1);
					}
				}
				player.update(width, height);
				gameOver = timer.update() || dock.arrivedWithData;
				sandBarCollection.updateAll();
				dock.dataCollected(buoy.collectedStatus());
			}
		}
		

	/**@return returns the vessel the player is using
	 * 
	 */
	public Vessel getPlayer() {
		return player;
	}
	/**@return returns the Buoy
	 * 
	 */
	public Buoy getBuoy() {
		return buoy;
	}
	/**@return returns the Timer
	 * 
	 */
	public Timer getTimer() {
		return timer;
	}
	public boolean addTime(){
		if(buoy.correct){
			return true;
		}
		else{
			return false;
		}
	}
	/**@return returns the current GameMessage
	 * 
	 */
	public GameMessage getGameMessage() {
		return gameMessage;
	}
	/**@return returns the dock
	 * 
	 */
	public Dock getDock() {
		return dock;
	}
	public Arrow getArrow(){
		return arrow;
	}
	/**@return returns the width of the screen
	 * 
	 */
	public int getWidth() {
		return width;
	}
	/**@return returns the height of the screen
	 * 
	 */
	public int getHeight() {
		return height;
	}
	/**Sets the user's vessel selection
	 * @param v user's vessel selection
	 * 
	 */
	public void setVessel(Vessel v) {
		this.player = v;
	}
	public boolean isTutorial() {
		return tutorial;
	}
	public void setTutorial(boolean tutorial) {
		this.tutorial = tutorial;
	}
	public boolean isTutorialSandbar() {
		return tutorialSandbar;
	}
	public void setTutorialSandbar(boolean tutorialSandbar) {
		this.tutorialSandbar = tutorialSandbar;
	}

}
