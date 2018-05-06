package main;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class TimerPanel extends JPanel{
	String messageDraw;
	
	void update(String d) {
		messageDraw = d;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 54));
    	g.drawString(messageDraw, 25, 50);
    }
}
