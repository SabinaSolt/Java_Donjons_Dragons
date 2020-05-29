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

    public void interagir(Hero hero) {
        hero.seguerir(this.healingPower);
    }

}
