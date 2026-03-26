package Player;

/**
 * @author Hicham
 * @version w1.00.00
 */
public class Player {
	private final String name;
	private int score;
	private int x;
	private int y;
	private int spawnx;
	private int spawny;
	private int life;
	private static int nbPlayer = 0;
	
	/**
	 * Define all parameter
	 * 
	 * @param nm player's name
	 */
	public Player(String nm) {
		name = nm;
		score = 0;
		x=5;
		y=6;
		spawnx=x;
		spawny=y;
		life=5;
		nbPlayer++;
	}
	
	/**
	 * Give generic name
	 */
	public Player() {
		this("Player"+ (nbPlayer+1));
		
	}
	
	public void setXY(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public void updateLife(int nb){
		life +=  nb;
	}
	
	public int getLife() {
		return life;
	}
	
	/**
	 * Return the x
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Return the x
	 * 
	 * @return x
	 */
	public int getY() {
		return y;
	}
	

	public int getSpawnX() {
		return spawnx;
	}
	
	public void respawn() {
		x=spawnx;
		y=spawny;
	}
	
	
	public int getSpawnY() {
		return spawny;
	}

	/**
	 * Return the player's name
	 * 
	 * @return player's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Return the player's score
	 * 
	 * @return player's score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Return the number of player
	 * 
	 * @return number of player
	 */
	public static int getNumber() {
		return nbPlayer;
	}
	
	public void reset() {
		score = 0;
		life=5;
	}
	
	/**
	 * Set player's score
	 * 
	 * @param scr player's score
	 */
	public void setScore(int scr) {
		score = (scr >= 0) ? scr : 0;
	}

	/**
	 * Update the player's score
	 * 
	 * @param scr player's score
	 */
	public void updateScore(int scr) {
		score = (score + scr > 0) ? score + scr : 0; //Avoid negative score
	}

	/**
	 * Display score of the player
	 */
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append(this.getName()+" ");
	    for (int i = 0; i < life; i++) {
	        sb.append("❤");
	    }
	    sb.append("|").append(this.getScore());
	    if (this.getScore() <= 1) {
	        sb.append("pt");
	    } else {
	        sb.append("pts");
	    }
	    return sb.toString();
	}

	/**
	 * equals test
	 */
	public boolean equals(Object obj) {
        if (this == obj) return true;
        
        if (obj == null || !(obj instanceof Player)) return false;
        
        Player other = (Player) obj;
        
        return this.name.equalsIgnoreCase(other.name);
    }
	
	

}