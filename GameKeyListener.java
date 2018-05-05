
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {
	Vessel player;
	EstuaryView Eview;
	
	GameKeyListener(Vessel v, EstuaryView view){
		this.player = v;
		Eview = view;
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

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

