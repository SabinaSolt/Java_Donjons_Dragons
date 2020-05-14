package armes;

import main.Case;

public abstract class Arme extends Case {


protected int forceAttack;

    public int getForceAttack() {
        return forceAttack;
    }

 //toString
 @Override
 public String toString() {
     String str="Tu trouves une arme! \nName: "+this.name+"\nForce d'attaque: "+this.forceAttack;
     return str;
 }
}
