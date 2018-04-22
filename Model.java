import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Model extends KeyAdapter {
	final int width = 1000;
	final int height = 1000;
	Vessel player;
	Buoy buoy;
	
	Model(){
		player = new Vessel(width/2, height - 100);
		buoy = new Buoy(width/2, 100);
	}
	
	// all individual model update methods in central method
	void modelUpdate() {
		player.update();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT && player.xVel > -5) {
			player.xVel -= 4;
		}
		if (key == KeyEvent.VK_RIGHT && player.xVel < 5) {
			player.xVel += 4;
		}	
		if (key == KeyEvent.VK_UP && player.yVel > -7) {
			player.yVel -= 4;
		}
		if (key == KeyEvent.VK_DOWN && player.yVel < 7) {
			player.yVel += 4;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
		}
		if (key == KeyEvent.VK_RIGHT) {
		}
		if (key == KeyEvent.VK_UP) {
		}
		if (key == KeyEvent.VK_DOWN) {
		}
	}
}
