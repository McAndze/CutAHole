package me.mcandze.games.cutahole.location;

import me.mcandze.games.cutahole.map.Level;

public class Location {
	private Level level;
	private int y;
	private int x;
	
	public Location(Level level, int x, int y){
		super();
		this.level = level;
		this.y = y;
		this.x = x;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public Location clone(){
		return new Location(level, x, y);
	}
}
