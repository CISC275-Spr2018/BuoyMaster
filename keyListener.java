import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class keyListener extends KeyAdapter {
	Vessel vessel;
	public keyListener(Vessel v){
		this.vessel=v;
	}
	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		if(vessel.getInverted()){
			if (key == KeyEvent.VK_LEFT) {
				vessel.setxDir(-vessel.getXDir());
			}

			if (key == KeyEvent.VK_RIGHT) {
				vessel.setxDir(vessel.getXDir());
			}
			if (key==KeyEvent.VK_UP){
				vessel.goForward();
			}
		}
		else{
			if (key == KeyEvent.VK_LEFT) {
				vessel.setxDir(vessel.getXDir());
			}

			if (key == KeyEvent.VK_RIGHT) {
				vessel.setxDir(-vessel.getXDir());
				
			}
			if(key==KeyEvent.VK_UP){
				vessel.goForward();
			}
		}

	}
	
	//In the future this can make the image stop moving when the keys are released
	@Override
	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
		}
		if (key == KeyEvent.VK_RIGHT) {
		}
		if(key==KeyEvent.VK_UP){
		}
		if(key==KeyEvent.VK_DOWN){
		}
		
	} {
	
	}
}
