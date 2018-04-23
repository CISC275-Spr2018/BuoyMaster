import java.awt.event.KeyAdapter; 
import java.awt.event.KeyEvent;

public class keyListener extends KeyAdapter {
	Model model;
	public keyListener(Model model){
		this.model=model;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int i=2;
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT && model.getXIncr() > -5) {
			model.setXIncr(model.getXIncr()-2);
		}
		if (key == KeyEvent.VK_RIGHT && model.getXIncr() < 5) {
			model.setXIncr(model.getXIncr()+2);
		}
		if (key == KeyEvent.VK_UP && model.getYIncr() > -5) {
			model.setYIncr(model.getYIncr()-2);
		}

		if (key == KeyEvent.VK_DOWN && model.getYIncr() < 5) {
			model.setYIncr(model.getYIncr()+2);
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
		if (key == KeyEvent.VK_UP) {
		}
		if (key == KeyEvent.VK_DOWN) {
		}
	}
	
	
}
