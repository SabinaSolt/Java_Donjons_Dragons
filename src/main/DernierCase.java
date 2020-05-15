package main;
import personnages.*;
public class DernierCase extends Case{
    DernierCase() {
        this.name="La Case du Salut";
    }

    @Override
    public String toString() {
        return this.name;
    }
    public void interagir (Hero hero) {
        System.out.println("Félicitation "+hero.getName()+"! Tu as gagné!");
    }
}
