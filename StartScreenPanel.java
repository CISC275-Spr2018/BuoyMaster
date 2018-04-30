import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartScreenPanel extends JPanel implements ActionListener{
	Model model;
	StartScreenPanel startscreen;
	BufferedImage img;
	JButton start = new JButton("Start");	
	JFrame frame;
	StartScreenPanel(){
		this.add(start);
		start.addActionListener(this);
		try {
		    img = ImageIO.read(new File("images/Est2.png"));
		} catch (IOException e) {
		}
		frame.setSize(1000,1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
    	g.drawImage(img, 0, 0, null);
    	g.drawString("Buoy Master", 350, 350);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		 EstuaryView ev = new EstuaryView(model);
		 ev.setVisible(true);
		 this.frame.dispose();
		 ev.setSize(model.height,model.width);
	}
}
