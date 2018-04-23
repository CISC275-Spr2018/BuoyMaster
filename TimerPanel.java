import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class TimerPanel extends JPanel{
	Timer timer;
	
	TimerPanel(Timer t){
		timer = t;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		 g.setFont(new Font("Comic Sans MS", Font.PLAIN, 54));
    	g.drawString(timer.message, 50, 50);
    }
}
