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
                        System.out.println(personnage.toString());
                }

        }

        public void DemarrerPartie(Hero personnage, Scanner sc) {
                System.out.println("Voulez vous démarrer la partie Y/N");
                String response= sc.nextLine();
                if(response.equals("Y")) {
                        JouerPartie(personnage, sc);
                }
        }

        public void JouerPartie(Hero personnage, Scanner sc) {
                Plateau plateau=new Plateau();
                QuitGame();
                do {
                        System.out.println("La case courante:"+plateau.caseCourante);
                        System.out.println("Pour lancer le dés tapez De");
                        String response= sc.nextLine();

                        if (response.equals("Quit")) {
                                System.exit(0);
                        } else if(response.equals("De")) {
                           int de=1+ (int)(Math.random()*6);
                           System.out.println("Le dé fait "+de+" points");
                           try{
                                   plateau.setCaseCourante(de);
                           } catch(PersonnageHorsPlateauException e) {
                                   e.getMessage();
                           }

                           System.out.println(personnage.name+" avance à la case "+ plateau.caseCourante);
                        }

                } while (plateau.caseCourante<64);
                System.out.println("Yopeee!"+personnage.name+ "a gagné");
        }

}
