package world;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;

public class World {
	public Cellule[][] map;
	private int nbPiece=0;
	public int maxX;
	public int maxY;
	
	public int getPiece() {
		return nbPiece;
	}

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
		                case 'P' -> Cellule.Type.PORTE;
		                case '1' -> Cellule.Type.PLAYER;
		                case '$' -> {nbPiece++; yield Cellule.Type.PIECE;}
		                default  -> Cellule.Type.VIDE;
		                };
	                map[i][j] = new Cellule(i,j,typeChoisi);
				}
			}
		} catch (IOException e) {
	        System.out.println("⚠ Can't load level, wrong path");
		}
	}
	
	public void afficher() {
		for(int i=0; i<maxX; i++) {
			for(int j=0; j<maxY;  j++) {
				System.out.print(map[i][j].getTexture());
			}
			System.out.println();
		}
	}
	
}
	
	