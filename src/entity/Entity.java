package entity;

import world.Cellule;
import world.Cellule.Type;

public class  Entity {
	public static enum Direction {W,S,D,A};
	//##############################
	private final String name;
	private int x;
	private int y;
	private int spawnX;
	private int spawnY;
	//##############################
	public Entity(String name) {
		this.name = name;
	}
	//##############################
	public void setX(int x) {
		this.x=x;
	}
	public void setY(int x) {
		this.y=x;
	}
	public void setSpawnX(int x) {
		this.spawnX=x;
	}
	public void setSpawnY(int y) {
		this.spawnY=y;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getSpawnX() {
		return this.spawnX;
	}
	public int getSpawnY() {
		return this.spawnY;
	}
	public String getName() {
		return name;
	}
	public boolean equals(Object obj) {
        if (this == obj) return true;
        
        if (obj == null || !(obj instanceof Entity)) return false;
        
        Entity other = (Entity) obj;
        
        return this.name.equalsIgnoreCase(other.name);
    }
	public String toString() {
		return "▶ " + name +" :";
	}
	//##############################
	public void resetEntity() {
		this.x=this.spawnX;
		this.y=this.spawnY;
	}
	//##############################
	public void moveEntity(Direction d){
		if (d == null) {
	        System.out.println("⚠ Invalid Key");
	        return; 
	    }
		int nx=getX();
		int ny=getY();
		switch(d) { 
			case W -> nx--;
			case S -> nx++;
			case D -> ny++;
			case A -> ny--;
		}
		//nx=nx; 
		//ny=ny; 
		if (nx >= 0 && ny >= 0 && nx < maxX && ny < maxY && !map[nx][ny].isSolid()) {
	        map[p.getX()][p.getY()] = new Cellule(p.getX(),p.getY(),Type.VIDE);
	    }
		
	}
}

















