package main;

import java.io.Serializable;

/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class Timer implements Serializable{
	int timeLeft;
	int decrement;
	String message; //message to be displayed when time runs out
	boolean timesUp = false;
	/*Constructor for the Timer class.
	 * 
	 */
	Timer(){
		timeLeft = 500; //THIS HAS TO BE CHANGED TO A BETTER TIMER!!! Right now it just counts down the number of times the modelUpdate method is called. It should count down in real time milliseconds.
		decrement = 1;
		message = "";
	}
	void increment(){
		timeLeft+=30;
	}
	/*Updates the timer as time goes on by decrementing.
	 * 
	 */
	boolean update() {
		timeLeft -= decrement;
		message = timeLeft + "";
		if (timeLeft <= 0) {
			timesUp = true;
			message = "Out of time!";
		}
		return timesUp;
	}
}