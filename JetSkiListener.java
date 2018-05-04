import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JetSkiListener implements ActionListener {
	Controller c;
	@Override
	public void actionPerformed(ActionEvent e) {
		c.EView.cl.show(c.EView.panel, "3");
		c.start=true;	
	}
}