package me.mcandze.games.cutahole;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import me.mcandze.games.cutahole.location.Location;
import me.mcandze.games.cutahole.map.LocationOutOfBoundsException;
import me.mcandze.games.cutahole.map.BasicLevel.Axis;

public class CAHKeyListener implements KeyListener{
	private CutAHole instance;
	
	public CAHKeyListener(CutAHole instance){
		this.instance = instance;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		Location loc = this.instance.player.getLocation();
		if (key == KeyEvent.VK_W){
			instance.level.tryToMoveEntity(this.instance.player, Axis.Y_AXIS, -1);
			this.instance.level.tick();
		} else if (key == KeyEvent.VK_S){
			instance.level.tryToMoveEntity(this.instance.player, Axis.Y_AXIS, 1);
			this.instance.level.tick();
 		} else if (key == KeyEvent.VK_A){
 			instance.level.tryToMoveEntity(this.instance.player, Axis.X_AXIS, -1);
 			this.instance.level.tick();
 		} else if (key == KeyEvent.VK_D){
 			instance.level.tryToMoveEntity(this.instance.player, Axis.X_AXIS, 1);
 			this.instance.level.tick();
 		}
		try {
			instance.level.render();
		} catch (LocationOutOfBoundsException l){
			
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
