import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Controller implements ActionListener {
	private final int width = 1000;
	private final int height = 1000;
	private final static int DRAWDELAY = 50;
	private Model model;
	private EstuaryView EView;
	
	public Controller(){
		model = new Model(width, height);
		EView = new EstuaryView(width, height);
		
		Timer t = new Timer(DRAWDELAY, this);
		t.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		model.modelUpdate();
		EView.update(model);
	}
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				Controller c = new Controller();
				c.EView.addKeyListener(c.model);
			}
		});
	}
}
