package com.company;

import java.util.Scanner;


public class Main {

    /**
     * Cette classe Main est caractérisée par les informations suivantes :
     * @see Main
     * @see FonctionsMenu
     * @see FonctionDemarrage
     * @see reglesDuJeu
     * @see FonctionRedemarrage
     * @see PlateauDeJeu
     * La fonction FonctionsMenu.FonctionDemarrage est appelé pour présenter le début du jeu.
     * La boucle while sert à appeler la FonctionsMenu.FonctionDemarrage.
     * Celle-ci a pour but de se répéter et de représenter le menu du jeu.
     * La classe Main a pour fonctionnalité le démarrage du jeu avec un menu.
     * @author Florent, Maxime, Mélyne
     * @version 2.0
     */

    public static void main(String[] args) {

        /**
         * Cette fonction main est caractérisée par les informations suivantes:
         * @see FonctionsMenu
         * @see FonctionDemarrage
         * FonctionsMenu.FonctionDemarrage est la fonction qui permet d'appeler le menu du jeu.
         * FonctionsMenu.FonctionRedemarrage est la fonction qui permet d'appeler le menu du jeu.
         * Le menu est composé de la fonction FonctionDemarrage et de la fonction reglesDuJeu.
         * La fonction FonctionDemarrage permet d'être dirigé là où on le souhaite :
         * 1 pour voir les règles, 2 pour démarrer la partie, 3 pour voir le score, 4 pour quitter la partie.
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
        FonctionsMenu.FonctionDemarrage();


        /**
         * Le Scanner scannerMenu a pour utilité de pouvoir noter dans la console.
         * La variable recupScannerMenu permet de récupérer le numéro saisi par l'utilisateur.
         */

        // Scanner permet de récuperer le numéro saisi par l'utilisateur.
        Scanner scannerMenu = new Scanner(System.in);
        String recupScannerMenu = scannerMenu.next();

        /**
         * La boucle while permet à l'utilisateur de toujours revenir au menu après son choix initial.
         * Celle-ci se compose de plusieurs conditions qui permettent d'appeler plusieurs fonctions tel que :
         * FonctionsMenu.reglesDuJeu
         * PlateauDeJeu.affichagePlateau
         */
        int boucle=0;
        while (boucle ==0) {

            // Si l'utilisateur saisi le numéro "1", la fonction reglesDuJeu affiche les règles du jeu.

            if (recupScannerMenu.equals("1")) {
                FonctionsMenu.reglesDuJeu();

                FonctionsMenu.FonctionRedemarrage();
                recupScannerMenu = scannerMenu.next();
            }

            // Si l'utilisateur saisi le numéro "2", la fonction affichagePlateau affiche le plateau de jeu.

            else if (recupScannerMenu.equals("2")) {
                PlateauDeJeu.affichagePlateau();
                boucle++;
            }

            // Si l'utilisateur saisi le numéro "3", l'historique des parties s'affiche.

            else if (recupScannerMenu.equals("3")) {
                System.out.println("Historique parti");

                FonctionsMenu.FonctionRedemarrage();
                recupScannerMenu = scannerMenu.next();
            }

            // Si l'utilisateur saisi le numéro "4", celui-ci quitte le jeu

            else if (recupScannerMenu.equals("4")) {
                System.out.println("Merci d'avoir joué");
                break;
            }

            // Si l'utilisateur saisi une autre commande que celles proposées :
            // Un message "commande non valide" s'affiche et relance le menu.

            else {
                System.out.println("Commande non valide");

                FonctionsMenu.FonctionRedemarrage();
                recupScannerMenu = scannerMenu.next();
            }
        }
    }
}
