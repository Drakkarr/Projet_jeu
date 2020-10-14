package com.company;

import java.io.Console;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Coucou");

        FonctionsMenu.FonctionDemarrage();

        // Scanner pour récuperer le numéro saisi par l'utilisateur
        Scanner scannerMenu = new Scanner(System.in);
        String recupScannerMenu = scannerMenu.next();

        // Si l'utilisateur saisi "1" lance fonction règle du jeu
        if (recupScannerMenu.equals("1")) {
            FonctionsMenu.reglesDuJeu();
        }
        // Si l'utilisateur saisi "2" lance fonction jeu
        else if (recupScannerMenu.equals("2")) {
                PlateauDeJeu.affichagePlateau();
        }
        // Si l'utilisateur saisi "3" lance l'historique des parties
        else if (recupScannerMenu.equals("3")) {
            System.out.println("Historique parti");
        }
        // Si l'utilisateur saisi "4" quitte le jeu
        else if (recupScannerMenu.equals("4")) {
        }
        // Si l'utilisateur saisi une autre commande que celles proposées message + relance le menu
        else {
            System.out.println("Commande non valide");
        }

    }

}
