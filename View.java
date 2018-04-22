import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JPanel{
	private int imageHeight;
	private int imageWidth;
	private int frameWidth;
	private int frameHeight;
	private JFrame frame;
	private int picNum = 0;
	private BoatImage action;
	JLabel label;
	BufferedImage[] pics;
	private int x, y, xDir, yDir; 
	public View(timerListener t) {		
		setFocusable(true); // necessary to take key inputs
		this.frameWidth=5000;
		this.frameHeight=3000;
		this.imageWidth=165;
		this.imageHeight=165;
		this.frame = new JFrame();
		for (int i=0; i<1000;i++){
		this.frame.setBackground(Color.blue);}
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(this.frameWidth, this.frameHeight);
		this.frame.setVisible(true);
		this.label=t.label;
		panel.add(label, BorderLayout.SOUTH);
	}
	private BufferedImage createImage(BoatImage image) {//String path){
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File(image.path()));
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		// TODO: Change this method so you can load other orc animation bitmaps
	}
	public int getWidth(){
		return this.frameWidth;
	}
	public int getHeight(){
		return this.frameHeight;
	}
	public void update(Vessel vessel){
		this.removeAll();
		this.action = vessel.getAction();
		this.x = vessel.getX();
		this.y = vessel.getY();
	}
	public int getImageWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getImageHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
