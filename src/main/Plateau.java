package main;

import armes.*;
import ennemies.*;
import potions.*;
import exceptions.PersonnageHorsPlateauException;

import java.util.ArrayList;

/**
 * La classe Plateau permet de créer le plâteau de jeu
 * avec les cases spéciales disposées d'une manière aléatoire.<br>
 */

public class Plateau {
    private int derniereCase = 64;
    // private int caseCourante = 1;
    private int premiereCase = 1;
    private ArrayList<Case> listCases;

    /**
     * Le constructeur Plateau() dispose les cases spéciales sur le plateau d'une manière aléatoire,
     * parcourt array list des cases spéciales.<br>
     */
    public Plateau() {
        this.listCases = new ArrayList();
        // initie le plateau avec les cases vides
        for (int i = 0; i < derniereCase; i++) {
            listCases.add(new CaseVide());
        }

        listCases.set(derniereCase - 1, new DernierCase());

        for (ListCaseSpec caseK : ListCaseSpec.values()) {
            //Boucle répetée jusqu'à ce que le nombre des cases spéc atteigne son max
            do {
                int caseAleatoire = (int) (Math.random() * 63);
                if (listCases.get(caseAleatoire) instanceof CaseVide) {

                    switch (caseK.name()) {
                        case "Dragon":
                            listCases.set(caseAleatoire, new Dragon());
                            break;
                        case "Sorcier":
                            listCases.set(caseAleatoire, new Sorcier());
                            break;
                        case "Gobelin":
                            listCases.set(caseAleatoire, new Gobelin());
                            break;
                        case "Massue":
                            listCases.set(caseAleatoire, new Massue());
                            break;
                        case "Epee":
                            listCases.set(caseAleatoire, new Epee());
                            break;
                        case "Eclair":
                            listCases.set(caseAleatoire, new Eclair());
                            break;
                        case "BouleFeu":
                            listCases.set(caseAleatoire, new BouleFeu());
                            break;
                        case "PotionStandard":
                            listCases.set(caseAleatoire, new PotionStandard());
                            break;
                        case "PotionGrande":
                            listCases.set(caseAleatoire, new PotionGrande());
                            break;
                    }

                    caseK.incrementCompteurCase();
                }
            } while (caseK.getCompteurCase() < caseK.getMaxCase());
        }
    }

    //Getters

    public int getDerniereCase() {
        return derniereCase;
    }

    public Case getCase(int index) {

        return listCases.get(index);
    }

    public int getPremiereCase() {
        return premiereCase;
    }

    //Setters

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < listCases.size(); i++) {
            int j = i + 1;
            str = str + "\nCase " + j + ": " + listCases.get(i).getName();
        }
        System.out.println(str);
        return str;
    }
}
