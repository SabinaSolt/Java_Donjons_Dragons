package main;

import armes.*;
import ennemies.*;
import potions.*;

public enum ListCaseSpec {
    Dragon(new Dragon(), 4, 0),
    Sorcier(new Sorcier(),10,0),
    Gobelin(new Gobelin(),10,0),
    Massue(new Massue(),5,0),
    Epee(new Epee(),4,0),
    Eclair(new Eclair(),5,0),
    BouleFeu(new BouleFeu(),2,0),
    PotionStandard(new PotionStandard(),6,2),
    PotionGrande(new PotionGrande(),2,0);

    private Case caseACreer;
    private int maxCase = 0;
    private int compteurCase = 0;


    ListCaseSpec(Case caseACreer, int maxCase, int compteurCase) {
        this.caseACreer = caseACreer;
        this.maxCase = maxCase;
        this.compteurCase = compteurCase;
    }

    public Case getCaseACreer() {
        return caseACreer;
    }

    public void setCaseACreer(Case caseACreer) {
        this.caseACreer = caseACreer;
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
                "caseACreer=" + caseACreer +
                ", maxCase=" + maxCase +
                ", compteurCase=" + compteurCase +
                '}';
    }
}
