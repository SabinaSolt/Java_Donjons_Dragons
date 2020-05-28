package main;

import personnages.*;

public class DernierCase implements Case {
    protected String name;

    DernierCase() {
        this.name = "La Case du Salut";

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void interagir(Hero hero) {
        System.out.println("Félicitation " + hero.getName() + "! Tu as gagné!");
    }
}
