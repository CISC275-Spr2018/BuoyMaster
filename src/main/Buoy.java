package main;

import java.util.Random;

import javax.swing.JOptionPane;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class Buoy extends GamePiece{
	private GameMessage gameMessage;
	// Set true once the player makes contact with the buoy and collects the data
	boolean collected = false; 
	String[] data= new String[15];
	String[]questions=new String[15];
	Random random=new Random();
	int rand;
	boolean show=true;
	boolean fact=true;
	boolean question=false;
	//Buoy constructor
	/*Buoy constructor
	 * @param x this is the x position of buoy in the frame
	 * @param y this is the y position of the buoy in the frame
	 * @param g this is the gamemessage which appears when the user makes contact with the buoy telling them they have collected the data
	 * 	
	 */
	Buoy(int x, int y, GameMessage g){
		this.xLoc = x;
		this.yLoc = y;
		this.xVel = 0;
		this.yVel = 0;
		this.gameMessage = g;
		rand=random.nextInt(14);
		
		//create the data array for 
		data[0]="The salinity of the estuary is 15 PPT";
		data[1]="The salinity of the estuary is 30 PPT";
		data[2]="The salinity of the estuary is 10 PPT";
		data[3]="The salinity of the estuary is 35 PPT";
		data[4]="The salinity of the estuary is 5 PPT";
		data[5]="The salinity of the estuary is 1 PPT";
		data[6]="The salinity of the estuary is 6 PPT";
		data[7]="The temperature of the water is 70 degrees Farenheit";
		data[8]="The temperature of the water is 52 degrees Farenheit";
		data[9]="The temperature of the water is 50 degrees Farenheit";
		data[10]="The temperature of the water is 65 degrees Farenheit";
		data[11]="The temperature of the water is 74 degrees Farenheit";
		data[12]="The pH of the water is 4";
		data[13]="The pH of the water is 6";
		data[14]="The pH of the water is 8";
		
		//create the questions array to ask about the retrieved data
		questions[0]="The salinity of an estuary can range from .5-25 PPT. Was the measrument at the buoy within this range of good values?";
		questions[1]="The salinity of an estuary can range from .5-25 PPT. Was the measrument at the buoy within this range of good values?";
		questions[2]="The salinity of an estuary can range from .5-25 PPT. Was the measrument at the buoy within this range of good values?";
		questions[3]="The salinity of an estuary can range from .5-25 PPT. Was the measrument at the buoy within this range of good values?";
		questions[4]="The salinity of an estuary can range from .5-25 PPT. Was the measrument at the buoy within this range of good values?";
		questions[5]="The salinity of an estuary can range from .5-25 PPT. Was the measrument at the buoy within this range of good values?";
		questions[6]="The salinity of an estuary can range from .5-25 PPT. Was the measrument at the buoy within this range of good values?";
		questions[7]="Temperatures estuaries can vary greatly .";
		questions[8]="The temperature of the water is 52 degrees Farenheit";
		questions[9]="The temperature of the water is 50 degrees Farenheit";
		questions[10]="The temperature of the water is 65 degrees Farenheit";
		questions[11]="The temperature of the water is 74 degrees Farenheit";
		questions[12]="The temperature of the water is 49 degrees Farenheit";
		questions[13]="The temperature of the water is 72 degrees Farenheit";
		questions[14]="The temperature of the water is 35 degrees Farenheit";
	}
	/*
	 *@return returns a random question from the question array 
	 */
	public String askRandomQuestion(){
		return questions[rand];
	}
	/*
	 * @return returns a random fact from fact array
	 */
	public String createRandomFact(){
		return data[rand];	
	}
	
	/*
	 * (non-Javadoc)
	 * @see Collidable#onCollide()
	 */
	@Override
	//onCollide method for buoy
	public void onCollide() {
		
		if(fact){
			gameMessage.message = "you got the data, now return!";
			this.yVel = -1;
			if(show){
				show=!show;
				JOptionPane.showMessageDialog(null, createRandomFact());
				collected=true;
				question=true;
			}
		}
		
	}
	/*
	 *@return returns the status of collected 
	 */
	public boolean collectedStatus(){
		return collected;
	}
}