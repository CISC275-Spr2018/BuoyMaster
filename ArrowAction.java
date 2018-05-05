import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class ArrowAction extends AbstractAction{
	Controller c;
	String cmd;
	//constructor to get string from key binding
	public ArrowAction(String cmd){
		this.cmd=cmd;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//if player hits left arrow and the x velocity is greater than -5 go left
		if (cmd.equalsIgnoreCase("LeftArrow") && c.model.player.getXVel() > -5) {
			c.model.player.setXVel(-4);
		}
		//if player hits right arrow and the x velocity is greater than 5 go right

		else if (cmd.equalsIgnoreCase("RightArrow") && c.model.player.getXVel() < 5) {
			c.model.player.setXVel(4);
		}	
		//if player hits up arrow and the y velocity is greater than -7 go up

		else if (cmd.equalsIgnoreCase("UpArrow") && c.model.player.getYVel() > -7) {
			c.model.player.setYVel(-4);
		}
		//if player hits down arrow and the y velocity is greater than 7 go down

		else if (cmd.equalsIgnoreCase("DownArrow")&& c.model.player.getYVel() < 7) {
			c.model.player.setYVel(4);
		}
	}
		
	}

