package main;
import personnages.*;
public class DernierCase extends Case{
    DernierCase() {
        this(0);

    }

    DernierCase(int numeroCase) {
        this.name="La Case du Salut";
        this.numeroCase=numeroCase;
    }

    @Override
    public String toString() {
        return this.name;
    }
    public void interagir (Hero hero) {
        System.out.println("Félicitation "+hero.getName()+"! Tu as gagné!");
    }
}
