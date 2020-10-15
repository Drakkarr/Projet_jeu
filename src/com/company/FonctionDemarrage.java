package com.company;

public class FonctionDemarrage {

    /**
     * Cette fonction FonctionDemarrage est caractérisée par les informations suivantes:
     * @see FonctionDemarrage
     * @see FonctionDemarrage
     * @see FonctionRedemarrage
     * @see reglesDuJeu
     * La fonction FonctionDemarrage sert à appeler le menu du jeu.
     * La fonction FonctionRedemarrage sert à rappeler le menu du jeu après avoir consulté les règles.
     * La fonction reglesDuJeu sert à appeler les règles du jeu et à les présenter à l'utilisateur.
     * Le menu est composé de la fonction FonctionDemarrage, FonctionRedemarrage et de la fonction reglesDuJeu.
     */

    public static void FonctionDemarrage(){

        /**
         * Cette fonction FonctionDemarrage est caractérisée par les informations suivantes:
         * @see FonctionDemarrage
         * Le menu est composé de la fonction FonctionDemarrage, FonctionRedemarrage et de la fonction reglesDuJeu.
         * FonctionDemarrage est la fonction qui permet d'appeler le menu du jeu.
         * La fonction FonctionDemarrage permet d'être dirigé là où on le souhaite :
         * 1 pour voir les règles, 2 pour démarrer la partie, 3 pour voir le score, 4 pour quitter la partie.
         */

        // Déclaration de la variable couleur

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";

        // Affichage de la fonction FonctionDemarrage

        System.out.println(ANSI_RED + "|---------------------------|" + ANSI_RESET);
        System.out.println(ANSI_RED + "| Bonjour et Bienvenue dans |" + ANSI_RESET);
        System.out.println(ANSI_RED + "| !!SUPER DESTRUCTOR 3000!! |" + ANSI_RESET);
        System.out.println(ANSI_RED + "|---------------------------|" + ANSI_RESET);
        System.out.println("Tape 1 pour voir les règles");
        System.out.println("Tape 2 pour démarrer une partie");
        System.out.println("Tape 3 pour voir le score");
        System.out.println("Tape 4 pour quitter la partie");
    }

    public static void FonctionRedemarrage() {

        /**
         * Cette fonction FonctionRedemarrage est caractérisée par les informations suivantes:
         * @see FonctionRedemarrage
         * FonctionRedemarrage est la fonction qui permet de rappeler le menu du jeu.
         * Le menu est composé de la fonction FonctionDemarrage, FonctionRedemarrage et de la fonction reglesDuJeu.
         * La fonction FonctionDemarrage permet d'être redirigé une nouvelle fois là où on le souhaite :
         * 1 pour voir les règles, 2 pour démarrer la partie, 3 pour voir le score, 4 pour quitter la partie.
         */

        // Affichage de la fonction FonctionRedemarrage

        System.out.println("Tape 1 pour voir les règles");
        System.out.println("Tape 2 pour démarrer une partie");
        System.out.println("Tape 3 pour voir le score");
        System.out.println("Tape 4 pour quitter la partie");
    }

    public static void reglesDuJeu() {

        /**
         * Cette fonction reglesDuJeu est caractérisée par les informations suivantes:
         * @see reglesDuJeu
         * La fonction reglesDuJeu permet d'avoir un rappelle des règles du jeu :
         * REGLES DU JEU :
         * A chaque tour vous pouvez vous déplacer horizontalement ou verticalement.
         * Appuyez sur les touches suivantes pour vous déplacer dans la direction.
         * Droite --> D.
         * Gauche --> Q.
         * Haut --> Z.
         * Bas --> S.
         * A chaque tour les joueurs doivent séléctionner une case à détruire.
         * Le but du jeu est de coincé l'adversaire, dans ce cas :
         * C'EST GAGNE.
         */

        // Affichage de la fonction reglesDuJeu

        System.out.println("//-REGLES DU JEU-//");
        System.out.println("--A chaque tour vous pouvez vous déplacer horizontalement ou verticalement--");
        System.out.println("Appuyez sur les touches suivantes pour vous déplacer dans la direction :");
        System.out.println("/Droite --> D");
        System.out.println("/Gauche --> Q");
        System.out.println("/Haut --> Z");
        System.out.println("/Bas --> S");
        System.out.println();
        System.out.println("--A chaque tour les joueurs doivent séléctionner une case à détruire--");
        System.out.println("--Le but du jeu est de coincé l'adversaire, dans ce cas :");
        System.out.println("C'EST GAGNE--");
        System.out.println();

    }
}