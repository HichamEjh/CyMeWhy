package Player;

/**
 * @author Hicham
 * @version w1.00.00
 */
public class Player {
	private String name;
	private int score;

	/**
	 * Define all parameter
	 * 
	 * @param nm player's name
	 */
	public Player(String nm) {
		name = nm;
		score = 0;
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
		return this.getName() + ":" + this.getScore() + ((this.getScore() <= 1) ? "pt" : "pts"); //Put an 's' for the plural.
	}

	/*
	 * main
	 */
	public static void main(String[] args) {
		Player p1 = new Player("Alice");
		Player p2 = new Player("Kara");
		//turn 1
		p1.setScore(1);
		p2.setScore(2);
		System.out.println("==Turn 1\n" + p1.toString() + "\n" + p2.toString() + "\n");
		//turn 2
		p1.updateScore(1);
		p2.updateScore(-1);
		System.out.println("==Turn 2\n" + p1.toString() + "\n" + p2.toString() + "\n");
		//
	}
}