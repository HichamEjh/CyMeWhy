package World;
import Player.*; 



public class World {
	public char[][] map;
	public static enum Direction {W,S,D,A};
	
	
	public World(char[][] lvl) {
		map = lvl;
	}
	
	public void afficher() {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length;  j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	public boolean checkBoundary(int x, int y) {
		if (x<0 || y<0 || x>=map.length || y>=map[0].length ||map[x][y]=='#' ){
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public void setPlayer(Player p1) {
		if(!checkBoundary(p1.getX(),p1.getY())) {
			throw new RuntimeException("Out of bounds");
		}
		else {
			map[p1.getX()][p1.getY()]='☺';
		}
	}
	
	public void movePlayer(Player p, Direction d) {
	    if (p == null) throw new IllegalArgumentException("No player provided");
	    if (d == null) {
	        System.out.println("⚠ Invalid Key");
	        return; 
	    }
	    int nx = p.getX();
	    int ny = p.getY();
	    switch (d) {
	        case W -> nx--;
	        case S -> nx++;
	        case D -> ny++;
	        case A -> ny--;
	    }
	    if (this.checkBoundary(nx, ny)) {
	        map[p.getX()][p.getY()] = ' '; 
	        p.setXY(nx, ny);               
	        this.setPlayer(p);        
	    }
	}


}
