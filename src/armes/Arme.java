package armes;

import main.Case;

public abstract class Arme implements Case {
protected String name;
protected int forceAttack;

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
