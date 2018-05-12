package main;

/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class GameMessage {
	String message;
	/*Constructor for the GameMessage class. Sets initial message to: collect the data at the buoy.
	 * 
	 */
	GameMessage(boolean tutorial){
		if(tutorial){
			this.message="Use the arrow keys to guide your boat.";
		}
		else{
		this.message = "Go collect data from the buoy.";
		}
	}
}