package entity;

import world.World;

public class Zombie extends Entity{

	public Zombie(String name) {
		super(name);
		updateLife(1);
	}

	@Override
	public Direction chooseMovement() {
		return null;
	}

	@Override
	public void checkCollision(World w, int nx, int ny) {
		
	}
	
}
