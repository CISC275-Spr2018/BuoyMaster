import java.awt.EventQueue; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
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
	void askQuestion(){
		if(model.buoy.hasCollected){
			if (model.player.yLoc==model.buoy.yLoc+100){
				if(!model.asked){
					model.asked=true;
					if (model.rand<7){
						model.reply=JOptionPane.showConfirmDialog(null,model.askRandomQuestion(),"Salinity Question",model.reply);
						switch(model.rand){
						case 0:
							if(model.reply==JOptionPane.YES_OPTION){
								if(!model.showAnswer){
									model.showAnswer=true;
									JOptionPane.showMessageDialog(null, "Correct!");	
									model.timer.value+=30;
								}
							}
							else{
								if(!model.showAnswer){
									model.showAnswer=true;
									JOptionPane.showMessageDialog(null, "Incorrect, that is a good salinity. The ocean is 35 PPT!");	
								}
							}
						case 1:
							if(model.reply==JOptionPane.NO_OPTION){
								if(!model.showAnswer){
									model.showAnswer=true;
									JOptionPane.showMessageDialog(null, "Correct!");	
									model.timer.value+=30;
								}
							}
							else{
								if(!model.showAnswer){
									model.showAnswer=true;
									JOptionPane.showMessageDialog(null, "Incorrect, that is a high salinity. The ocean is 35 PPT!");	
								}
							}
						case 2:
							if(model.reply==JOptionPane.YES_OPTION){
								if(!model.showAnswer){
									model.showAnswer=true;
									JOptionPane.showMessageDialog(null, "Correct!");	
									model.timer.value+=30;
								}
							}
							else{
								if(!model.showAnswer){
									model.showAnswer=true;
									JOptionPane.showMessageDialog(null, "Incorrect, that is a good salinity. The ocean is 35 PPT!");	
								}
							}
						case 3:
							if(model.reply==JOptionPane.NO_OPTION){
								if(!model.showAnswer){
								model.showAnswer=true;
									JOptionPane.showMessageDialog(null, "Correct!");	
									model.timer.value+=30;
								}
							}
							else{
								if(!model.showAnswer){
									model.showAnswer=true;
									JOptionPane.showMessageDialog(null, "Incorrect, that is a high salinity. The ocean is 35 PPT!");	
								}
							}
						case 4:
							if(model.reply==JOptionPane.YES_OPTION){
								if(!model.showAnswer){
									model.showAnswer=true;
									JOptionPane.showMessageDialog(null, "Correct!");	
									model.timer.value+=30;
								}
							}
							else{
								if(!model.showAnswer){
									model.showAnswer=true;
									JOptionPane.showMessageDialog(null, "Incorrect, that is a good salinity. The ocean is 35 PPT!");	
								}
							}
						case 5:
							if(model.reply==JOptionPane.YES_OPTION){
								if(!model.showAnswer){
									model.showAnswer=true;
									JOptionPane.showMessageDialog(null, "Correct!");	
									model.timer.value+=30;
								}
							}
							else{
								if(!model.showAnswer){
									model.showAnswer=true;
									JOptionPane.showMessageDialog(null, "Incorrect, that is a good salinity. The ocean is 35 PPT!");	
								}
							}
						case 6:
							if(model.reply==JOptionPane.YES_OPTION){
								if(!model.showAnswer){
									model.showAnswer=true;
									JOptionPane.showMessageDialog(null, "Correct!");	
									model.timer.value+=30;
								}
							}
							else{
								if(!model.showAnswer){
									model.showAnswer=true;
									JOptionPane.showMessageDialog(null, "Incorrect, that is a good salinity. The ocean is 35 PPT!");	
								}
							}
						}
					}
					if (model.rand>=7 && model.rand<12){
						System.out.println("insert a questions here");
					}
					if (model.rand>11){
						System.out.println("insert a questions here");
					}
						
				}
			}
		}
	}
	
	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				Controller c = new Controller();
				c.askQuestion();
				}
		});
	}
}
	