package potions;

import main.*;
import personnages.*;


public abstract class Potion extends Case {

    protected int healingPower;

//Getters
    public int getHealingPower() {
        return healingPower;
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
