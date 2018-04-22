import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Controller implements ActionListener {
	private static final int DRAWDELAY = 50;
	public static Model model;
	public static View view;
	public static Vessel vessel;
	public static JetSki jetski;
	public static Buoy buoy;
	public Controller() {
		model=new Model();
		Timer t = new Timer(DRAWDELAY, this);
		timerListener tL=new timerListener();
		Timer timer=new Timer(1000, tL);
		view=new View(tL);
		jetski=new JetSki(view.getWidth(), view.getHeight(), view.getImageWidth(), view.getImageHeight());
		buoy=new Buoy(100,300,view.getImageWidth(),view.getImageHeight());
		t.start();
		timer.start();
	}
	public void start() {}
	public void boatChoice() {}
	public void arrowKeyListener() {}
	public void answerChoiceListener() {}
	public void addTimer(){
		
	}
	public void addTime() {}
	public void addPlants() {}
	public void slowErosion() {}
	public void slowSpeed() {}
	public void countDown() {}
	public void turnBoatAround() {}
	public void checkPoints() {}
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				new Controller();
				view.setVisible(true);			
				//view.update(jetski);
			}
		});

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
