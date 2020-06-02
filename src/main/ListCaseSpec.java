package main;


import ennemies.*;
import armes.*;
import potions.*;

/**
 * La classe enum ListCaseSpec liste les types et le nombre de cases spéciales,
 * aide à générer le plâteau de jeu.<br>
 */
public enum ListCaseSpec {
    Dragon(4, 0, "Dragon"),
    Sorcier(10, 0, "Sorcier"),
    Gobelin(10, 0, "Gobelin"),
    Massue(5, 0, "Massue"),
    Epee(4, 0, "Epee"),
    Eclair(5, 0, "Eclair"),
    BouleFeu(2, 0, "BouleFeu"),
    PotionStandard(6, 0, "PotionStandard"),
    PotionGrande(2, 0, "PotionGrande");


    private int maxCase = 0;
    private int compteurCase = 0;
    private final String name;

    ListCaseSpec(int maxCase, int compteurCase, String name) {
        this.maxCase = maxCase;
        this.compteurCase = compteurCase;
        this.name=name;
    }

    public String getName() {
        return name;
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
