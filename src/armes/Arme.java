package armes;

import main.Case;
import personnages.*;
/**
 * La classe  abstraite Arme permet d'augmenter la force d'attaque du personnage.<br>
 */
public abstract class Arme implements Case {
protected String name;
protected int forceAttack;
    public Arme() {}


    public int getForceAttack() {
        return forceAttack;
    }

    public String getName() {
        return name;
    }

    /**
     *
     * @param hero
     */
    public void augmenterAttaque(Hero hero) {
        hero.setArme(this);
        int newForce = hero.getForce() + this.getForceAttack();
        if (newForce > hero.getForceMax()) {
            hero.setForce(hero.getForceMax());
            System.out.println("Tu es gonflé à bloc. Ta force est à son max " + hero.getForce());
        } else {
            hero.setForce(newForce);
            System.out.println("Wow, tu es devenu super balaise! Ta force passe à " + hero.getForce());
        }

    }


 //toString
 @Override
 public String toString() {
     String str="Tu trouves une arme! \nName: "+this.name+"\nForce d'attaque: "+this.forceAttack;
     return str;
 }
}
