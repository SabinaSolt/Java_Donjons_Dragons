package potions;

public abstract class Potion {
    protected String name;
    protected int healingPower;
//Getters
    public String getName() {
        return name;
    }

    public int getHealingPower() {
        return healingPower;
    }

    //toString
    @Override
    public String toString() {
        String str="Name: "+this.name+"\nForce d'attaque: "+this.healingPower;
        return str;
    }

}
