import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TimerPanel extends JPanel{
	int value;
	
	void updateValue(Timer t){
		this.value = t.value;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		 g.setFont(new Font("TimesRoman", Font.PLAIN, 54));
    	g.drawString("" + value, 50, 50);
    }
}
