package armes;

public abstract class Arme {

protected String name;
protected int forceAttack;

//Getters
    public String getName() {
        return name;
    }

    public int getForceAttack() {
        return forceAttack;
    }

 //toString
 @Override
 public String toString() {
     String str="Name: "+this.name+"\nForce d'attaque: "+this.forceAttack;
     return str;
 }
}
