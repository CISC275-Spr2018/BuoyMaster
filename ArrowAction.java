import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class ArrowAction extends AbstractAction{
	Controller c;
	String cmd;
	public ArrowAction(String cmd){
		this.cmd=cmd;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (cmd.equalsIgnoreCase("LeftArrow") && c.model.player.getXVel() > -5) {
			c.model.player.setXVel(-4);
		}
		else if (cmd.equalsIgnoreCase("RightArrow") && c.model.player.getXVel() < 5) {
			c.model.player.setXVel(4);
		}	
		else if (cmd.equalsIgnoreCase("UpArrow") && c.model.player.getYVel() > -7) {
			c.model.player.setYVel(-4);
		}
		else if (cmd.equalsIgnoreCase("DownArrow;")&& c.model.player.getYVel() < 7) {
			c.model.player.setYVel(4);
		}
	}
		
	}

