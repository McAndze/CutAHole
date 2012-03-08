package me.mcandze.games.cutahole.entity;

import java.util.Random;

import me.mcandze.games.cutahole.map.BasicLevel;
import me.mcandze.games.cutahole.map.BasicLevel.Axis;

public class AIMonster implements EntityAI {
	private EntityMonster entity;
	
	public AIMonster(EntityMonster entity){
		this.entity = entity;
	}

	@Override
	public void tick() {
		Random random = new Random(System.currentTimeMillis());
		Axis axis;
		boolean nextBoolean = random.nextBoolean();
		if (nextBoolean){
			axis = Axis.X_AXIS;
		} else {
			axis = Axis.Y_AXIS;
		}
		nextBoolean = random.nextBoolean();
		if (nextBoolean){
			((BasicLevel)entity.location.getLevel()).tryToMoveEntity(entity, axis, 1);
		} else {
			((BasicLevel)entity.location.getLevel()).tryToMoveEntity(entity, axis, -1);
		}
	}

}
