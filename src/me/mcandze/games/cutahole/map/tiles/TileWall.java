package me.mcandze.games.cutahole.map.tiles;

import me.mcandze.games.cutahole.map.Level;

public class TileWall implements Tile {
	private Level level;
	private final char c = '=';
	private final Type type = Type.SOLID;
	
	public TileWall(Level level){
		this.level = level;
	}

	@Override
	public char getChar() {
		// TODO Auto-generated method stub
		return c;
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public Level getLevel() {
		// TODO Auto-generated method stub
		return level;
	}
}
