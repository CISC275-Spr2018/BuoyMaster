import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class TestPanel extends JPanel{
	JPanel buttonsPanel;
	JButton loginButton;
	
	
	public TestPanel(){
		setLayout(new BorderLayout());
		this.add(getButtonPanel(), BorderLayout.SOUTH);
	}
	
	protected JComponent getButtonPanel(){
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout());
		loginButton = new JButton("Login");
		buttonsPanel.add(loginButton);
		return buttonsPanel;
	}
	
}
