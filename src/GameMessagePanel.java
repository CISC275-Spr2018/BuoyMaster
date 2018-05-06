import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class GameMessagePanel extends JPanel{
	String messageDraw;
	/*Updates the GameMessage
	 * @param s string passed in to change the game message
	 */
	void update(String s) {
		messageDraw = s;
	}
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
    	g.drawString(messageDraw, 25, 85);
    }
}
