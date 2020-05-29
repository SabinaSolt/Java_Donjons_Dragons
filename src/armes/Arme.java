package armes;

import main.Case;

/**
 * la classe  abstraite Arme permet d'augmenter la force d'attaque du personnage
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

 //toString
 @Override
 public String toString() {
     String str="Tu trouves une arme! \nName: "+this.name+"\nForce d'attaque: "+this.forceAttack;
     return str;
 }
}
