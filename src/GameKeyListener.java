

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
public class GameKeyListener implements KeyListener {
	Vessel player;
	View view;
	/*Constructor for the GameKeyListener
	 * @param v sets the player to the vessel
	 * @param view passes in the view
	 */
	GameKeyListener(Vessel v, View view){
		this.player = v;
		this.view = view;
	}
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT && player.xVel > -player.maxVel) {
			player.xVel -= 4;
		}
		if (key == KeyEvent.VK_RIGHT && player.xVel < player.maxVel) {
			player.xVel += 4;
		}	
		if (key == KeyEvent.VK_UP && player.yVel > -player.maxVel) {
			player.yVel -= 4;
		}
		if (key == KeyEvent.VK_DOWN && player.yVel < player.maxVel) {
			player.yVel += 4;
		}
		if (key == KeyEvent.VK_G) {
			System.out.println(player.rotationAngle);
		}
		
	}
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
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
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}