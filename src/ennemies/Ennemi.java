package ennemies;
 import personnages.*;
public abstract class Ennemi {
    protected String name;
    protected int niveauVie;
    protected int force;
    protected boolean dead;

    public String getName() {
        return name;
    }

    public int getNiveauVie() {
        return niveauVie;
    }

    public int getForce() {
        return force;
    }

    @Override
    public String toString() {
        String str="Name: "+this.name+"\nVie: "+this.niveauVie+"\nForce: "+this.force;
        return str;
    }

    public void attaquer(Hero hero) {
        hero.subirDommage(this.force);
    }

    public void subirDommage(int force) {
        this.niveauVie-=force;
        if (this.niveauVie<=0) {
            this.dead=true;
        }
    }
}
