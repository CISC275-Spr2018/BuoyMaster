
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {
	Vessel player;
	View view;
	
	GameKeyListener(Vessel v, View view){
		this.player = v;
		this.view = view;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT && player.xVel > -player.maxXVel) {
			player.xVel -= 4;
		}
		if (key == KeyEvent.VK_RIGHT && player.xVel < player.maxXVel) {
			player.xVel += 4;
		}	
		if (key == KeyEvent.VK_UP && player.yVel > -player.maxYVel) {
			player.yVel -= 4;
		}
		if (key == KeyEvent.VK_DOWN && player.yVel < player.maxYVel) {
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

