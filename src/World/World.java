package World;

public class World {
	public char[][] map;
	
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
	
}
