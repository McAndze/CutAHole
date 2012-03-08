package me.mcandze.games.cutahole.entity;

import me.mcandze.games.cutahole.location.Location;

public class EntityMonster implements Entity {
	protected Location location;
	protected final char c = '$';
	protected NonCollidingRandomAI ai;
	
	public EntityMonster(){
		ai = new NonCollidingRandomAI(this);
	}
	
	@Override
	public char getChar() {
		// TODO Auto-generated method stub
		return c;
	}
	
	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return location;
	}
	
	@Override
	public void setLocation(Location location) {
		// TODO Auto-generated method stub
		this.location = location;
	}
	
	@Override
	public void tick() {
		ai.tick();
	}
}
