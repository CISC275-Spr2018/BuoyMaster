import java.awt.EventQueue; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Controller implements ActionListener {
	private final static int DRAWDELAY = 50;
	static Model model;
	static EstuaryView EView2;
	static EstuaryView EView;
	static boolean start=false;
	public Controller(){
		model = new Model();
		EView = new EstuaryView(model);
		Timer t = new Timer(DRAWDELAY, this);
		t.start();
		
		
	}
	@Override
	/*@param takes in an ActionEvent arg0
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		if(start)
		model.modelUpdate();
		EView.update();
	}
	
	
	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				Controller c = new Controller();
			
				}
			
		});
	}
}
	