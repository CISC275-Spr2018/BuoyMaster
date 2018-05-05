
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Buoy extends GamePiece{
	GameMessage gameMessage;
	boolean show = true;
	public boolean hasCollected=true;
	boolean fact=true;
	boolean question=false;
	String[] data= new String[15];
	String[]questions=new String[15];
	int rand;
	int reply;
	boolean asked=false;
	boolean showAnswer=false;
	
	Buoy(int x, int y, int rand, GameMessage g){
		this.xLoc = x;
		this.yLoc = y;
		this.xVel = 0;
		this.yVel = 0;
		this.rand=rand;
		this.gameMessage = g;
		
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
	public String askRandomQuestion(){
		return questions[rand];
	}
	
		
	public String createRandomFact(){
		return data[rand];
		
	}
	@Override
	public void onCollide() {
		if(fact){
		gameMessage.message = "you got the data, now return!";
		this.yVel = -1;
		if(show){
			show=!show;
			JOptionPane.showMessageDialog(null, createRandomFact());
			hasCollected=true;
			question=true;
		}
		}
		if (question){
			if(!asked){
				asked=true;
				if (rand<7){
					reply=JOptionPane.showConfirmDialog(null,askRandomQuestion(),"Salinity Question",reply);
					switch(rand){
					case 0:
						if(reply==JOptionPane.YES_OPTION){
							if(!showAnswer){
								showAnswer=true;
								JOptionPane.showMessageDialog(null, "Correct!");	
								CorrectListener cl=new CorrectListener();
								cl.addTime();
//								Model.timer.value+=30;
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
								JOptionPane.showMessageDialog(null, "Correct!");
								CorrectListener cl=new CorrectListener();
								cl.addTime();
								//timer.value+=30;
							}
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
								JOptionPane.showMessageDialog(null, "Correct!");
								CorrectListener cl=new CorrectListener();
								cl.addTime();
							//	timer.value+=30;
							}
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
								JOptionPane.showMessageDialog(null, "Correct!");	
								CorrectListener cl=new CorrectListener();
								cl.addTime();
							//	timer.value+=30;
							}
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
								JOptionPane.showMessageDialog(null, "Correct!");	
								CorrectListener cl=new CorrectListener();
								cl.addTime();
							//	timer.value+=30;
							}
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
								JOptionPane.showMessageDialog(null, "Correct!");
								CorrectListener cl=new CorrectListener();
								cl.addTime();
							//	timer.value+=30;
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
								cl.addTime();
								//timer.value+=30;
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
					System.out.println("insert a questions here");
				}
				if (rand>11){
					System.out.println("insert a questions here");
				}
					
					
			}
		}
	}
}
		
		
		
		
	

