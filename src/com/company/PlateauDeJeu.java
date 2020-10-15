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
        int stop = 0;


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
        System.out.println("    0   1   2   3   4   5   6   7   8   9  10");
        //afficher toutes les cases
        int ligneConteur=0;
        for (ligne = 0; ligne <= 9; ligne++) {
            for (colonne = 0; colonne <= 10; colonne++) {

                if (colonne==0){
                    System.out.print(ligneConteur);
                    ligneConteur++;
                }
                System.out.print(" | " + matrice[ligne][colonne]);
            }
            //saute une ligne
            System.out.println(" | ");
            System.out.println("   ---|---|---|---|---|---|---|---|---|---|--- ");
        }

        while (true) {
            System.out.println(pseudoCurrentPlayer + " selectionnez les touches [z][q][s][d] pour vous déplacer");
            Scanner mouvementJoueur = new Scanner(System.in);
            String recupmouvementJoueur = mouvementJoueur.next();

            if(recupmouvementJoueur.equals("z")){ // Mouvement vers le haut
                for (int i = 0; i <= 9; i++) { // Double boucle for pour vérifier tout le tableau
                    for (int j = 0; j <= 10; j++) {
                        if (matrice[i][j] == currentPlayer) { // Si dans la case il y a le joueur actuel
                            if(i > 0 && (matrice[i-1][j] ==  ANSI_YELLOW+ "*"+ ANSI_RESET)) {// Sorti de tableau et si la case prochaine est vide
                                matrice[i][j] = ANSI_YELLOW+ "*"+ ANSI_RESET; // efface précédente position
                                matrice[i - 1][j] = currentPlayer; // se déplace
                            }
                        }

                    }
                }
            }
            else if(recupmouvementJoueur.equals("s")){ // Mouvement vers le bas
                stop = 0; // Variable pour sortir de la boucle
                for (int i = 0; i <= 9; i++) { // Double boucle for pour vérifier tout le tableau
                    for (int j = 0; j <= 10; j++) {
                        if ((matrice[i][j] == currentPlayer) && (stop == 0)) {// Si dans la case il y a le joueur actuel et stop est toujours sur 0
                            if((i < 9) && (matrice[i+1][j] ==  ANSI_YELLOW+ "*"+ ANSI_RESET)){ // Sorti de tableau et si la case prochaine est vide
                                matrice[i][j] =  ANSI_YELLOW+ "*"+ ANSI_RESET; // efface précédente position
                                matrice[i + 1][j] = currentPlayer; // se déplace
                                stop++; // Stop va prendre +1 on ne rentrera plus dans la condiction
                            }
                        }

                    }
                }
            }
            else if(recupmouvementJoueur.equals("q")) { // Mouvement vers la gauche
                for (int i = 0; i <= 9; i++) { // Double boucle for pour vérifier tout le tableau
                    for (int j = 0; j <= 10; j++) {
                        if (matrice[i][j] == currentPlayer) {// Si dans la case il y a le joueur actuel
                            if (j > 0 && (matrice[i][j - 1] == ANSI_YELLOW + "*" + ANSI_RESET)) { // Sorti de tableau et si la case prochaine est vide
                                matrice[i][j] = ANSI_YELLOW + "*" + ANSI_RESET; // efface précédente position
                                matrice[i][j - 1] = currentPlayer; // se déplace
                            }


                        }
                    }
                }
            }else if(recupmouvementJoueur.equals("d")){ // Mouvement vers la droite
                for (int i = 0; i <= 9; i++) { // Double boucle for pour vérifier tout le tableau
                    for (int j = 0; j <= 10; j++) {
                        if (matrice[i][j] == currentPlayer) { // Si dans la case il y a le joueur actuel
                            if(j < 10 && (matrice[i][j + 1] == ANSI_YELLOW+ "*"+ ANSI_RESET)){ // Sorti de tableau et si la case prochaine est vide
                                matrice[i][j] =  ANSI_YELLOW+ "*"+ ANSI_RESET; // efface précédente position
                                matrice[i][j + 1] = currentPlayer; // se déplace
                                break;
                            }
                        }

                    }
                }
            }
            else{
                System.out.println("commande non valide");
            }
            System.out.println(pseudoCurrentPlayer + " détruis une case");

            System.out.println("choisis un numéro de ligne");
            //déclarer une variable pour choisir une ligne
            int choixP1ligne = inputValueLigne();

            System.out.println("choisis un numéro de colonne");
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
            System.out.println("    0   1   2   3   4   5   6   7   8   9  10");
            //afficher toutes les cases
            ligneConteur=0;
            for (ligne = 0; ligne <= 9; ligne++) {
                for (colonne = 0; colonne <= 10; colonne++) {

                    if (colonne==0){
                        System.out.print(ligneConteur);
                        ligneConteur++;
                    }
                    System.out.print(" | " + matrice[ligne][colonne]);
                }
                //saute une ligne
                System.out.println(" | ");
                System.out.println("   ---|---|---|---|---|---|---|---|---|---|--- ");
            }
        }
    }
}