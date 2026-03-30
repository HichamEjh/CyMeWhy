package main; 

import entity.*;
import world.*;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Main { 


	private static boolean askPlayAgain(Scanner sc, Entity p) {
        for (int i = 0; i < 50; ++i) System.out.println();
        
        while (true) {
            System.out.println("┌────────────────────────┐");
            System.out.println("│       GAME OVER !      │");
            System.out.println("│       Try again ?      │");
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
            System.out.println("⚠ Veuillez passer le chemin du dossier contenant les niveaux en argument.");
            return; 
        }
        
        File folder = new File(args[0]);
        File[] listOfFiles;
        
        if (folder.isDirectory()) {
            listOfFiles = folder.listFiles();
            if (listOfFiles != null) {
                Arrays.sort(listOfFiles); 
            }
        } else {
            listOfFiles = new File[] { folder };
        }
        
        if (listOfFiles == null || listOfFiles.length == 0) {
            System.out.println("⚠ Aucun fichier de niveau trouvé.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("┌────────────────────────┐");
        System.out.println("│ Enter your player name │");
        System.out.println("└────────────────────────┘");
        System.out.print("▶ ??? : ");
        String playerName = sc.nextLine();
        //##############################################"""
        //##############################################"""
       //##############################################"""
       //##############################################"""
       //##############################################"""
        List<Entity> entity = new ArrayList<>();
        entity.add(new Player(playerName));
        Entity player = entity.get(0);
    	
        for (int i = 0; i < listOfFiles.length; i++) {
            
            if (listOfFiles[i].isFile()) {
                String level = listOfFiles[i].getAbsolutePath();
                
                World lvl = new World(level, entity);
                
                for (int k = 0; k < 50; k++) System.out.println();
                lvl.afficher();
                
                boolean levelFinished = false;
                
                while (!levelFinished) {
                	
                    if (lvl.getPiece() == 0) {
                    	System.out.println("┌────────────────────────┐");
                        System.out.println("│   You have collected   │");
                        System.out.println("│     all the pieces!    │");
                        System.out.println("│        Thanks you      │");
                        System.out.println("└────────────────────────┘");
                        levelFinished = true;
                        continue; 
                    }
                    
                    if (player.getLife() <= 0) {
                        boolean wantsToRetry = askPlayAgain(sc, player);
                        
                        if (wantsToRetry) {
                            player.resetEntity(); 
                            i = -1;     
                            break;     
                        } else {
                        	System.out.println("Good Bye");
                            sc.close();
                            return; 
                        }
                    }
                    System.out.println("┌─────────────────────────┐");
                    System.out.println("│            [LEVEL : " + (i + 1) + "]  │ ");
                    System.out.println("│    [Z]                  │");
                    System.out.println("│ [Q][S][D]               │");
                    System.out.println("└─────────────────────────┘");
                    System.out.print( player + " : ");
                    
                    for(Entity e : entity) {
                    	e.moveEntity(lvl);
                    }
                    
                    lvl.afficher();
                    
                    
                }
            }
        }
        
        sc.close();
    }
}