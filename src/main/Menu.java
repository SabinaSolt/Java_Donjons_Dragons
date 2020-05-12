package main;
import java.util.Scanner;
public class Menu {



        // write your code here
        public void QuitGame() {
                System.out.println("Pour quitter le jeu tapez Quit");
        }

        public void ChooseHero() {
                // Choisir type de personnage
                System.out.println("Choisissez votre personnage. Tapez Guerrier ou Magicien");
        }
            //Demander les de rentrer les infos
        public Hero CreerPersonnage(String choixPerso, Scanner sc) {
                System.out.println("Entrez le nom de votre personnage");
                String nomPerso = sc.nextLine();
                if (choixPerso.equals("Guerrier")) {
                        Hero personnage = new Guerrier(nomPerso);
                        return personnage;
                } else {
                        Hero personnage = new Magicien(nomPerso);
                        return personnage;
                }
        }

        public void ModifierPersonnage(Hero personnage, Scanner sc) {
                System.out.println("Vous pouvez modifier le nom de votre perso Y/N");
                String response= sc.nextLine();
                if(response.equals("Y")) {
                        System.out.println("Entrez le nouveau nom de votre perso");
                        String nouvNom=sc.nextLine();
                        personnage.setName(nouvNom);
                }
                personnage.printValues();
        }
            // Afficher le personnage en cours de creation

            // modifier le personnage




}
