package com.company;

import java.util.Scanner;

public class PlateauDeJeu {

    public static void affichagePlateau(){
        String p1 = "B"; // Joueur1
        String p2 = "R"; // Joueur2
        String currentPlayer = p1; // Joueur actuelle est p1

        String [][] matrice = new String[10][11];
        int ligne;
        int colonne;

        while(true){
            //remplir toutes les cases
            for (ligne=0; ligne<=9; ligne++){
                for (colonne =0; colonne<=10; colonne++){
                    matrice[ligne][colonne] = "*";
                    if (ligne ==4 && colonne==5){
                        matrice[ligne][colonne] = p1;
                    }
                    if (ligne ==5 && colonne==5){
                        matrice[ligne][colonne] = p2;
                    }

                }
            }

            //afficher toutes les cases
            for (ligne=0; ligne<=9; ligne++) {
                for (colonne = 0; colonne <=10; colonne++) {
                    System.out.print(" | " + matrice[ligne][colonne]);

                }
                //saute une ligne
                System.out.println(" | ");
            }
            System.out.println(currentPlayer + " a toi de jouer");
            Scanner scanner1 = new Scanner(System.in);
            String recupScanner = scanner1.next();
            // si joueur actuel est Joueur 1 il devient joueur 2
            if(currentPlayer == p1){
                currentPlayer = p2;
            }
            else{ // Si joueur 2 il devient joueur 1
                currentPlayer = p1;
            }
        }

        }

}
