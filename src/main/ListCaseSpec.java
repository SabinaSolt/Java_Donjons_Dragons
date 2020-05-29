package main;

import armes.*;
import ennemies.*;
import potions.*;

/**
 * la classe enum ListCaseSpec liste les types et le nombre de cases spéciales
 * aide à générer le plâteau de jeu
 */
public enum ListCaseSpec {
    Dragon(  4, 0),
    Sorcier(10,0),
    Gobelin(10,0),
    Massue(5,0),
    Epee(4,0),
    Eclair(5,0),
    BouleFeu(2,0),
    PotionStandard(6,2),
    PotionGrande(2,0);


    private int maxCase = 0;
    private int compteurCase = 0;


    ListCaseSpec( int maxCase, int compteurCase) {

        this.maxCase = maxCase;
        this.compteurCase = compteurCase;
    }



    public int getMaxCase() {
        return maxCase;
    }

    public void setMaxCase(int maxCase) {
        this.maxCase = maxCase;
    }

    public int getCompteurCase() {
        return compteurCase;
    }

    public void setCompteurCase(int compteurCase) {
        this.compteurCase = compteurCase;
    }

    public void incrementCompteurCase() {
        this.compteurCase++;
    }

    @Override
    public String toString() {
        return "ListCaseSpec{" +
                "caseACreer=" + this.name() +
                ", maxCase=" + maxCase +
                ", compteurCase=" + compteurCase +
                '}';
    }
}
