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
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

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
	JPanel selectionPanel=new BoatSelectionPanel();
	JPanel estuaryPanel;
	PlayerPanel playerPanel;
	BuoyPanel buoyPanel;
	TimerPanel timerPanel;
	GameMessagePanel gameMessagePanel;
	SandBarPanel sandBarPanel;
	DockPanel dockPanel;
	CardLayout cl= new CardLayout();
	Controller c;
	WakePanel wp;
	WakeCollection wc;
	
	
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
		
	    panel.add(startPanel, "1");
	    panel.add(selectionPanel, "2");
	   
		playerPanel = new PlayerPanel(model.player);
		buoyPanel = new BuoyPanel(model.buoy);
		timerPanel = new TimerPanel(model.timer);
		gameMessagePanel = new GameMessagePanel(model.gameMessage);
		sandBarPanel = new SandBarPanel(model.sandBar);
		dockPanel = new DockPanel(model.dock);
		wp = new WakePanel();
		wc = model.player.wakes;
		
		estuaryPanel=this;
		estuaryPanel.addKeyListener(model);
		this.frame = new JFrame();
		this.requestFocus();
		this.frame.setBackground(Color.BLUE.darker().darker());
		this.setBackground(Color.BLUE.darker().darker());
		this.frame.setSize(1000,5000);
		this.frame.setVisible(true);
		panel.add(estuaryPanel, "3");
		panel.setFocusable(true);
		
		//create maps for keybinding
		InputMap im= this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am=this.getActionMap();
				
		//set key actions for panel in input map
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "UpArrow");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "RightArrow");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "LeftArrow");			    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "UpArrow");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "DownArrow");
			   
	    //set key actions for actionmap
	    am.put("RightArrow", new ArrowAction("RightArrow"));
	    am.put("LeftArrow", new ArrowAction("LeftArrow"));
		am.put("UpArrow", new ArrowAction("UpArrow"));
		am.put("DownArrow", new ArrowAction("DownArrow"));
		
		this.frame.add(panel);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public void update(){
		wp.updateAll(wc);
		this.repaint();
	}
	
	// all individual paint methods in central method
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		buoyPanel.paintComponent(g);
		wp.paintComponent(g);
		playerPanel.paintComponent(g);
		timerPanel.paintComponent(g);
		gameMessagePanel.paintComponent(g);
		sandBarPanel.paintComponent(g);
		dockPanel.paintComponent(g);
		
    }


	
	
}
