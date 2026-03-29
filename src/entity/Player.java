package entity;


public class Player extends Entity {
	//##############################
	private int life;
	private int score;
	//##############################
	public Player(String name) {
		super(name);
		resetPlayer();
	}
	//##############################
	public int getLife() {
		return this.life;
	}
	public int getScore() {
		return this.score;
	}
	public void updateScore(int n) {
		this.score = (this.score +n >0) ? this.score + n : 0;
	}
	public void updateLife(int n) {
		this.life+=n;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
	    sb.append(super.toString()+" ");
	    for (int i = 0; i < life; i++) {
	        sb.append("❤");
	    }
	    if (this.getScore() <= 1) {
	        sb.append("| pt");
	    } else {
	        sb.append("| pts");
	    }
	    return sb.toString();
	}
	//##############################
	public void resetPlayer() {
		this.life=5;
		this.score=0;
	}

}


