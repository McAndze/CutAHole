package me.mcandze.games.cutahole.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.mcandze.games.cutahole.CutAHole;
import me.mcandze.games.cutahole.entity.Entity;
import me.mcandze.games.cutahole.entity.EntityMonster;
import me.mcandze.games.cutahole.location.Location;
import me.mcandze.games.cutahole.map.tiles.Tile;
import me.mcandze.games.cutahole.map.tiles.TileAir;
import me.mcandze.games.cutahole.map.tiles.TileRow;
import me.mcandze.games.cutahole.map.tiles.TileWall;

public class TestLevel extends BasicLevel{
	/* debug*/ private TestLevel self;
	
	public TestLevel(CutAHole instance){
		super(instance);
		/* debug */ self = this;
		this.tiles = new Tile[20][20];
		this.tileRows = new TileRow[20];
		this.entities = new Entity[2];
		this.entities[0] = instance.player;
		EntityMonster em = new EntityMonster();
		Location emLoc = new Location(this, 5, 5);
		em.setLocation(emLoc);
		this.entities[1] = em;
		createTiles();
//		Random random = new Random(System.currentTimeMillis());
//		for (Tile[] tileRow: tiles){
//			for (int i = 0; i < 20; i++){
//				boolean rndbool = random.nextBoolean();
//				if (rndbool){
//					tileRow[i] = new TileWall(this);
//				} else {
//					tileRow[i] = new TileAir(this);
//				}
//			}
//		}
	}
	
	private void createTiles(){
		Random random = new Random(System.currentTimeMillis());
		List<TileRow> tileRows = new ArrayList<TileRow>();
		for (int i = 0; i < this.tileRows.length; i++){
			int tileRowLength = 50;
			TileRow tileRow = new TileRow(tileRowLength);
			for (int ii = 0; ii < tileRowLength; ii++){
				boolean rndbool = random.nextBoolean();
				if (rndbool){
					rndbool = random.nextBoolean();
					if (rndbool){
						tileRow.tiles[ii] = new TileWall(this);
					} else {
						tileRow.tiles[ii] = new TileAir(this);
					}
				} else {
					tileRow.tiles[ii] = new TileAir(this);
				}
			}
			tileRows.add(tileRow);
		}
		for (int i = 0; i < this.tileRows.length; i++){
			this.tileRows[i] = tileRows.get(i);
		}
	}
}
