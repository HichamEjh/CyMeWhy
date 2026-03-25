package Main; 
import Player.Player; 

public class Main { 
    public static void main(String[] args) {
    	
    	System.out.println("-== NB PLAYER : " + Player.getNumber());
        Player p1 = new Player("Alice");
        Player p2 = new Player("kara");
        Player p3 = new Player("KARA");
        Player p3new = p3;
        System.out.println("-== NB PLAYER : " + Player.getNumber());

        // Turn 1
        p1.setScore(1);
        p2.setScore(2);
        System.out.println("-==Turn 1\n" + p1.toString() + "\n" + p2.toString() + "\n");

        // Turn 2
        p1.updateScore(1);
        p2.updateScore(-1);
        System.out.println("-==urn 2\n" + p1.toString() + "\n" + p2.toString() + "\n");
        
        //Test
        System.out.println("\n-==Test");
        System.out.println("Alice equals \"Alice\" ? " + p1.equals("Alice")); 
        System.out.println("Alice equals kara ? " + p1.equals(p2)); 
        System.out.println("kara equals KARA? " + p2.equals(p3));
        System.out.println("kara == KARA ? " +(p2==p3));
        System.out.println("KARA equals same KARA ? " + (p3==p3new));
        
        //Remove
        p3 = null;
        p3new = null;
        
      //noName
        Player p4 = new Player();
        System.out.println("\n-==No Name");
        System.out.println(p4);

    }
}