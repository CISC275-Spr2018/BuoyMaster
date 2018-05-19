package main;

import java.io.Serializable;
import java.util.Random;

import javax.swing.JOptionPane;
/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class Buoy extends GamePiece implements Serializable{
	private GameMessage gameMessage;
	// Set true once the player makes contact with the buoy and collects the data
	boolean collected = false; 
	String[] data= new String[15];
	String[]questions=new String[15];
	Random random=new Random();
	int rand;
	int reply;
	boolean show=true;
	boolean fact=true;
	boolean question=false;
	boolean asked=false;
	boolean showAnswer=false;
	public boolean correct=false;
	boolean tutorial=true;
	boolean tutorialShow=true;
	public boolean sandBar=false;
	boolean moveArrow=false;
	boolean tutorialVisited=false;
	//Buoy constructor
	/**Buoy constructor
	 * @param x this is the x position of buoy in the frame
	 * @param y this is the y position of the buoy in the frame
	 * @param g this is the gamemessage which appears when the user makes contact with the buoy telling them they have collected the data
	 * 	
	 */
	Buoy(int x, int y, GameMessage g){
		this.xLoc = x;
		this.yLoc = y;
		this.setxVel(0);
		this.setyVel(0);
		this.setGameMessage(g);
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
		data[8]="The temperature of the water is 57 degrees Farenheit";
		data[9]="The temperature of the water is 50 degrees Farenheit";
		data[10]="The temperature of the water is 65 degrees Farenheit";
		data[11]="The temperature of the water is 74 degrees Farenheit";
		data[12]="The pH of the water is 4";
		data[13]="The pH of the water is 6";
		data[14]="The pH of the water is 6.5";
		
		//create the questions array to ask about the retrieved data
		questions[0]="The salinity of an estuary can range from .5-25 PPT. Was the measrument at the buoy within this range of good values?";
		questions[1]="The salinity of an estuary can range from .5-25 PPT. Was the measrument at the buoy within this range of good values?";
		questions[2]="The salinity of an estuary can range from .5-25 PPT. Was the measrument at the buoy within this range of good values?";
		questions[3]="The salinity of an estuary can range from .5-25 PPT. Was the measrument at the buoy within this range of good values?";
		questions[4]="The salinity of an estuary can range from .5-25 PPT. Was the measrument at the buoy within this range of good values?";
		questions[5]="The salinity of an estuary can range from .5-25 PPT. Was the measrument at the buoy within this range of good values?";
		questions[6]="The salinity of an estuary can range from .5-25 PPT. Was the measrument at the buoy within this range of good values?";
		questions[7]="Temperatures in estuaries can vary greatly but should be between 55 degrees Farenheit and 65 degrees Farenheit. Was the temperature within this range?";
		questions[8]="Temperatures in estuaries can vary greatly but should be between 55 degrees Farenheit and 65 degrees Farenheit. Was the temperature within this range?";
		questions[9]="Temperatures in estuaries can vary greatly but should be between 55 degrees Farenheit and 65 degrees Farenheit. Was the temperature within this range?";
		questions[10]="Temperatures in estuaries can vary greatly but should be between 55 degrees Farenheit and 65 degrees Farenheit. Was the temperature within this range?";
		questions[11]="Temperatures in estuaries can vary greatly but should be between 55 degrees Farenheit and 65 degrees Farenheit. Was the temperature within this range?";
		questions[12]="The pH measure the acidity of the estuary. It woud be bad for the pH to be below 6 and above 8. Was the pH data recorded within this range?";
		questions[13]="The pH measure the acidity of the estuary. It woud be bad for the pH to be below 6 and above 8. Was the pH data recorded within this range?";
		questions[14]="The pH measure the acidity of the estuary. It woud be bad for the pH to be below 6 and above 8. Was the pH data recorded within this range?";
	}
	/**
	 *@return returns a random question from the question array 
	 */
	public String askRandomQuestion(){
		return questions[rand];
	}
	/**
	 * @return returns a random fact from fact array
	 */
	public String createRandomFact(){
		return data[rand];	
	}
	public void setTutorial(boolean b){
		this.tutorial=b;
	}
	public boolean getTutorial(){
		return this.tutorial;
	}
	public boolean getMoveArrow(){
		return moveArrow;
	}
	/**
	 * (non-Javadoc)
	 * @see Collidable#onCollide()
	 */
	@Override
	//onCollide method for buoy
	public void onCollide() {
		if(tutorial){
			if(tutorialShow){
			JOptionPane.showMessageDialog(null, "Return to Dock! Avoid the sandbars! They are bad for the boat!");
			tutorialShow=false;
			sandBar=true;
			moveArrow=true;
			tutorialVisited=true;
			}
		}
		
		
		
		if(!tutorial){
			if(!collected){
			
				if(fact){
					getGameMessage().message = "Return to the dock with the data.";
					this.setyVel(-1);
					if(show){
					show=!show;
					JOptionPane.showMessageDialog(null, createRandomFact());
					collected=true;
					question=true;
					
				}
				fact=false;
			}
			if (question){
				this.question=false;
				if(!asked){
					this.asked=true;
					if (rand<7){
						reply=JOptionPane.showConfirmDialog(null,askRandomQuestion(),"Salinity Question",reply);
						switch(rand){
					
						case 0:
						if(reply==JOptionPane.YES_OPTION){
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Correct! You get a 30 time bonus");	
								correct=true;
							}
						}
						else{
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Incorrect, that is a good salinity. The ocean is 35 PPT!");	
							}
						}
					
						case 1:
						if(reply==JOptionPane.NO_OPTION){
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Correct! You get a 30 time bonus");
								CorrectListener cl=new CorrectListener();
								correct=true;							}
						}
						else{
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Incorrect, that is a high salinity. The ocean is 35 PPT!");	
							}
						}
					
						case 2:
						if(reply==JOptionPane.YES_OPTION){
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Correct! You get a 30 time bonus");
								CorrectListener cl=new CorrectListener();
								correct=true;							}
						}
						else{
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Incorrect, that is a good salinity. The ocean is 35 PPT!");	
							}
						}
					
						case 3:
						if(reply==JOptionPane.NO_OPTION){
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Correct! You get a 30 time bonus");	
								CorrectListener cl=new CorrectListener();
								correct=true;							}
						}
						else{
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Incorrect, that is a high salinity. The ocean is 35 PPT!");	
							}
						}
					
						case 4:
						if(reply==JOptionPane.YES_OPTION){
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Correct! You get a 30 time bonus");	
								CorrectListener cl=new CorrectListener();
								correct=true;							}
						}
						else{
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Incorrect, that is a good salinity. The ocean is 35 PPT!");	
							}
						}
					
						case 5:
						if(reply==JOptionPane.YES_OPTION){
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Correct! You get a 30 time bonus");
								CorrectListener cl=new CorrectListener();
								correct=true;		
							}
						}
						else{
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Incorrect, that is a good salinity. The ocean is 35 PPT!");	
							}
						}
					
						case 6:
						if(reply==JOptionPane.YES_OPTION){
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Correct!");	
								CorrectListener cl=new CorrectListener();
								correct=true;							
							}
						}
						else{
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Incorrect, that is a good salinity. The ocean is 35 PPT!");	
							}
						}
					}
				}
				
					if (rand>=7 && rand<12){
					reply=JOptionPane.showConfirmDialog(null,askRandomQuestion(),"Temperature Question",reply);
					switch(rand){
					case 7:
						if(reply==JOptionPane.NO_OPTION){
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Correct! You get a 30 time bonus");	
								CorrectListener cl=new CorrectListener();
								correct=true;							}
						}
						else{
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Incorrect, that is 5 degrees Farenheit more than it should be!");	
							}
						}
					
					case 8:
						if(reply==JOptionPane.YES_OPTION){
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Correct! You get a 30 time bonus");
								CorrectListener cl=new CorrectListener();
								correct=true;							}
						}
						else{
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Incorrect, the water is temperature is within the good range!");	
							}
						}
					case 9:
						if(reply==JOptionPane.NO_OPTION){
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Correct!, You get a 30 time bonus");
								CorrectListener cl=new CorrectListener();
								correct=true;							}
						}
						else{
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Incorrect, the water is too cold!");	
							}
						}
					case 10:
						if(reply==JOptionPane.YES_OPTION){
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Correct! You get a 30 time bonus");	
								CorrectListener cl=new CorrectListener();
								correct=true;							}
						}
						else{
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Incorrect, that is within the range of good temperatures!");	
							}
						}
					case 11:
						if(reply==JOptionPane.NO_OPTION){
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Correct! You get a 30 time bonus");	
								CorrectListener cl=new CorrectListener();
								correct=true;							}
						}
						else{
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Incorrect, that temperature is 9 degrees Farenheit outside of the good range!");	
							}
						}
					}
				}
				if (rand>11){
					reply=JOptionPane.showConfirmDialog(null,askRandomQuestion(),"Temperature Question",reply);
					switch(rand){
					case 12:
						if(reply==JOptionPane.NO_OPTION){
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Correct! You get a 30 time bonus");	
								CorrectListener cl=new CorrectListener();
								correct=true;							}
						}
						else{
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Incorrect, that is a low pH!");	
							}
						}
					case 13:
						if(reply==JOptionPane.YES_OPTION){
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Correct! You get a 30 time bonus");
								CorrectListener cl=new CorrectListener();
								correct=true;							}
						}
						else{
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Incorrect, the water pH is within the good range!");	
							}
						}
					case 14:
						if(reply==JOptionPane.YES_OPTION){
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Correct!, You get a 30 time bonus");
								CorrectListener cl=new CorrectListener();
								correct=true;							}
						}
						else{
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Incorrect, the water pH is within the good range!");	
							}
						}
					}
				}
			}
		}
		}
		}
	}

		
	/**
	 *@return returns the status of collected 
	 */
	public boolean collectedStatus(){
		return collected;
	}
	public GameMessage getGameMessage() {
		return gameMessage;
	}
	public void setGameMessage(GameMessage gameMessage) {
		this.gameMessage = gameMessage;
	}

}