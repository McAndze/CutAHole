package me.mcandze.games.cutahole;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import me.mcandze.games.cutahole.entity.EntityPlayer;
import me.mcandze.games.cutahole.location.Location;
import me.mcandze.games.cutahole.map.BasicLevel;
import me.mcandze.games.cutahole.map.LocationOutOfBoundsException;
import me.mcandze.games.cutahole.map.TestLevel;

public class CutAHole extends CutAHoleMess{
	private static CutAHole instance;
	private JTextArea i, arrow;
	private KeyListener keyListener;
	public EntityPlayer player;
	public BasicLevel level;
	
	public CutAHole(EntityPlayer player){
		super();
		i = new JTextArea();
		arrow = new JTextArea("> ");
		instance = this;
		this.player = player;
		createAndShow();
	}
	
	private void createAndShow(){
		this.o.addKeyListener(new CAHKeyListener(this));
		this.setSize(new Dimension(720, 480));
		this.setPreferredSize(new Dimension(720, 480));
		this.setMinimumSize(new Dimension(360, 240));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		arrow.setEditable(false);
		o.setEditable(false);
		
		this.setLayout(new BorderLayout());
		this.add(new JPanel(){{
			setLayout(new BorderLayout());
			add(new JScrollPane(o), BorderLayout.CENTER);
		}}, BorderLayout.CENTER);
		this.add(new JPanel(){{
			setLayout(new BorderLayout());
			add(arrow, BorderLayout.WEST);
			add(new JScrollPane(i), BorderLayout.CENTER);
		}}, BorderLayout.PAGE_END);
		i.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent event) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyCode() == KeyEvent.VK_ENTER){
					write(i.getText());
					i.setText("");
					
				}
				
			}
		});
		this.setVisible(true);
	}
	
	public void loop(){
		boolean done = false;
		double startTime = System.currentTimeMillis() / 1000;
		double lastTime = startTime;
		while(!done){
			double newTime = System.currentTimeMillis() / 1000;
			
			if (newTime >= (startTime + 1)){
				done = true;
			}
			writeln(newTime);
			
			lastTime = newTime;
		}
	}
	
	public void tick(int delta){
		
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				try {
					EntityPlayer player = new EntityPlayer();
					
					Location location = new Location(null, 3, 3);
					player.setLocation(location);
					CutAHole cah = new CutAHole(player);
					TestLevel testLevel = new TestLevel(cah);
					player.getLocation().setLevel(testLevel);
					cah.level = testLevel;
					testLevel.render();
				} catch (LocationOutOfBoundsException e){
					e.printStackTrace();
				}
				
			}
		});
	}
}
