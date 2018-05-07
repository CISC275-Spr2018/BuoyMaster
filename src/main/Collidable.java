package main;
/*
 *@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 */
interface Collidable {
	/*Sets the onCollide method as the required method for the Collidable interface
	 * This method handles collisions between two GamePieces
	 */
	public void onCollide(); //Defines what happens when two collidable objects collide.
}