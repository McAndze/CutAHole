package me.mcandze.games.cutahole.map;

import me.mcandze.games.cutahole.entity.Entity;
import me.mcandze.games.cutahole.location.Location;
import me.mcandze.games.cutahole.map.tiles.TileRow;

public interface Level {
	public abstract void render() throws LocationOutOfBoundsException;
	public abstract Entity[] getEntities();
	public abstract Entity[] getActiveEntities();
	public abstract void tick();
	public abstract TileRow[] getTileRows();
	public abstract TileRow getTileRow(Location location);
	public abstract TileRow getTileRow(int y);
}
