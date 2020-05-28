package armes;

import personnages.*;

public class Motivation extends Arme {

    public Motivation() {
        this.name = "Motivation";
        this.forceAttack = 0;
    }

    public void interagir(Hero hero) {
        hero.augmenterAttaque(this);
        System.out.println("Wow, tu as retrouvé la motivation!");
    }
}
