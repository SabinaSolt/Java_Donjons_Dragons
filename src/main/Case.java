package main;

import personnages.*;

public abstract class Case {
    protected String name;

    //Getters
    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Je suis une case";
    }

    public void interagir(Hero hero) {

    }
}
