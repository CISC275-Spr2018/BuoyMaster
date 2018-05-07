package main;

public class CorrectListener{
	Controller c;
	public void addTime() {
		c.getModel().getTimer().timeLeft+=30;
	}	
}