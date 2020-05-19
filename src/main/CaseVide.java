package main;

import personnages.*;

public class CaseVide extends Case {

    CaseVide() {
        this(0);
    }

    CaseVide(int numeroCase) {
        this.name = "Case Vide";
        this.numeroCase=numeroCase;
    }

    @Override
    public String toString() {
        return this.name+"\n Numero de la case  "+this.numeroCase;
    }

    public void interagir(Hero hero) {
        System.out.println("Tranquilou " + hero.getName() + "! La case est vide!");
    }
}
