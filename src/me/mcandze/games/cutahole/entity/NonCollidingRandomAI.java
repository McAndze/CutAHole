package me.mcandze.games.cutahole.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NonCollidingRandomAI implements EntityAI{
	private Entity entity;
	private Direction direction = null;
	
	public enum Direction{
		NORTH, WEST, EAST, SOUTH
	}
	
	@Override
	public void tick() {
		if (direction == null){
			direction = randomDirection();
		}
		
		
	}
	
	public Direction randomDirection(Direction...exempt){
		Random random = new Random(System.currentTimeMillis());
		List<Direction> list = Arrays.asList(Direction.values());
		for (Direction d: exempt){
			list.remove(d);
		}
		
		int toReturn = random.nextInt(list.size());
		int i = 0;
		for (Direction d: list){
			if (i == toReturn){
				return d;
			}
			i++;
		}
		
		return null;
	}
}
