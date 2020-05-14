package main;

import personnages.Hero;

public class CaseVide extends Case{

    CaseVide() {
        this.name="Case Vide";
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void interagir (Hero hero) {
        System.out.println("Tu as de la chance, "+hero.getName()+"! Je suis vide!");
    }
}
