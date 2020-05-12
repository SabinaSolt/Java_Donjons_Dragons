package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Scanner sc = new Scanner(System.in);

        //int str = sc.nextInt();
        //On vide la ligne avant d'en lire une autre
        // sc.nextLine();


        Menu menu = new Menu();
        boolean choix = false;

        do {
            menu.QuitGame();
            menu.ChooseHero();

            String choixPerso = sc.nextLine();


            if (choixPerso.equals("Quit")) {
                System.exit(0);
            } else if (choixPerso.equals("Guerrier") |choixPerso.equals("Magicien")) {

                Hero personnage= menu.CreerPersonnage(choixPerso, sc);
                personnage.printValues();
                menu.ModifierPersonnage(personnage, sc);

            } else {
                System.out.println("Je ne connnais pas ce personnage. Reessayez");
                choix = true;
            }

        } while (choix == true);

    }
}
