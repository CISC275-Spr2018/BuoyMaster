
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Buoy extends gamePiece{
	GameMessage gameMessage;
	boolean show = true;
	public boolean hasCollected=true;
	String[] data= new String[15];
	int rand;
	
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
		
	}
	public String createRandomFact(){
		return data[rand];
		
	}
	@Override
	public void onCollide() {
		gameMessage.message = "you got the data, now return!";
		hasCollected=true;
		this.yVel = -1;
		if(show){
			show=!show;
			JOptionPane.showMessageDialog(null, createRandomFact());	
		}
	}
}
