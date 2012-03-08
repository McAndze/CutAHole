package me.mcandze.games.cutahole.map.tiles;

import me.mcandze.games.cutahole.map.Level;

public class TileAir implements Tile{
	private final char c = ' ';
	private final Type type = Type.INVISIBLE;
	private Level level;
	
	public TileAir(Level level) {
		super();
		this.level = level;
	}

	@Override
	public char getChar() {
		return c;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public Level getLevel() {
		// TODO Auto-generated method stub
		return level;
	}
	
}
