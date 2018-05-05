import javax.swing.JFrame;


public class Window extends JFrame{
	
	public Window(){
		this.setTitle("Test Panel Window");
		this.setSize(400,280);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new TestPanel());
		this.setVisible(true);
	}
}
