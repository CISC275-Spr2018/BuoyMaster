package main;

/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class SandBar extends GamePiece{
	private GameMessage gameMessage;
	int lifeSpan = 200;
	Timer timer; //There is a better way to communicate crashing into a sandbar back to the controller. However, it is 7am and I'm too tired to figure it out right now. - Greg
	/**Constructor for the SandBar class
	 * @param x x coordinate of SandBar
	 * @param y y coordinate of SandBar
	 * @param xVel x velocity of SandBar
	 * @param yVel y velocity of SandBar
	 * @param t timer
	 * @param g GameMessage which gets set for hitting a SandBar
	 * @param v user's vessel choice
	 */
	SandBar(int x, int y, int xVel, int yVel, Timer t, GameMessage g){
		this.xLoc = x;
		this.yLoc = y;
		this.setxVel(xVel);
		this.setyVel(yVel);
		
		timer = t;
		gameMessage = g;
	}
	/**@param x sets the x location of the SandBar
	 * @param y	sets the y location of the SandBar
	 * @param t timer
	 * @param g sets the GameMessage for hitting a SandBar
	 * @param v user's vessel choice
	 */
	public SandBar(int x, int y, Timer t, GameMessage g){
		this.xLoc = x;
		this.setyVel(-5);
		this.yLoc = y;
		timer = t;
		gameMessage = g;
	}
	
	void update() {
		super.updateLocationAndRotation();
		this.lifeSpan--;
	}
	
	/**
	 * (non-Javadoc)
	 * @see Collidable#onCollide()
	 */
	@Override
	public void onCollide() {
		timer.timeLeft = 0;
		gameMessage.message = "You crashed!";
	}

}