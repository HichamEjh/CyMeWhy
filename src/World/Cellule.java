package world;

public class Cellule {
	
	public enum Type {
        MUR('#', true), 
        PIEGE('X', false), 
        PIECE('$', false), 
        VIDE(' ', false), 
        PLAYER('1', false), 
        PORTE('P', true);

        private final char symbole;
        private final boolean isSolid;

        Type(char symbole, boolean isSolid) {
            this.symbole = symbole;
            this.isSolid = isSolid;
        }

        public char getSymbole() { return symbole; }
        public boolean isSolid() { return isSolid; }
    }
	
	private final int x;
	private final int y;
	private Type type;
	
	public Cellule(int x, int y, Type type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	public String toString() {
		return "x: " + this.x + " y: " + this.y + " Type: " + this.type;
	}
	
	public char getTexture() {
		return type.getSymbole(); 
	}
	
	public boolean isSolid() {
		return type.isSolid(); 
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public Type getType() { return type; }
}