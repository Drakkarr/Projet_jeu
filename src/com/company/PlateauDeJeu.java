package com.company;

import java.util.Random;
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

        //Déclaration de la couleur
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";

        //Scanner permettant d'entrer un pseudo pour le joueur 1
        Scanner scannerPseudoJoueur1 = new Scanner(System.in);
        System.out.println("Joueur 1 entre ton pseudo, tu seras le pion bleu");
        String pseudoJoueur1 = scannerPseudoJoueur1.next();

        //Scanner permettant d'entrer un pseudo pour le joueur 2
        Scanner scannerPseudoJoueur2 = new Scanner(System.in);
        System.out.println("Joueur 2 entre ton pseudo, tu seras le pion rouge");
        String pseudoJoueur2 = scannerPseudoJoueur2.next();

        //Permet d'assigner au joueur1 le pion B et y mettre la couleur bleue
        String p1 = ANSI_BLUE + "B" + ANSI_RESET;
        //Permet d'assigner au joueur1 le pion R et y mettre la couleur rouge
        String p2 = ANSI_RED +"R" + ANSI_RESET;

        String currentPlayer = null;
        String pseudoCurrentPlayer = null;

        //Faire en sorte que le joueur soit choisi aléatoirement
        //création d'un random entre 1 et 2
        Random aleatoire = new Random();
        int chiffreAléatoire = aleatoire.nextInt(2);

        //si le chiffre aléatoire est 2, au joueur p1 de jouer
        if (chiffreAléatoire %2 ==0){
            currentPlayer =p1;
            pseudoCurrentPlayer= pseudoJoueur1;

        //si le chiffre aléatoire est 1, au joueur p2 de jouer
        }else if (chiffreAléatoire %2 !=0){
            currentPlayer=p2;
            pseudoCurrentPlayer= pseudoJoueur2;
        }

        //Création de la matrice de jeu
        String[][] matrice = new String[10][11];
        int ligne;
        int colonne;


        //remplir toutes les cases
        for (ligne = 0; ligne <= 9; ligne++) {
            for (colonne = 0; colonne <= 10; colonne++) {
                matrice[ligne][colonne] = ANSI_YELLOW+ "*"+ ANSI_RESET;
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
            System.out.println(pseudoCurrentPlayer + " a toi de jouer");

            //déclarer une variable pour choisir une ligne
            int choixP1ligne = inputValueLigne();
            //déclarer une variable pour choisir une colonne
            int choixP1colonne = inputValueColonne();


            if (currentPlayer==p1){
                //si joueur = p1 et que la case séléctionnée est déjà détruite ou occupée par un joueur, p1 rejoues
                if ((matrice[choixP1colonne][choixP1ligne].equals("X")) || (matrice[choixP1colonne][choixP1ligne].equals(ANSI_BLUE + "B" + ANSI_RESET)) || (matrice[choixP1colonne][choixP1ligne].equals(ANSI_RED +"R" + ANSI_RESET))){
                    System.out.println(pseudoCurrentPlayer +" tu rejoues car la case est occupée");
                    currentPlayer=p1;
                //si joueur = p1 et que la case séléctiopnnée est vide, p1 peut jouer
                }else if ((!matrice[choixP1colonne][choixP1ligne].equals("X")) && (!matrice[choixP1colonne][choixP1ligne].equals(ANSI_BLUE + "B" + ANSI_RESET)) && (!matrice[choixP1colonne][choixP1ligne].equals(ANSI_RED +"R" + ANSI_RESET))) {
                    matrice[choixP1colonne][choixP1ligne] = "X";
                    currentPlayer = p2;
                    pseudoCurrentPlayer = pseudoJoueur2;
                }
            }else if (currentPlayer==p2) {
                //si joueur = p2 et que la case séléctionnée est déjà détruite ou occupée par un joueur, p2 rejoues
                if ((matrice[choixP1colonne][choixP1ligne].equals("X")) || (matrice[choixP1colonne][choixP1ligne].equals(ANSI_BLUE + "B" + ANSI_RESET)) || (matrice[choixP1colonne][choixP1ligne].equals("R"))){
                    System.out.println(pseudoCurrentPlayer + " tu rejoues car la case est occupée");
                    currentPlayer=p2;
                //si joueur = p2 et que la case séléctionnée est vide, p2 peut jouer
                }else if ((!matrice[choixP1colonne][choixP1ligne].equals("X")) && (!matrice[choixP1colonne][choixP1ligne].equals(ANSI_BLUE + "B" + ANSI_RESET)) && (!matrice[choixP1colonne][choixP1ligne].equals("R"))) {
                    matrice[choixP1colonne][choixP1ligne] = "X";
                    currentPlayer = p1;
                    pseudoCurrentPlayer = pseudoJoueur1;
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