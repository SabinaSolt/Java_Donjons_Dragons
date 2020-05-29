package ennemies;

import main.*;
import personnages.*;

/**
 * la classe Ennemi sert à créer des ennemies
 * ces ennemies peuvent attaquer le personnage en lui enlevant les points de vie
 * et peuvent subir le dommage suite à l'attaque du personnage
 */

public abstract class Ennemi implements Case {

    protected int niveauVie;
    protected int force;
    protected boolean dead;
    protected String name;

    //Getters
    public int getNiveauVie() {
        return niveauVie;
    }

    public int getForce() {
        return force;
    }

    public boolean isDead() {
        return dead;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        String str = "Tu tombes sur un ennemi! \nName: " + this.name + "\nVie: " + this.niveauVie + "\nForce: " + this.force;
        return str;
    }

    public void attaquer(Hero hero) {
        System.out.println(this.name + " t'a attaqué avec la force de " + this.force);
        hero.subirDommage(this.force);
    }

    public void subirDommage(int force) {
        this.niveauVie -= force;
        if (this.niveauVie <= 0) {
            this.niveauVie = 0;
            this.dead = true;
            System.out.println("Tu as tué ton ennemi!");
        } else {
            System.out.println("Le niveau de vie de " + this.name + " passe à " + this.niveauVie);

        }

    }

    public void interagir(Hero hero) {
        hero.decisionHero(this);

    }
}
