package World;




public class Cellule {
	public enum Type {
        MUR, PIEGE, PIECE, VIDE, PLAYER, PORTE
    }
	
	private final int x;
	private final int y;
	private Type type;
	private boolean bloque;
	private char texture;
	
	public Cellule(int x,int y,Type type) {
		this.x = x;
		this.y = y;
		this.type = type;
		
		if (type == Type.MUR || type == Type.PORTE) {
            this.bloque = true;
        } 
		else {
            this.bloque = false;
        }
		
		this.texture = switch (type) {
        case MUR   -> '#';
        case PIEGE -> 'X';
        case PIECE -> '$';
        case VIDE  -> ' ';
        case PLAYER  -> '1';
        case PORTE -> 'P';
		};
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
	    sb.append("x : "+ this.x + "y : "+ this.y + "Type : "+ this.type);
	    return sb.toString();
	}
	//
	public  char getTexture() {
		return texture;
	}
	public int getX() {
		return x;
	}
	public boolean getBloque() {
		return bloque;
	}
	public int getY() {
		return y;
	}
	public Type getType(){
		return type;
	}
	//
}
