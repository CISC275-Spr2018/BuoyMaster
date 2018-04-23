import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameMessagePanel extends JPanel{
	GameMessage gameMessage;
	
	GameMessagePanel(GameMessage g){
		gameMessage = g;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
    	g.drawString(gameMessage.message, 25, 85);
    }
}
