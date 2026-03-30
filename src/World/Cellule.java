package world;

public class Cellule {
	
	public enum Type {
        MUR('#', true), 
        PIEGE('X', false), 
        VIDE(' ', false), 
        PLAYER('1', false), 
        ZOMBIE('Z', false), 
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
	private boolean hasPiece;
	
	public Cellule(int x, int y, Type type) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.hasPiece=false;
	}
	
	public String toString() {
		return "x: " + this.x + " y: " + this.y + " Type: " + this.type + " Piece: " + this.hasPiece;
	}
	public void setPiece(boolean hasPiece) {
		this.hasPiece=hasPiece;
	}
	public boolean getPiece() {
		return this.hasPiece;
	}
	public char getTexture() {
		if (this.hasPiece) {
			return '$';
		}
		return type.getSymbole();
	}
	
	public boolean isSolid() {
		return type.isSolid(); 
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public Type getType() { return type; }
}