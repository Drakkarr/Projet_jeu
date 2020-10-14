package com.company;

public class PlateauDeJeu {

    public static void affichagePlateau(){

        String [][] matrice = new String[10][11];
        int ligne;
        int colonne;


        //remplir toutes les cases
        for (ligne=0; ligne<=9; ligne++){
            for (colonne =0; colonne<=10; colonne++){
                matrice[ligne][colonne] = "*";
                if (ligne ==5 && colonne==5){
                    matrice[ligne][colonne] = "R";
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
    }
}
