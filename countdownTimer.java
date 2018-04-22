import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class countdownTimer implements ActionListener {
	View view;
	String startTime="100";
	JLabel label;
	Timer timer;
	public countdownTimer(View v){
		this.view=v;
	}
	public void createLabel(){
		label=new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(true);
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask(){
			int i=100;
			public void run(){
				label.setText(Integer.toString(i));
				i--;
			}
		}, 0, 1000);
	}
	
	public void updateView(){
		view.add(label);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		createLabel();
		updateView();		
	}
	
}
