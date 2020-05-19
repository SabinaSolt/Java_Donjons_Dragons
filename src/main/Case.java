package main;

import personnages.*;

public abstract class Case {
    protected String name;
    protected int numeroCase;

    public Case() {

    }

    //Getters
    public String getName() {
        return name;
    }

    public void setNumeroCase(int numeroCase) {
        this.numeroCase = numeroCase;
    }

    public int getNumeroCase() {
        return numeroCase;
    }

    @Override
    public String toString() {
        return "Je suis une case";
    }

    public void interagir(Hero hero) {

    }
}
