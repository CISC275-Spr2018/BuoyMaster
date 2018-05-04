import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;


public class TestPanel extends JPanel{
	JPanel buttonsPanel;
	JButton loginButton;
	
	
	public TestPanel(){
		setLayout(new BorderLayout());
		this.add(getButtonPanel(), BorderLayout.NORTH);
	}
	protected JComponent getButtonPanel(){
		buttonsPanel = new JPanel();
		//buttonsPanel.setLayout(new FlowLayout());
		loginButton = new JButton("Login");
		return buttonsPanel;
	}
	
}
