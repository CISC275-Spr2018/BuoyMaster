package main;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameMessagePanel extends JPanel{
	String messageDraw;
	
	void update(String s) {
		messageDraw = s;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
    	g.drawString(messageDraw, 25, 85);
    }
}
