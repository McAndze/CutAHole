package me.mcandze.games.cutahole.entity;

import me.mcandze.games.cutahole.location.Location;

public interface Entity {
	public abstract Location getLocation();
	public abstract void setLocation(Location location);
	public abstract char getChar();
	public abstract void tick();
}
