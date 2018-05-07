package main;

/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class ShoreLine extends GamePiece{
	/*
	 * (non-Javadoc)
	 * @see Collidable#onCollide()
	 */
	@Override
	public void onCollide() {
		// TODO Auto-generated method stub
		
	}
	/*Constructor for the ShorLine class. Sets the x velocity to zero, and y velocity to 10.
	 * @param x x coordinate of ShoreLine
	 * @param y y coordinate of ShoreLine
	 */
	ShoreLine(int x, int y){
		this.xLoc = x;
		this.yLoc = y;
		this.xVel = 0;
		this.yVel = 10;
	}

}