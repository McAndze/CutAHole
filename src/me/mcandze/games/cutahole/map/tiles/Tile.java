package me.mcandze.games.cutahole.map.tiles;

import me.mcandze.games.cutahole.map.Level;

public interface Tile {
	public enum Type{ SOLID, INVISIBLE, }
	
	public abstract char getChar();
	public abstract Type getType();
	public abstract Level getLevel();
	
}
