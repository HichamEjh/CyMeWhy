package World;
import Player.*; 

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
	
	public void setPlayer(Player p, int x,int y) {
		if (x<0 || y<0 || x>=map.length || y>=map[0].length){
			throw new RuntimeException("Out of bounds");
		}
		else {
			if(map[x][y]=='#') {
				throw new RuntimeException("In a wall");
			}
			else {
				map[x][y]='1';
			}
		}
			
		
	}
}
