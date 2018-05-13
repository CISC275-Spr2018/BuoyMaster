
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class TimerPanel extends JPanel{
	String messageDraw;
	int rectLength=500;
	int timerLength=500;
	/*Updates the timer's timer
	 * @param d the time to update the timer with
	 */
	void update(String d) {
		messageDraw = d;
	}
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
    	g.drawRect(0, 40, rectLength, 20);
    	g.fillRect(0, 40, timerLength, 20);
    	timerLength-=1;
    	g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
    	g.drawString("Time Reamianing", rectLength+10, 60);
    	 
		//super.paintComponent(g);
		//g.setFont(new Font("TimesRoman", Font.PLAIN, 54));
    	//g.drawString(messageDraw, 25, 50);
    }
}
