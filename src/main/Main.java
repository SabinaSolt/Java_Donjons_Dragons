package main;

import java.util.Scanner;
import personnages.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        boolean choix = false;
        do {
            menu.QuitGame();
            menu.ChooseHero();
            String choixPerso = sc.nextLine();
            Hero personnage;

            if (choixPerso.equals("Quit")) {
                System.exit(0);
            } else if (choixPerso.equals("Guerrier") |choixPerso.equals("Magicien")) {
                personnage= menu.CreerPersonnage(choixPerso, sc);
                System.out.println(personnage.toString());
                menu.ModifierPersonnage(personnage, sc);
                menu.DemarrerPartie(personnage, sc);
            } else {
                System.out.println("Je ne connnais pas ce personnage. Reessayez");
                choix = true;
            }
        } while (choix == true);
    }
}
