import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/*
 * Main View class for the game.
 * Will hold all different Panels of objects - PlayerPanel, BuoyPanel, etc.
 */
public class EstuaryView extends JPanel{

	
	JFrame frame;
	int xLoc;
	int yLoc;
	JPanel panel= new JPanel();
	JPanel startPanel = new JPanel(new BorderLayout());
	JPanel selectionPanel = new JPanel(new BorderLayout());
	JPanel estuaryPanel;
	PlayerPanel playerPanel;
	BuoyPanel buoyPanel;
	TimerPanel timerPanel;
	GameMessagePanel gameMessagePanel;
	SandBarPanel sandBarPanel;
	DockPanel dockPanel;
	CardLayout cl= new CardLayout();
	Controller c;
	
	EstuaryView(Model model){
		panel.setLayout(cl);
		//create start panel stuff
		//startPanel.setSize(model.width, model.height);
		JButton button1 = new JButton("Start");
	    button1.setSize(20,20);
	    button1.setVisible(true);
	    button1.setActionCommand("start");
		BufferedImage logo=null;
		try{
			logo=ImageIO.read(new File("images/logo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel picLabel= new JLabel(new ImageIcon(logo));
		startPanel.add(button1,BorderLayout.SOUTH);
		startPanel.add(picLabel, BorderLayout.CENTER);
		startPanel.setBackground(Color.BLUE.darker().darker());
		button1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cl.show(panel,"2");
			}
		});
		//stuff for selection panel
		//selectionPanel.setSize(model.width, model.height);
		BufferedImage choice1 = null;
		BufferedImage choice2=null;
		BufferedImage choice3=null;
		try {
			choice1 = ImageIO.read(new File("images/boat_east.png"));
			choice2=ImageIO.read(new File("images/boat_east.png"));
			choice3= ImageIO.read(new File("images/boat_east.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton button2 = new JButton(new ImageIcon(choice1));
		button2.setBorder(BorderFactory.createEmptyBorder());
		button2.setContentAreaFilled(false);
	    button2.setSize(20,20);
	    button2.setVisible(true);
	    button2.setActionCommand("select");
		button2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cl.show(panel, "3");
				c.start=true;
		
			}
		});
		
		JButton button3 = new JButton(new ImageIcon(choice2));
		button3.setBorder(BorderFactory.createEmptyBorder());
		button3.setContentAreaFilled(false);
	    button3.setSize(20,20);
	    button3.setVisible(true);
	    button3.setActionCommand("select");
		button3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cl.show(panel, "3");
				c.start=true;
		
			}
		});
		
		JButton button4 = new JButton(new ImageIcon(choice3));
		button4.setBorder(BorderFactory.createEmptyBorder());
		button4.setContentAreaFilled(false);
	    button4.setSize(20,20);
	    button4.setVisible(true);
	    button4.setActionCommand("select");
		button4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cl.show(panel, "3");
				c.start=true;
		
			}
		});
		
	    selectionPanel.add(button2,BorderLayout.NORTH);
	    selectionPanel.add(button3,BorderLayout.CENTER);
	    selectionPanel.add(button4,BorderLayout.SOUTH);
	    selectionPanel.setBackground(Color.BLUE.darker().darker());
	    panel.add(startPanel, "1");
	    panel.add(selectionPanel, "2");
	   
		playerPanel = new PlayerPanel(model.player);
		buoyPanel = new BuoyPanel(model.buoy);
		timerPanel = new TimerPanel(model.timer);
		gameMessagePanel = new GameMessagePanel(model.gameMessage);
		sandBarPanel = new SandBarPanel(model.sandBar);
		dockPanel = new DockPanel(model.dock);
		estuaryPanel=this;
		this.frame = new JFrame();
		this.requestFocus();
		this.frame.setBackground(Color.BLUE.darker().darker());
		this.setBackground(Color.BLUE.darker().darker());
		this.frame.setSize(1000,5000);
		this.frame.setVisible(true);
		panel.add(estuaryPanel, "3");
		panel.requestFocusInWindow();
		this.frame.add(panel);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public void changeFromStart() {
		// TODO Auto-generated method stub
		
	}
	
	public void update(){
		this.repaint();
	}
	
	// all individual paint methods in central method
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		buoyPanel.paintComponent(g);
		playerPanel.paintComponent(g);
		timerPanel.paintComponent(g);
		gameMessagePanel.paintComponent(g);
		sandBarPanel.paintComponent(g);
		dockPanel.paintComponent(g);
		
    }


	
	
}
