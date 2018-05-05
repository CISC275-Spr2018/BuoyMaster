import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

/*
 * Main Model for entire state of the game.
 * Will hold all different parts - player Vessels, Sandbars, Buoy, etc.
 */
public class Model extends KeyAdapter {
	final int width = 2000;
	final int height = 1000;
	Vessel player;
	Buoy buoy;
	Timer timer;
	GameMessage gameMessage;
	SandBar sandBar;
	Dock dock;
	int rand;
	int reply;
	boolean asked=false;
	boolean showAnswer=false;
	String[]questions=new String[15];
	Model(){
		player = new Vessel(width/2, height - 100);
		timer = new Timer();
		gameMessage = new GameMessage();
		buoy = new Buoy(width/2, 100,rand,gameMessage);
		sandBar = new SandBar(100, height/2, timer, gameMessage);
		dock = new Dock(width/2 + 75, height-120);
		questions[0]="The salinity of an estuary can range from .5-25 PPT. Was the measrument at the buoy within this range of good values?";
		questions[1]="The salinity of an estuary can range from .5-25 PPT. Was the measrument at the buoy within this range of good values?";
		questions[2]="The salinity of an estuary can range from .5-25 PPT. Was the measrument at the buoy within this range of good values?";
		questions[3]="The salinity of an estuary can range from .5-25 PPT. Was the measrument at the buoy within this range of good values?";
		questions[4]="The salinity of an estuary can range from .5-25 PPT. Was the measrument at the buoy within this range of good values?";
		questions[5]="The salinity of an estuary can range from .5-25 PPT. Was the measrument at the buoy within this range of good values?";
		questions[6]="The salinity of an estuary can range from .5-25 PPT. Was the measrument at the buoy within this range of good values?";
		questions[7]="Temperatures estuaries can vary greatly.  ";
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
	
	
	void askQuestion(){
		if(buoy.hasCollected){
			if (player.yLoc==height/2){
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
									timer.value+=30;
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
									timer.value+=30;
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
									timer.value+=30;
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
									timer.value+=30;
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
									timer.value+=30;
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
									timer.value+=30;
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
									timer.value+=30;
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
					
					}
						
				}
			}
		}
	}
	// all individual model update methods in central method
	void modelUpdate() {
		buoy.hasCollided(player);
		sandBar.hasCollided(player);
		if (timer.value > 0) {
			buoy.update();
			player.update();
			timer.update();
			sandBar.update();
		}
		else {
			timer.message = "Game over kid";
		}
	}
}
