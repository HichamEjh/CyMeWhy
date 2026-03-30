package entity;

import world.Cellule;
import world.World;
import world.Cellule.Type;
import java.util.Random;

public class Zombie extends Entity{

	private static final Random RANDOM = new Random();
	
	public Zombie(String name) {
		super(name);
		updateLife(1);
	}

	@Override
	public Direction chooseMovement() {
	    Direction[] directions = {Direction.W, Direction.A, Direction.D, Direction.S};
	    int index = RANDOM.nextInt(directions.length);
	    return directions[index];
	}
	@Override
	public void checkCollision(World w, int nx, int ny) {
		if (!w.map[nx][ny].isSolid() && w.map[nx][ny].getType()!=Type.PIEGE) {
			
			boolean oldHasPiece = w.map[getX()][getY()].getPiece();
			w.map[getX()][getY()] = new Cellule(getX(), getY(), Type.VIDE);
			w.map[getX()][getY()].setPiece(oldHasPiece); 
			
			boolean targetHasPiece = w.map[nx][ny].getPiece();
			
			this.setXY(nx, ny);
			
			w.map[getX()][getY()] = new Cellule(getX(), getY(), Type.ZOMBIE); 
			w.map[getX()][getY()].setPiece(targetHasPiece);
	    }
	}
	
}
