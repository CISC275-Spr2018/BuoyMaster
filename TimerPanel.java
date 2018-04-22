import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TimerPanel extends JPanel{
	Timer timer;
	
	TimerPanel(Timer t){
		timer = t;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		 g.setFont(new Font("TimesRoman", Font.PLAIN, 54));
    	g.drawString(timer.message, 50, 50);
    }
}
