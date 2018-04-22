import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JLabel;

public class timerListener implements ActionListener {
	private static int countdown=100;
	public static JLabel label = new JLabel(Integer.toString(countdown));
	Timer timer = new Timer();
	public int getTime(){
		return this.countdown;
	}
	public void setCoundown(int x){
		this.countdown+=x;
	}
	@Override 
	public void actionPerformed(ActionEvent e){
		label.setText(Integer.toString(countdown--));
	}
	

}
