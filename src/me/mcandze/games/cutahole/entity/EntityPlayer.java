package me.mcandze.games.cutahole.entity;

import me.mcandze.games.cutahole.location.Location;

public class EntityPlayer implements Entity {
	private Location location;

	@Override
	public Location getLocation() {
		return this.location;
	}

	@Override
	public void setLocation(Location location) {
		this.location = location;
		
	}

	@Override
	public char getChar() {
		return '@';
	}
	
	@Override
	public void tick() {
		
	}
}
