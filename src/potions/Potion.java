package potions;

import main.*;
import personnages.*;

/**
 * La classe Potion permet d'augmenter les points de vie du personnage.<br>
 */
public abstract class Potion implements Case {
    protected String name;

    protected int healingPower;

//Getters
    public int getHealingPower() {
        return healingPower;
    }
    public String getName() {
        return name;
    }
    //toString
    @Override
    public String toString() {
        String str="Tu trouves une potion magique! \nName: "+this.name+"\nPouvoir de guerison: "+this.healingPower;
        return str;
    }
    /**
     *
     * @param hero
     */
    public void seguerir(Hero hero) {
        int newNiveauVie=hero.getNiveauVie()+this.healingPower;

        if (newNiveauVie > hero.getVieMax()) {
            hero.setNiveauVie(hero.getVieMax());
            System.out.println("Tu es au top de ta forme! Ta vie est au zenith: " + hero.getNiveauVie());
        } else {
            hero.setNiveauVie(newNiveauVie);
            System.out.println("Ton niveau de vie passe à " + hero.getNiveauVie());
        }
    }
    public void interagir(Hero hero) {
        this.seguerir(hero);
    }

}
