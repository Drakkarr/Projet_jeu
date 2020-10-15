package com.company;

import java.util.Scanner;

public class PlateauDeJeu {


    public static int inputValueLigne() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return input;
        /**
         * Cette fonction permet de séléctionner une ligne pour la destruction
         */
    }

    public static int inputValueColonne() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return input;
        /**
         * Cette fonction permet de séléctionner une colonne pour la destruction
         */
    }

    public static void affichagePlateau() {
        String p1 = "B"; // Joueur1
        String p2 = "R"; // Joueur2
        String currentPlayer = p1; // Joueur actuelle est p1

        String[][] matrice = new String[10][11];
        int ligne;
        int colonne;


        //remplir toutes les cases
        for (ligne = 0; ligne <= 9; ligne++) {
            for (colonne = 0; colonne <= 10; colonne++) {
                matrice[ligne][colonne] = "*";
                //placer le joueur 1
                if (ligne == 4 && colonne == 5) {
                    matrice[ligne][colonne] = p1;
                }
                //placer le joueur 2
                if (ligne == 5 && colonne == 5) {
                    matrice[ligne][colonne] = p2;
                }

            }
        }

            //afficher toutes les cases
            for (ligne = 0; ligne <= 9; ligne++) {
                for (colonne = 0; colonne <= 10; colonne++) {
                    System.out.print(" | " + matrice[ligne][colonne]);

                }
                //saute une ligne
                System.out.println(" | ");
            }
        while (true) {
            System.out.println(currentPlayer + " a toi de jouer");

            //déclarer une variable pour choisir une ligne
            int choixP1ligne = inputValueLigne();
            //déclarer une variable pour choisir une colonne
            int choixP1colonne = inputValueColonne();


            if (currentPlayer==p1){
                //si joueur = p1 et que la case séléctionnée est déjà détruite ou occupée par un joueur, p1 rejoues
                if ((matrice[choixP1colonne][choixP1ligne].equals("X")) || (matrice[choixP1colonne][choixP1ligne].equals("B")) || (matrice[choixP1colonne][choixP1ligne].equals("R"))){
                    System.out.println("B tu rejoues car la case est occupée");
                    currentPlayer=p1;
                //si joueur = p1 et que la case séléctiopnnée est vide, p1 peut jouer
                }else if ((matrice[choixP1colonne][choixP1ligne]!= "X") && (matrice[choixP1colonne][choixP1ligne]!= "B") && (matrice[choixP1colonne][choixP1ligne]!= "R")) {
                    matrice[choixP1colonne][choixP1ligne] = "X";
                    currentPlayer = p2;
                }
            }else if (currentPlayer==p2) {
                //si joueur = p2 et que la case séléctionnée est déjà détruite ou occupée par un joueur, p2 rejoues
                if ((matrice[choixP1colonne][choixP1ligne].equals("X")) || (matrice[choixP1colonne][choixP1ligne].equals("B")) || (matrice[choixP1colonne][choixP1ligne].equals("R"))){
                    System.out.println("R tu rejoues car la case est occupée");
                    currentPlayer=p2;
                //si joueur = p2 et que la case séléctionnée est vide, p2 peut jouer
                }else if ((matrice[choixP1colonne][choixP1ligne]!= "X") && (matrice[choixP1colonne][choixP1ligne]!= "B") && (matrice[choixP1colonne][choixP1ligne]!= "R")) {
                    matrice[choixP1colonne][choixP1ligne] = "X";
                    currentPlayer = p1;
                }
            }

            //afficher les cases
            for (ligne = 0; ligne <= 9; ligne++) {
                for (colonne = 0; colonne <= 10; colonne++) {
                    System.out.print(" | " + matrice[ligne][colonne]);
                }
                    //saute une ligne
                    System.out.println(" | ");
            }




        }
    }
}