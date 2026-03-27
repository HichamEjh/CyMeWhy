package World;
import Player.*; 
import World.Cellule.Type;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;

public class World {
	public Cellule[][] map;
	public static enum Direction {W,S,D,A};
	private int nbPiece=0;
	private int maxX;
	private int maxY;
	
	//
	public int getPiece() {
		return nbPiece;
	}

	//Load image
	public World(String grille) {
		
		try {
			Path chemin = Path.of(grille);
			List <String> lignes = Files.readAllLines(chemin);
			
			maxX = lignes.size();
			maxY = lignes.get(0).length();
			this.map = new Cellule[maxX][maxY];
			
			for(int i=0; i<maxX; i++) {
				for(int j=0; j<maxY;j++) {
					char c = lignes.get(i).charAt(j);
					Cellule.Type typeChoisi = switch(c) {
		                case '#' -> Cellule.Type.MUR;
		                case 'X' -> Cellule.Type.PIEGE;
		                case '$' -> {nbPiece++; yield Cellule.Type.PIECE;}
		                default  -> Cellule.Type.VIDE;
		                };
	                map[i][j]=new Cellule(i,j,typeChoisi);
				}
					
			}
		} catch (IOException e) {
	        System.out.println("⚠ Can't load level, wrong path");
		}
	}
	
	//Affichage
	public void afficher() {
		for(int i=0; i<maxX; i++) {
			for(int j=0; j<maxY;  j++) {
				System.out.print(map[i][j].getTexture());
			}
			System.out.println();
		}
	}
	
	
	//Set Player
	public void setPlayer(Player p) {
		if(map[p.getX()][p.getY()].getType()== Type.MUR) {
			throw new RuntimeException("Out of bounds");
		}
		else {
			this.map[p.getX()][p.getY()] = new Cellule(p.getX(),p.getY(),Type.PLAYER);
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
	    if (map[nx][ny].getBloque()==false) {
	        map[p.getX()][p.getY()] = new Cellule(p.getX(),p.getY(),Type.VIDE);
	        verifTiles(p,nx,ny);
	    }
	}

	public void verifTiles(Player p, int nx,int ny) {
		switch (map[nx][ny].getType()) {
			case Type.PIECE -> {
				p.updateScore(10);
				nbPiece--;
				p.setXY(nx, ny);               
			    setPlayer(p); 
			}
			case Type.PIEGE -> {
				map[nx][ny] = new Cellule(nx,ny,Type.VIDE);
				p.updateLife(-2);
				p.respawn();
				setPlayer(p);
				return;
			}
			default -> {
				p.setXY(nx, ny);               
			    setPlayer(p); 
			}
		}
		
	}

}
