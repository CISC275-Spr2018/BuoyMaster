package main;

import java.io.Serializable;

/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class GameMessage implements Serializable{
	String message;
	/*Constructor for the GameMessage class. Sets initial message to: collect the data at the buoy.
	 * 
	 */
	GameMessage(){
		this.message = "Go collect data from the buoy.";
	}
}