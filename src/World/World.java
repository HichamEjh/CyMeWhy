package world;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;

import entity.Entity;
import entity.Zombie;

public class World {
	public Cellule[][] map;
	private int nbPiece = 0;
	private int maxX;
	private int maxY;	
	private Entity player;
	public int getPiece() {
		return nbPiece;
	}
	public void minusPiece() {
		this.nbPiece--;
	}
	public Entity getPlayer() {
		return player;
	}
	public int getMaxX() {
		return maxX;
	}
	public int getMaxY() {
		return maxY;
	}
	
	
	
	public World(String grille, List<Entity> entity ) {
		player = entity.get(0);
		try {
			Path chemin = Path.of(grille);
			List<String> lignes = Files.readAllLines(chemin);
			maxX = lignes.size();
			maxY = lignes.get(0).length();
			this.map = new Cellule[maxX][maxY];
			int idMob=1;
			
			for(int i = 0; i < maxX; i++) {
				for(int j = 0; j < maxY; j++) {
					char c = lignes.get(i).charAt(j);
					boolean isPiece = false; 
					
					Cellule.Type typeChoisi = switch(c) {
						case '#' -> Cellule.Type.MUR;
						case 'X' -> Cellule.Type.PIEGE;
						case 'P' -> Cellule.Type.PORTE;
						case '1' -> {
							player.setSpawnX(i);
							player.setSpawnY(j);
							player.resetEntity();
							yield Cellule.Type.PLAYER;
						}
						case '$' -> {
							nbPiece++; 
							isPiece = true;
							yield Cellule.Type.VIDE; 
						}
						case 'Z' ->{
							entity.add(new Zombie("Zombie"+idMob));
							entity.get(idMob).setSpawnX(i);
							entity.get(idMob).setSpawnY(j);
							entity.get(idMob).resetEntity();
							idMob++;
							yield Cellule.Type.ZOMBIE; 
						}
						default  -> Cellule.Type.VIDE;
					};
					map[i][j] = new Cellule(i, j, typeChoisi);

					if (isPiece) {
						map[i][j].setPiece(true);
					}
				}
			}
		} catch (IOException e) {
			System.out.println("⚠ Can't load level, wrong path");
		}
	}
	
	public void afficher() {
        for (int i = 0; i < 50; ++i) System.out.println();
		for(int i = 0; i < maxX; i++) {
			for(int j = 0; j < maxY; j++) {
				System.out.print(map[i][j].getTexture());
			}
			System.out.println(); 	
		}
	}
	
	public void checkPlayerLife(List<Entity> ennemy) {
	    for(int i = 1 ; i < ennemy.size() ; i++) {
	        if((this.player.getX() == ennemy.get(i).getX()) && (this.player.getY() == ennemy.get(i).getY())) {
	            player.updateLife(-1);

	            ennemy.get(i).resetEntity();
	            
	            System.out.println("Collision ! Retour au départ.");
	        }
	    }
	}
	
}