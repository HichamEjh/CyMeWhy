package entity;

import java.util.Scanner;
import world.Cellule;
import world.World;
import world.Cellule.Type;

public class Player extends Entity {
	//##############################
	private int score;
	//##############################
	public Player(String name) {
		super(name);
		resetPlayer();
	}
	//##############################
	public int getScore() {
		return this.score;
	}
	public void updateScore(int n) {
		this.score = (this.score +n >0) ? this.score + n : 0;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
	    sb.append(super.toString()+" ");
	    for (int i = 0; i < getLife(); i++) {
	        sb.append("❤");
	    }
	    sb.append(" | ");
	    if (this.getScore() <= 1) {
	        sb.append(this.score + " pt");
	    } else {
	        sb.append(this.score + " pts");
	    }
	    return sb.toString();
	}
	//##############################
	public void resetPlayer() {
		updateLife(5);
		this.score=0;
	}
	
	@SuppressWarnings("resource")
	@Override
	public Direction chooseMovement() {
		Scanner sc = new Scanner(System.in);
		do {
			String input = sc.nextLine().toUpperCase();
			Direction d = switch (input) {
				case "W", "Z" -> Direction.W;
				case "A", "Q" -> Direction.A;
				case "S" -> Direction.S;
				case "D" -> Direction.D;
				default -> null;
			};
			if (d == null) {
				System.out.println("⚠ Invalid Key"); 
			}
			else {
				return d;
				}
			}while(true);	
	}

	@Override
	public void checkCollision(World w, int nx, int ny) {
		if (!w.map[nx][ny].isSolid()) {
			w.map[getX()][getY()] = new Cellule(getX(), getY(), Type.VIDE);
			if (w.map[nx][ny].getPiece()) {
				this.updateScore(10);
				w.map[nx][ny].setPiece(false); 
				w.minusPiece();
			}
			switch(w.map[nx][ny].getType()) {
				case PIEGE -> {
					updateLife(-2);
					w.map[nx][ny] = new Cellule(nx, ny, Type.VIDE); 
					resetEntity(); 
				}
				default -> {
					this.setXY(nx, ny);
				}
			}
	        w.map[getX()][getY()] = new Cellule(getX(), getY(), Type.PLAYER);  
	    }
	}
}


