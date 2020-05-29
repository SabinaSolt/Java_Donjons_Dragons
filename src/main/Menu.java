package main;

import java.util.Scanner;
import exceptions.PersonnageHorsPlateauException;
import personnages.*;

/**
 * La classe Menu contient le menu du jeu
 * à partir du quel on crée et modifie les personnages;<br>
 * démarre le jeu et gère l'avancement du personnage sur le plâteau; <br>
 * gère le mode debug.<br>
 */
public class Menu {
    private Boolean modeDebug = true;
    private String persoDebug = "Guerrier";
    private int deDebug[] = {2, 4, 6};
    private ConnectionBD conn = new ConnectionBD();

    /**
     * La méthode menuDemarrage propose le menu au joueur,
     * execute les méthodes en fonction de son choix.<br>
     * @param sc
     */
    public void menuDemarrage(Scanner sc) {
        if (!modeDebug)System.out.println("Pour quitter le jeu tapez Quit"+
                "\nPour afficher tous les personnages tapez 'Heroes'"+
                "\nPour choisir un personnage existant tapez 'Choisir'"+
                "\nPour supprimer un personnage tapez 'Delete'"+
                "\nPour créer un nouveau personnage tapez 'Create'"+
                "\nPour modifier le nom du personnage tapez 'Update'"+
                "\nPour démarrer une partie tapez 'Play'");


        Hero personnage=new Guerrier();
        Boolean persoCreated=false;
        Boolean jeuTourne=true;

        do {
            if (!modeDebug)System.out.println("Indiquez votre choix:");
            String str=(persoCreated)?"Play":"Create";
            String response = (modeDebug) ?str:sc.nextLine();

            switch (response) {
                case "Quit":
                    System.exit(0);
                    break;
                case "Heroes":
                    this.conn.getHeroes();
                    break;
                case "Choisir":
                    personnage = this.conn.chooseHero(sc);
                    persoCreated = true;
                    break;
                case "Delete":
                    this.conn.deleteHero(sc);
                    break;
                case "Create":
                    personnage = this.CreerPersonnage(sc);
                    persoCreated = true;
                    break;
                case "Update":
                    this.ModifierPersonnage(sc);
                    break;
                case "Play":
                    if (persoCreated) {
                        this.DemarrerPartie(personnage, sc);
                    } else {
                        System.out.println("Vous devez créer un personnage d'abord");
                    }
                    if(modeDebug) jeuTourne=false;
                    break;
                default:
                    System.out.println("Je ne connais pas cette commande");
                    break;
            }

        }while (jeuTourne);
    }

    /**
     * La méthode CreerPersonnage instancie le personnage en fonction des choix du joueur,
     * sauvegarde le personnage dans la BDD.<br>
     * @param sc
     * @return
     */

    public Hero CreerPersonnage(Scanner sc) {
        System.out.println("Pour quitter le jeu tapez Quit");
        if (!modeDebug) System.out.println("Choisissez votre personnage. Tapez Guerrier ou Magicien");
        String choixPerso = (modeDebug) ? persoDebug : sc.nextLine();
        Boolean choixOk = true;

        do {
            if (choixPerso.equals("Quit")) {
                System.exit(0);
            } else if (choixPerso.equals("Guerrier") | choixPerso.equals("Magicien")) {
                choixOk = true;
            } else {
                System.out.println("Je ne connnais pas ce personnage. Reessayez");
                choixOk = false;
                choixPerso = sc.nextLine();
            }
        } while (!choixOk);

        if (!modeDebug) System.out.println("Entrez le nom de votre personnage");
        String nomPerso = (modeDebug) ? "La Cobaye Sanguinaire" : sc.nextLine();
        if (choixPerso.equals("Guerrier")) {
            Hero personnage = new Guerrier(nomPerso);
            conn.createHero(personnage);
            return personnage;
        } else {
            Hero personnage = new Magicien(nomPerso);
            conn.createHero(personnage);
            return personnage;
        }
    }

    /**
     * La méthode ModifierPersonnage modifie le nom du personnage
     * et sauvegarde la modification dans la BDD <br>
     * @param sc
     */

    public void ModifierPersonnage(Scanner sc) {
        Hero personnage = this.conn.chooseHero(sc);
        System.out.println("Entrez le nouveau nom de votre perso");
        String nouvNom = sc.nextLine();
        personnage.setName(nouvNom);
        conn.updateHero(personnage.getId(), nouvNom);
    }

    /**
     *
     * @param personnage
     * @param sc
     */
    public void DemarrerPartie(Hero personnage, Scanner sc) {
        if (!modeDebug) System.out.println("Voulez vous démarrer la partie Y/N");
        String response = (modeDebug) ? "Y" : sc.nextLine();
        if (response.equals("Y")) {
            JouerPartie(personnage, sc);
        }
    }

    /**
     * La méthode JouerPartie gère le lancement des dés,
     * l'avancement du personnage et la fin de la partie.<br>
     * @param personnage
     * @param sc
     */
    public void JouerPartie(Hero personnage, Scanner sc) {
        Plateau plateau = new Plateau();
        if (modeDebug) plateau.toString();
        int compteurTourDebug = 0;
        do {
            if (personnage.isDead()) {
                System.exit(0);
            }
            //Compter les tours en mode debug
            if (modeDebug) {
                if (compteurTourDebug < this.deDebug.length) {
                    compteurTourDebug++;
                } else {
                    System.out.println("\nLe mode debug est fini.");
                    System.exit(0);
                }
            }

            System.out.println("La case courante:" + personnage.getNumeroCaseCourante());
            System.out.println("Pour lancer le dés tapez De");
            String response = sc.nextLine();

            if (response.equals("Quit")) {
                System.exit(0);
            } else if (response.equals("De")) {
                int de = (modeDebug) ? this.deDebug[compteurTourDebug - 1] : (1 + (int) (Math.random() * 6));
                System.out.println("Le dé fait " + de + " points");

                //bouger le personnage sur la nouvelle case
                try {
                    personnage.setCaseCourante(de);
                } catch (PersonnageHorsPlateauException e) {
                    e.getMessage();
                }

                System.out.println(personnage.getName() + " avance à la case " + personnage.getNumeroCaseCourante());
                int indice = personnage.getNumeroCaseCourante() - 1;
                System.out.println(plateau.getCase(indice).toString());
                plateau.getCase(indice).interagir(personnage);
            }
        } while (personnage.getNumeroCaseCourante() < plateau.getDerniereCase());
    }
}
