package main;

import exceptions.PersonnageHorsPlateauException;

public class Plateau {
    protected int derniereCase=64;
    protected int premiereCase=1;
    protected int caseCourante=1;

    public Plateau() {
    }

    //Getters

    public int getDerniereCase() {
        return derniereCase;
    }

    public int getPremiereCase() {
        return premiereCase;
    }


    public int getCaseCourante() {
        return caseCourante;
    }

    //Setters
    public void setCaseCourante(int nombrePas)  throws PersonnageHorsPlateauException {

        this.caseCourante = this.caseCourante+nombrePas;

            if(this.caseCourante>64) {
                this.caseCourante=1;
                throw new PersonnageHorsPlateauException();
            }
    }
}
