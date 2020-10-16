package com.company;

import java.util.Random;
import java.util.Scanner;

public class PlateauDeJeu {
    static String[][] matrice = new String[10][11];


    public static int insérerValeurColonne() {

        /**
         * Cette classe insérerValeurColonne est caractérisée par les informations suivantes :
         * Cette fonction permet de séléctionner une colonne pour la destruction
         */

        // Scanner permettant de récupérer le numéro de la ligne.
        Scanner scanneur = new Scanner(System.in);
        int récupérationLignes = scanneur.nextInt();
        return récupérationLignes;

    }

    public static int insérerValeurLigne() {
        /**
         * Cette classe insérerValeurLigne est caractérisée par les informations suivantes :
         * Cette fonction permet de séléctionner une ligne pour la destruction
         */


        // Scanner permettant de récupérer le numéro de la colonne.
        Scanner scanneur = new Scanner(System.in);
        return scanneur.nextInt();

    }

    public static void affichagePlateau() {

        // Déclaration de la variable couleur

        final String réinitialisationCouleur = "\u001B[0m";
        final String couleurRouge = "\u001B[31m";
        final String couleurJaune = "\u001B[33m";
        final String couleurBleue = "\u001B[34m";

        // Scanneur permettant d'entrer un pseudo pour le joueur 1 entre 2 et 10 caractères
        String pseudoJoueur1;
        System.out.println("Joueur 1 entre ton pseudo entre 2 et 10 caractères, tu seras le pion bleu");
        while (true) {
            Scanner scanneurPseudoJoueur1 = new Scanner(System.in);
            pseudoJoueur1 = scanneurPseudoJoueur1.next();
            if (pseudoJoueur1.length()<=10 && pseudoJoueur1.length()  >=2){
                break;
            }else{
                System.out.println("merci d'entrer un pseudo entre 2 et 10 caractères");
            }
        }
        // Scanneur permettant d'entrer un pseudo pour le joueur 2
        String pseudoJoueur2;
        System.out.println("Joueur 2 entre ton pseudo entre 2 et 10 caractères, tu seras le pion rouge");
        while (true) {
            Scanner scanneurPseudoJoueur2 = new Scanner(System.in);
            pseudoJoueur2 = scanneurPseudoJoueur2.next();
            if (pseudoJoueur2.length()<= 10 && pseudoJoueur2.length()>=2){
                break;
            }else{
                System.out.println("merci d'entrer un pseudo entre 2 et 10 caractères");
            }
        }
        // Variable permettant d'assigner au joueur1 le pion B et la couleur bleue

        String p1 = couleurBleue + "B" + réinitialisationCouleur;

        // Variable permettant d'assigner au joueur1 le pion R et la couleur rouge.

        String p2 = couleurRouge + "R" + réinitialisationCouleur;

        // Variables permettant de choisir aléatoirement le pion et la couleur.

        String joueurActuel;
        String pseudoJoueurActuel;

        // Création d'un random (aléatoire) entre 1 et 2 pour générer un nombre aléatoire.

        Random aleatoire = new Random();
        int chiffreAléatoire = aleatoire.nextInt(2);

        // Si le chiffre aléatoire est 2, c'est au joueur p1 de jouer.

        if (chiffreAléatoire % 2 == 0) {
            joueurActuel = p1;
            pseudoJoueurActuel = pseudoJoueur1;

            // Si le chiffre aléatoire est 1, c'est au joueur p2 de jouer.

        } else {
            joueurActuel = p2;
            pseudoJoueurActuel = pseudoJoueur2;
        }

        // Création de la matrice de jeu


        int ligne;
        int colonne;
        int stop;


        // Création d'une double boucle for à plusieurs conditions pour remplir toutes les cases.

        for (ligne = 0; ligne <= 9; ligne++) {
            for (colonne = 0; colonne <= 10; colonne++) {
                matrice[ligne][colonne] = couleurJaune + "*" + réinitialisationCouleur;

                // Placement du joueur 1.

                if (ligne == 4 && colonne == 5) {
                    matrice[ligne][colonne] = p1;
                }

                // Placement du joueur 2.

                if (ligne == 5 && colonne == 5) {
                    matrice[ligne][colonne] = p2;
                }

            }
        }

        // Fin de la double boucle for

        // Création du'un boucle for pour afficher toutes les cases.

        System.out.println("    0   1   2   3   4   5   6   7   8   9  10");
        //afficher toutes les cases
        int ligneOrdonnéeConteur=0;

        // Création d'une boucle for pour afficher les cases.

        for (ligne = 0; ligne <= 9; ligne++) {
            for (colonne = 0; colonne <= 10; colonne++) {

                if (colonne==0){
                    System.out.print(ligneOrdonnéeConteur);
                    ligneOrdonnéeConteur++;

                }
                System.out.print(" | " + matrice[ligne][colonne]);
            }

            //saute une ligne
            System.out.println(" | ");
            System.out.println("   ---|---|---|---|---|---|---|---|---|---|--- ");
            // Saut de ligne

            System.out.print("");
        }
        int boucle = 0;
        while (boucle == 0) {

            // Fin de la boucle for.

            // Création d'une boucle while à plusieurs conditions permettant de se déplacer sur le plateau de jeu.
            boolean flag = false;
            while (!flag) {
            System.out.println(pseudoJoueurActuel + " selectionnez les touches [z][q][s][d] pour vous déplacer");
            Scanner mouvementJoueur = new Scanner(System.in);
            String recupérationMouvementJoueur = mouvementJoueur.next();

            // Mouvement vers le haut

                if (recupérationMouvementJoueur.equals("z")) {
                    for (ligne = 0; ligne <= 9; ligne++) { // Double boucle for pour vérifier tout le tableau
                        for (colonne = 0; colonne <= 10; colonne++) {
                            if (matrice[ligne][colonne] == joueurActuel) { // Si dans la case il y a le joueur actuel
                                if (ligne > 0 && (matrice[ligne - 1][colonne] == couleurJaune + "*" + réinitialisationCouleur)) {// Sorti de tableau et si la case prochaine est vide
                                    matrice[ligne][colonne] = couleurJaune + "*" + réinitialisationCouleur; // efface précédente position
                                    matrice[ligne - 1][colonne] = joueurActuel; // se déplace
                                    flag = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                // Mouvement vers le bas
                else if (recupérationMouvementJoueur.equals("s")) {
                    stop = 0; // Variable pour sortir de la boucle
                    for (ligne = 0; ligne <= 9; ligne++) { // Double boucle for pour vérifier tout le tableau
                        for (colonne = 0; colonne <= 10; colonne++) {
                            if ((matrice[ligne][colonne] == joueurActuel) && (stop == 0)) {// Si dans la case il y a le joueur actuel et stop est toujours sur 0
                                if ((ligne < 9) && (matrice[ligne + 1][colonne] == couleurJaune + "*" + réinitialisationCouleur)) { // Sorti de tableau et si la case prochaine est vide
                                    matrice[ligne][colonne] = couleurJaune + "*" + réinitialisationCouleur; // efface précédente position
                                    matrice[ligne + 1][colonne] = joueurActuel; // se déplace
                                    stop++; // Stop va prendre +1 on ne rentrera plus dans la condition
                                    flag=true;
                                    break;
                                }
                            }
                        }
                    }
                }
                // Mouvement vers la gauche
                else if (recupérationMouvementJoueur.equals("q")) {
                    for (ligne = 0; ligne <= 9; ligne++) { // Double boucle for pour vérifier tout le tableau
                        for (colonne = 0; colonne <= 10; colonne++) {
                            if (matrice[ligne][colonne] == joueurActuel) {// Si dans la case il y a le joueur actuel
                                if (colonne > 0 && (matrice[ligne][colonne - 1] == couleurJaune + "*" + réinitialisationCouleur)) { // Sorti de tableau et si la case prochaine est vide
                                    matrice[ligne][colonne] = couleurJaune + "*" + réinitialisationCouleur; // efface précédente position
                                    matrice[ligne][colonne - 1] = joueurActuel; // se déplace
                                    flag=true;
                                }
                            }
                        }
                    }
                }
                else if (recupérationMouvementJoueur.equals("d")) { // Mouvement vers la droite
                    for (ligne = 0; ligne <= 9; ligne++) { // Double boucle for pour vérifier tout le tableau
                        for (colonne = 0; colonne <= 10; colonne++) {
                            if (matrice[ligne][colonne] == joueurActuel) { // Si dans la case il y a le joueur actuel
                                if (colonne < 10 && (matrice[ligne][colonne + 1] == couleurJaune + "*" + réinitialisationCouleur)) { // Sorti de tableau et si la case prochaine est vide
                                    matrice[ligne][colonne] = couleurJaune + "*" + réinitialisationCouleur; // efface précédente position
                                    matrice[ligne][colonne + 1] = joueurActuel; // se déplace
                                    flag  = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                else {
                    System.out.println("commande non valide");
                }
            }

            System.out.println(pseudoJoueurActuel + " à toi de détruire une case");

            // Fin de la double boucle

            // Variable permettant de choisir une ligne
            System.out.println("Entrez un numéro de ligne");
            int choixP1Ligne = insérerValeurLigne();

            // Variable permettant de choisir une colonne
            System.out.println("Entrez un numéro de colonne");

            int choixP1Colonne = insérerValeurColonne();


            if (joueurActuel == p1) {
                //si joueur = p1 et que la case séléctionnée est déjà détruite ou occupée par un joueur, p1 rejoue
                if ((matrice[choixP1Ligne][choixP1Colonne].equals("X")) || (matrice[choixP1Ligne][choixP1Colonne].equals(couleurBleue + "B" + réinitialisationCouleur)) || (matrice[choixP1Ligne][choixP1Colonne].equals(couleurRouge + "R" + réinitialisationCouleur))) {
                    System.out.println(pseudoJoueurActuel + " tu rejoues car la case est occupée");
                    joueurActuel = p1;
                    //si joueur = p1 et que la case séléctiopnnée est vide, p1 peut jouer
                } else if ((!matrice[choixP1Ligne][choixP1Colonne].equals("X")) && (!matrice[choixP1Ligne][choixP1Colonne].equals(couleurBleue + "B" + réinitialisationCouleur)) && (!matrice[choixP1Ligne][choixP1Colonne].equals(couleurRouge + "R" + réinitialisationCouleur))) {
                    matrice[choixP1Ligne][choixP1Colonne] = "X";
                    joueurActuel = p2;
                    pseudoJoueurActuel = pseudoJoueur2;
                }
            } else if (joueurActuel == p2) {
                //si joueur = p2 et que la case séléctionnée est déjà détruite ou occupée par un joueur, p2 rejoue
                if ((matrice[choixP1Ligne][choixP1Colonne].equals("X")) || (matrice[choixP1Ligne][choixP1Colonne].equals(couleurBleue + "B" + réinitialisationCouleur)) || (matrice[choixP1Ligne][choixP1Colonne].equals("R"))) {
                    System.out.println(pseudoJoueurActuel + " tu rejoues car la case est occupée");
                    joueurActuel = p2;
                    //si joueur = p2 et que la case séléctionnée est vide, p2 peut jouer
                } else if ((!matrice[choixP1Ligne][choixP1Colonne].equals("X")) && (!matrice[choixP1Ligne][choixP1Colonne].equals(couleurBleue + "B" + réinitialisationCouleur)) && (!matrice[choixP1Ligne][choixP1Colonne].equals("R"))) {
                    matrice[choixP1Ligne][choixP1Colonne] = "X";
                    joueurActuel = p1;
                    pseudoJoueurActuel = pseudoJoueur1;
                }
            }
            // Condition de victoire
            for (ligne = 0; ligne <= 9; ligne++) { // Double boucle for pour vérifier tout le tableau
                for (colonne = 0; colonne <= 10; colonne++) {
                    if (matrice[ligne][colonne] == joueurActuel) { // Si dans la case il y a le joueur actuel
                        if ((matrice[ligne + 1][colonne] != couleurJaune + "*" + réinitialisationCouleur) && (matrice[ligne - 1][colonne] != couleurJaune + "*" + réinitialisationCouleur) && (matrice[ligne][colonne + 1] != couleurJaune + "*" + réinitialisationCouleur) && (matrice[ligne - 1][colonne] != couleurJaune + "*" + réinitialisationCouleur)) {
                            // Si Verifie dans toutes les cases autour de lui si il n'y a pas de case libre le joueur a perdu
                            System.out.println(pseudoJoueurActuel + " a perdu");
                            boucle = 1; // la boucle du plateau se ferme
                        }
                    }

                }
            }

            System.out.println("    0   1   2   3   4   5   6   7   8   9  10");
            //afficher toutes les cases
            ligneOrdonnéeConteur = 0;

            // Création d'une boucle for pour afficher les cases.

            for (ligne = 0; ligne <= 9; ligne++) {
                for (colonne = 0; colonne <= 10; colonne++) {

                    if (colonne == 0) {
                        System.out.print(ligneOrdonnéeConteur);
                        ligneOrdonnéeConteur++;

                    }
                    System.out.print(" | " + matrice[ligne][colonne]);
                }

                //saute une ligne
                System.out.println(" | ");
                System.out.println("   ---|---|---|---|---|---|---|---|---|---|--- ");
                // Saut de ligne

                System.out.print("");
            }

            // Fin de la boucle while
        }
            // Fin de la classe affichagePlateau
        }
        // Fin de la classe PlateauDe Jeu
    }
