package Main; 

import Player.*; 
import World.*;
import World.World.Direction;
import java.util.Scanner;

public class Main { 

    private static boolean askPlayAgain(Scanner sc, Player p) {
        for (int i = 0; i < 50; ++i) System.out.println();
        
        while (true) {
            System.out.println("┌────────────────────────┐");
            System.out.println("│        GAME OVER !     │");
            System.out.println("│        Try again ?     │");
            System.out.println("│    [Y]: Yes   [N]: No  │");
            System.out.println("└────────────────────────┘");
            System.out.print("▶ " + p + " : ");
            
            String choice = sc.nextLine().toUpperCase();
            
            if (choice.equals("Y")) {
                return true;
            } else if (choice.equals("N")) {
                System.out.println("┌────────────────────────┐");
                System.out.println("│        GOOD BYE !      │");
                System.out.println("└────────────────────────┘");
                return false;
            }
        }
    }

    public static void main(String[] args) {
        
        if (args.length == 0) {
            System.out.println	("⚠ Can't load level, wrong path");
            return; 
        }
        String level = args[0];
        
        Player p1 = new Player("Alice");
        Scanner sc = new Scanner(System.in);
        boolean play = true;
        
        World lvl = new World(level);
        p1.setXY(5, 6);
        lvl.setPlayer(p1);
        lvl.afficher();
        
        while(play) {
        	if(lvl.getPiece()==0) {
        		System.out.println("--> Vous avez toutes les pieces");
        	}
            if (p1.getLife() <= 0) {
                boolean wantsToRetry = askPlayAgain(sc, p1);
                
                if (wantsToRetry) {
                    p1.reset();
                    lvl = new World(level);
                    lvl.setPlayer(p1);
                    lvl.afficher();
                    continue; 
                } else {
                    break;
                }
            }

            System.out.println("┌─────────────────────────┐");
            System.out.println("│    [Z]                  │");
            System.out.println("│ [Q][S][D]  [M]: to quit │");
            System.out.println("└─────────────────────────┘");
            System.out.print("▶ " + p1 + " : ");
            
            String input = sc.nextLine().toUpperCase();

            if(input.equals("M")) {
                System.out.println("Good Bye");
                break; 
            }
            
            Direction d = switch (input) {
                case "W", "Z" -> Direction.W;
                case "A", "Q" -> Direction.A;
                case "S" -> Direction.S;
                case "D" -> Direction.D;
                default -> null;
            };

            if (d == null) {
                System.out.println("⚠ Invalid Key"); 
            } else {
                lvl.movePlayer(p1, d);
                lvl.afficher();
            } 
        }

        sc.close();
    }
}