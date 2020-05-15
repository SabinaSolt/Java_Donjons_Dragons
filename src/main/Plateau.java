package main;

import armes.*;
import ennemies.*;
import potions.*;
import exceptions.PersonnageHorsPlateauException;

import java.util.ArrayList;

public class Plateau {
    private int derniereCase = 64;
    private int premiereCase = 1;
    private int caseCourante = 1;
    private ArrayList<Case> listCases;

    public Plateau() {
        this.listCases = new ArrayList();

        for (int i = 0; i < derniereCase; i++) {

            switch (i + 1) {
                case 45:
                case 52:
                case 56:
                case 62:
                    listCases.add(new Dragon());
                    break;
                case 10:
                case 20:
                case 25:
                case 32:
                case 35:
                case 36:
                case 37:
                case 40:
                case 44:
                case 47:
                    listCases.add(new Sorcier());
                    break;

                case 3:
                case 6:
                case 9:
                case 12:
                case 15:
                case 18:
                case 21:
                case 24:
                case 27:
                case 30:
                    listCases.add(new Gobelin());
                    break;
                case 2:
                case 5:
                case 11:
                case 22:
                case 38:
                    listCases.add(new Massue());
                    break;
                case 19:
                case 26:
                case 42:
                case 53:
                    listCases.add(new Epee());
                    break;
                case 1:
                case 4:
                case 8:
                case 17:
                case 23:
                    listCases.add(new Eclair());
                    break;
                case 48:
                case 49:
                    listCases.add(new BouleFeu());
                    break;
                case 7:
                case 13:
                case 31:
                case 33:
                case 39:
                case 43:
                    listCases.add(new PotionStandard());
                    break;
                case 28:
                case 41:
                    listCases.add(new PotionGrande());
                    break;
                case 64:
                    listCases.add(new DernierCase());
                    break;
                default:
                    listCases.add(new CaseVide());

            }
        }
    }


    //Getters

    public int getDerniereCase() {
        return derniereCase;
    }
    public int getPremiereCase() {
        return premiereCase;
    }
    public int getNumeroCaseCourante() {
        return caseCourante;
    }
    public Case getCase(int index) {

        if (index < 0 & index > derniereCase) {
            index = caseCourante;
        }
        return listCases.get(index);
    }

    //Setters
    public void setCaseCourante(int nombrePas) throws PersonnageHorsPlateauException {
        this.caseCourante = this.caseCourante + nombrePas;
        if (this.caseCourante > derniereCase) {
            this.caseCourante = derniereCase;
            throw new PersonnageHorsPlateauException();
        }
    }
}
