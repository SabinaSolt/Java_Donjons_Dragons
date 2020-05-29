package ennemies;

import main.*;
import personnages.*;

/**
 * La classe Ennemi sert à créer des ennemies. <br>
 * Ces ennemies peuvent attaquer le personnage en lui enlevant les points de vie
 * et peuvent subir le dommage suite à l'attaque du personnage. <br>
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


    public void subirDommage(Hero hero) {
        System.out.println("Tu attaques " + this.name + " avec la force de " + hero.getForce());
        this.niveauVie -= hero.getForce();
        if (this.niveauVie <= 0) {
            this.niveauVie = 0;
            this.force=0;
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
