package World;
import Player.*; 

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;

public class World {
	public char[][] map;
	public static enum Direction {W,S,D,A};
	private int nbPiece=0;

	
	public World(String map) {
		try {
			Path chemin = Path.of(map);
			List <String> lignes = Files.readAllLines(chemin);
			
			int nbLignes = lignes.size();
			int nbColonnes = lignes.get(0).length();
			
			this.map= new char[nbLignes][nbColonnes];
			
			for(int i=0; i<nbLignes; i++) {
				
				this.map[i]=lignes.get(i).toCharArray();
			}
		} catch (IOException e) {
	        System.out.println("⚠ Can't load level, wrong path");
		}
	}
	
	public void afficher() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		nbPiece=0;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length;  j++) {
				System.out.print(map[i][j]);
				if(map[i][j]=='$') {
					nbPiece++;
				}
			}
			System.out.println();
		}
	}
	
	public int getPiece() {
		return nbPiece;
		
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
			map[p1.getX()][p1.getY()]='0';
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
	        verifTiles(p,nx,ny);
	    }
	}

	public void verifTiles(Player p, int nx,int ny) {
		if(map[nx][ny]=='$') {
			p.updateScore(10);
			
		}
		else if(map[nx][ny]=='X') {
			map[nx][ny]=' ';
			p.updateLife(-2);
			p.respawn();
			setPlayer(p);
			return;
			
		}
		p.setXY(nx, ny);               
	    setPlayer(p); 

	}

}
