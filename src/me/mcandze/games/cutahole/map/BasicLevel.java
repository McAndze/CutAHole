package me.mcandze.games.cutahole.map;

import me.mcandze.games.cutahole.CutAHole;
import me.mcandze.games.cutahole.entity.Entity;
import me.mcandze.games.cutahole.location.Location;
import me.mcandze.games.cutahole.map.tiles.Tile;
import me.mcandze.games.cutahole.map.tiles.Tile.Type;
import me.mcandze.games.cutahole.map.tiles.TileRow;

public class BasicLevel implements Level{
	protected CutAHole instance;
	protected TileRow[] tileRows;
	@Deprecated
	protected Tile[][] tiles;
	protected Entity[] entities;
	
	protected BasicLevel(CutAHole instance){
		super();
		this.instance = instance;
	}
	
	public TileRow[] getTileRows(){
		return tileRows;
	}
	
	public TileRow getTileRow(Location location){
		return getTileRow(location.getY());
	}
	
	public TileRow getTileRow(int y){
		return tileRows[y];
	}
	
	public void setTileRows(TileRow[] tileRows){
		this.tileRows = tileRows;
	}
	
	@Deprecated
	public Tile[][] getTiles() {
		return tiles;
	}

	@Deprecated
	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}

	public Entity[] getEntities() {
		return entities;
	}
	
	@Override
	public Entity[] getActiveEntities() {
		// TODO Auto-generated method stub
		return this.getEntities();
	}

	public void setEntities(Entity[] entities) {
		this.entities = entities;
	}
	
	public enum Axis{X_AXIS, Y_AXIS}
	
	public void tryToMoveEntity(Entity entity, Axis axis, int move){
		this.tryToMoveEntity(entity, axis, move, false);
	}
	
	public void tryToMoveEntity(Entity entity, Axis axis, int move, boolean jump){
		Location cur = entity.getLocation();
		if (!checkCollision(entity, axis, move, jump)){
			System.out.println("collision");
			return;
		}
		switch(axis){
		case X_AXIS: cur.setX(cur.getX() + move); break;
		case Y_AXIS: cur.setY(cur.getY() + move); break;
		}
		try {
			this.render();
		} catch (LocationOutOfBoundsException l){
			
		}
		
	}
	
	private boolean checkCollision(Entity entity, Axis axis, int move, boolean jump){
		return LevelUtils.checkCollision(this, entity, axis, move, jump);
//		try {
//		Location l = entity.getLocation();
//		if (axis == Axis.X_AXIS){
//			for (Entity e: getActiveEntities()){
//				if (e == entity){
//					System.out.println("self");
//					continue;
//				}
//				Location ll = e.getLocation();
//				if (ll.getX() == l.getX() + move && ll.getY() == l.getY()){
//					System.out.println("llx: " + ll.getX() + " lx: " + l.getX() + " move: " + move);
//					return false;
//				}
//			}
//			System.out.println("lx: " + l.getX() + " move: " + move);
//			TileRow tileRow = getTileRow(l.getY());
//			Tile tile = tileRow.tiles[l.getX() + move];
//			if (tile.getType() == Type.SOLID){
//				System.out.println("tile (x) not good");
//				return false;
//			}
////			Tile[][] tileRows = getTiles();
////			Tile[] tileRow = tileRows[l.getY()];
////			Tile tile = tileRow[l.getX() + move];
////			if (tile.getType() == Type.SOLID){
////				System.out.println("tile (x) not good");
////				return false;
////			}
//		} else {
//			for (Entity e: getActiveEntities()){
//				if (e == entity){
//					System.out.println("self");
//					continue;
//				}
//				Location ll = e.getLocation();
//				if (ll.getY() == l.getY() + move && ll.getX() == l.getX()){
//					System.out.println("lly: " + ll.getY() + " ly: " + l.getY() + " move: " + move);
//					return false;
//				}
//			}
//			System.out.println("ly: " + l.getY() + " move: " + move + "new y: " + (move + l.getY()));
//			TileRow tileRow = getTileRow(l.getY() + move);
//			Tile tile = tileRow.tiles[l.getX()];
//			if (tile.getType() == Type.SOLID){
//				System.out.println("tile (x) not good");
//				return false;
//			}
////			Tile[][] tileRows = getTiles();
////			Tile[] tileRow = tileRows[l.getY() + move];
////			Tile tile = tileRow[l.getX()];
////			if (tile.getType() == Type.SOLID){
////				System.out.println("tile (y) not good");
////				return false;
////			}
//		}
//		return true;
//		} catch (Exception e){
//			return false;
//		}
	}
	
	public void render() throws LocationOutOfBoundsException{
		int i = 0;
		String backup = this.instance.getText();
		this.instance.clear();
		boolean shouldBackup = false;
		for (TileRow tileRow: tileRows){
			String toWrite = "";
			for (Tile tile: tileRow.tiles){
				toWrite += tile.getChar();
			}
			for (Entity e: this.getActiveEntities()){
				Location l = e.getLocation();
				if (l.getY() == i){
					try {
						toWrite = toWrite.substring(0, l.getX()) + e.getChar() + toWrite.substring(l.getX() + 1);
					} catch (IndexOutOfBoundsException ind){
						shouldBackup = true;
					}
				}
			}
			this.instance.writeln(toWrite);
			i++;
		}
//		for (Tile[] tileRow: tiles){
//			String toWrite = "";
//			for (Tile tile: tileRow){
//				toWrite += tile.getChar();
//			}
//			for (Entity e: this.getActiveEntities()){
//				Location l = e.getLocation();
//				if (l.getY() == i){
//					try {
//						toWrite = toWrite.substring(0, l.getX()) + e.getChar() + toWrite.substring(l.getX() + 1);
//					} catch (IndexOutOfBoundsException ind){
//						shouldBackup = true;
//					}
//				}
//			}
//			this.instance.writeln(toWrite);
//			i++;
//		}
		if (shouldBackup){
			this.instance.clear(); 
			this.instance.write(backup);
		}
	}
	
	@Override
	public void tick() {
		for (Entity e: this.getEntities()){
			e.tick();
		}
	}
}
