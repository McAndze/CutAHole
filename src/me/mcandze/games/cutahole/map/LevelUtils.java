package me.mcandze.games.cutahole.map;

import me.mcandze.games.cutahole.entity.Entity;
import me.mcandze.games.cutahole.location.Location;
import me.mcandze.games.cutahole.map.BasicLevel.Axis;
import me.mcandze.games.cutahole.map.tiles.Tile;
import me.mcandze.games.cutahole.map.tiles.TileRow;
import me.mcandze.games.cutahole.map.tiles.Tile.Type;

public class LevelUtils {
	public static boolean checkCollision(Level level, Entity entity, Axis axis, int move, boolean jump){
		try {
		Location l = entity.getLocation();
		if (axis == Axis.X_AXIS){
			for (Entity e: level.getActiveEntities()){
				if (e == entity){
					System.out.println("self");
					continue;
				}
				Location ll = e.getLocation();
				if (ll.getX() == l.getX() + move && ll.getY() == l.getY()){
					System.out.println("llx: " + ll.getX() + " lx: " + l.getX() + " move: " + move);
					return false;
				}
			}
			System.out.println("lx: " + l.getX() + " move: " + move);
			TileRow tileRow = level.getTileRow(l.getY());
			Tile tile = tileRow.tiles[l.getX() + move];
			if (tile.getType() == Type.SOLID){
				System.out.println("tile (x) not good");
				return false;
			}
//			Tile[][] tileRows = getTiles();
//			Tile[] tileRow = tileRows[l.getY()];
//			Tile tile = tileRow[l.getX() + move];
//			if (tile.getType() == Type.SOLID){
//				System.out.println("tile (x) not good");
//				return false;
//			}
		} else {
			for (Entity e: level.getActiveEntities()){
				if (e == entity){
					System.out.println("self");
					continue;
				}
				Location ll = e.getLocation();
				if (ll.getY() == l.getY() + move && ll.getX() == l.getX()){
					System.out.println("lly: " + ll.getY() + " ly: " + l.getY() + " move: " + move);
					return false;
				}
			}
			System.out.println("ly: " + l.getY() + " move: " + move + "new y: " + (move + l.getY()));
			TileRow tileRow = level.getTileRow(l.getY() + move);
			Tile tile = tileRow.tiles[l.getX()];
			if (tile.getType() == Type.SOLID){
				System.out.println("tile (x) not good");
				return false;
			}
//			Tile[][] tileRows = getTiles();
//			Tile[] tileRow = tileRows[l.getY() + move];
//			Tile tile = tileRow[l.getX()];
//			if (tile.getType() == Type.SOLID){
//				System.out.println("tile (y) not good");
//				return false;
//			}
		}
		return true;
		} catch (Exception e){
			return false;
		}
	}
}
