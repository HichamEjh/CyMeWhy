package Main; 
import Player.*; 
import World.*;
import World.World.Direction;

import java.util.Scanner;


public class Main { 

	public static void main(String[] args) {
        Player p1 = new Player("Alice");
        Scanner sc = new Scanner(System.in);
        
        char[][] lvl1 = {
                {'#', '#', '#', '#', '#','#','#','#','#','#','#'},
                {'#', ' ', ' ', ' ',' ',' ',' ',' ',' ',' ', '#'},
                {'#', ' ', ' ', ' ',' ',' ',' ',' ',' ',' ', '#'},
                {'#', ' ', ' ', ' ',' ',' ',' ',' ',' ',' ', '#'},
                {'#', ' ', ' ', ' ',' ',' ',' ',' ',' ',' ', '#'},
                {'#', ' ', ' ', ' ',' ',' ',' ',' ',' ',' ', '#'},
                {'#', ' ', ' ', ' ',' ',' ',' ',' ',' ',' ', '#'},
                {'#', '#', '#', '#', '#','#','#','#','#','#','#'},
                
            };
        
        World lvl = new World(lvl1);
        p1.setXY(5, 6);
        lvl.setPlayer(p1.x, p1.y);
        lvl.afficher();
        
        while(true) {
    		System.out.println("════════════════════════");
        	System.out.println("   [Z]     ");
        	System.out.println("[Q][S][D]  [M]: to quit");
        	System.out.println("════════════════════════");
        	System.out.print("▶ ");
        	String input = sc.nextLine().toUpperCase();
            if(input.equals("M")) { break; }
            
            Direction d = switch (input) {
            	case "W" -> Direction.W;
            	case "A" -> Direction.A;
            	case "S" -> Direction.S;
            	case "D" -> Direction.D;
            	case "Q" -> Direction.A;
            	case "Z" -> Direction.W;
            	default -> null;
            };
            if (d == null) {
    	        System.out.println("⚠ Invalid Key"); 
    	    }
            else {
            	lvl.movePlayer(p1, d);
            } 
        }
        
        
        
        
    }
}