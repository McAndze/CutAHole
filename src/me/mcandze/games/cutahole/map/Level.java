package me.mcandze.games.cutahole.map;

import me.mcandze.games.cutahole.entity.Entity;

public interface Level {
	public abstract void render() throws LocationOutOfBoundsException;
	public abstract Entity[] getEntities();
	public abstract Entity[] getActiveEntities();
	public abstract void tick();
}
