package main;

import personnages.*;

public class CaseVide extends Case {

    CaseVide() {
        this.name = "Case Vide";
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void interagir(Hero hero) {
        System.out.println("Tranquilou " + hero.getName() + "! La case est vide!");
    }
}
