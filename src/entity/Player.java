package entity;

import java.util.Scanner;

import world.Cellule;
import world.World;
import world.Cellule.Type;

public class Player extends Entity {
	//##############################
	private int life;
	private int score;
	//##############################
	public Player(String name) {
		super(name);
		resetPlayer();
	}
	//##############################
	public int getLife() {
		return this.life;
	}
	public int getScore() {
		return this.score;
	}
	public void updateScore(int n) {
		this.score = (this.score +n >0) ? this.score + n : 0;
	}
	public void updateLife(int n) {
		this.life+=n;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
	    sb.append(super.toString()+" ");
	    for (int i = 0; i < life; i++) {
	        sb.append("❤");
	    }
	    if (this.getScore() <= 1) {
	        sb.append("| pt");
	    } else {
	        sb.append("| pts");
	    }
	    return sb.toString();
	}
	//##############################
	public void resetPlayer() {
		this.life=5;
		this.score=0;
	}

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
				sc.close();
				return d;
				}
			}while(true);	
	}

	@Override
	public void checkCollision(World w,int nx,int ny) {
		if (!w.map[nx][ny].isSolid()) {
	        w.map[getX()][getY()] = new Cellule(getX(),getY(),Type.VIDE);
	        this.setX(nx);
	        this.setY(ny);
	        w.map[getX()][getY()] = new Cellule(getX(),getY(),Type.PLAYER);
	        
	    }
	}
}


