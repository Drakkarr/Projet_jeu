package com.company;

public class FonctionsMenu {

        public static void FonctionDemarrage(){

            /**
             * Affichage de la fonction démarrage au lancement du programme
             */

            System.out.println("|---------------------------|");
            System.out.println("| Bonjour et Bienvenue dans |" );
            System.out.println("| !!SUPER DESTRUCTOR 3000!! |");
            System.out.println("|---------------------------|");
            System.out.println("Tape 1 pour voir les règles");
            System.out.println("Tape 2 pour démarrer une partie");
            System.out.println("Tape 3 pour voir le score");
            System.out.println("Tape 4 pour quitter la partie");
        }

    public static void FonctionRedemarrage(){

        /**
         * Affichage de la fonction redémarrage lorsque je reviens dans le menu
         */

        System.out.println("Tape 1 pour voir les règles");
        System.out.println("Tape 2 pour démarrer une partie");
        System.out.println("Tape 3 pour voir le score");
        System.out.println("Tape 4 pour quitter la partie");
    }

        public static void reglesDuJeu() {

            /**
             * Affichage des règles du jeu
             */

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
