package main;
/**@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
import java.io.Serializable;
import java.util.Random;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
/*@author Arvin Aya-ay, Greg White, Evan Caplan, Riley Shaw, Dan Hinrichs 
 * 
 */
import java.io.Serializable;
public class GameKeyListener implements KeyListener, Serializable{
	Vessel player;
	Model manualSaveState;
	Controller controller;
	/**Constructor for the GameKeyListener
	 * @param v sets the player to the vessel
	 * @param view passes in the view
	 */
	GameKeyListener(Controller c){
		this.player = c.getModel().getPlayer();
		this.controller = c;
	}
	/**
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT && player.xVel > -player.maxVel) {
			player.xVel -= player.acceleration;
		}
		if (key == KeyEvent.VK_RIGHT && player.xVel < player.maxVel) {
			player.xVel += player.acceleration;
		}	
		if (key == KeyEvent.VK_UP && player.yVel > -player.maxVel) {
			player.yVel -= player.acceleration;
		}
		if (key == KeyEvent.VK_DOWN && player.yVel < player.maxVel) {
			player.yVel += player.acceleration;
		}
		if (key == KeyEvent.VK_G) {
			System.out.println(player.rotationAngle);
		}
		if (key == KeyEvent.VK_S) {
			manualSaveState = this.controller.getModel();
			FileOutputStream fout = null;
			try {
				fout = new FileOutputStream("manualSave.ser");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
			ObjectOutputStream out = null;
			try {
				out = new ObjectOutputStream(fout);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				out.writeObject(this.controller.getModel());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("game saved");
		}
		if (key == KeyEvent.VK_L) {
			FileInputStream fin = null;
			try {
				fin = new FileInputStream("manualSave.ser");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
			ObjectInputStream in = null;
			try {
				in = new ObjectInputStream(fin);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				try {
					manualSaveState = (Model) in.readObject();
					this.controller.setModel(manualSaveState);

					this.controller.gkl = new GameKeyListener(controller);
					this.controller.getView().addKeyListener(this.controller.gkl);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("game loaded");
		}
		
	}
	/**
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
	/**
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}