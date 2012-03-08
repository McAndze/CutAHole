package me.mcandze.games.cutahole.map.tiles;

public class TileRow {
	public Tile[] tiles;
	
	public TileRow(int i){
		tiles = new Tile[i];
	}
	
	public TileRow(Tile[] tiles){
		this.tiles = tiles;
	}
}
