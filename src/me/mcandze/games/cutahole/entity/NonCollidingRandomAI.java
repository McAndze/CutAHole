package me.mcandze.games.cutahole.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import me.mcandze.games.cutahole.map.BasicLevel;
import me.mcandze.games.cutahole.map.BasicLevel.Axis;
import me.mcandze.games.cutahole.map.LevelUtils;

public class NonCollidingRandomAI implements EntityAI{
	private Entity entity;
	public Direction direction = null;
	
	public enum Direction{
		NORTH(Axis.Y_AXIS, 1), 
		WEST(Axis.X_AXIS, -1), 
		EAST(Axis.X_AXIS, 1),
		SOUTH(Axis.Y_AXIS, -1);
		
		private final Axis axis;
		private int move;
		
		private Direction(Axis axis, int move){
			this.axis = axis;
			this.move = move;
		}

		public int getMove() {
			return move;
		}

		public void setMove(int move) {
			this.move = move;
		}

		public Axis getAxis() {
			return axis;
		}
		
		
	}
	
	public NonCollidingRandomAI(Entity entity){
		this.entity = entity;
	}
	
	@Override
	public void tick() {
		if (direction == null){
			direction = randomDirection();
		}
		
		boolean success = false;
		List<Direction> exempt = new ArrayList<Direction>();
		while (!success){
			if (exempt.size() == 4){
				break;
			}
			if (LevelUtils.checkCollision(entity.getLocation().getLevel(), entity, direction.getAxis(), direction.getMove(), false)){
				((BasicLevel)entity.getLocation().getLevel()).tryToMoveEntity(entity, direction.getAxis(), direction.getMove());
				success = true;
				break;
			} else {
				exempt.add(direction);
				Object[] oaExempt = exempt.toArray();
				Direction[] daExempt = new Direction[exempt.size()];
				for (int i = 0; i < oaExempt.length; i++){
					daExempt[i] = (Direction)oaExempt[i];
				}
				
				direction = randomDirection(daExempt);
			}
		}
	}
	
	public Direction randomDirection(Direction...exempt){
		Random random = new Random(System.currentTimeMillis());
		List<Direction> list = new CopyOnWriteArrayList<Direction>();
		for (Direction d: Direction.values()){
			list.add(d);
		}
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
