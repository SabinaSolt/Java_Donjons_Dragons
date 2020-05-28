package main;

import personnages.*;

public class CaseVide implements Case {
    protected String name;

    CaseVide() {
        this.name = "Case Vide";
     }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void interagir(Hero hero) {
        System.out.println("Tranquilou " + hero.getName() + "! La case est vide!");
    }
}
