package ennemies;
 import main.Case;
 import personnages.*;
public abstract class Ennemi extends Case {

    protected int niveauVie;
    protected int force;
    protected boolean dead;

    //Getters
    public int getNiveauVie() {
        return niveauVie;
    }
    public int getForce() {
        return force;
    }

    @Override
    public String toString() {
        String str="Tu tombes sur un ennemi! \nName: "+this.name+"\nVie: "+this.niveauVie+"\nForce: "+this.force;
        return str;
    }

    public void attaquer(Hero hero) {
        System.out.println(this.name+" t'attaque avec la force de " +this.force);
        hero.subirDommage(this.force);
    }

    public void subirDommage(int force) {
        this.niveauVie-=force;
        if (this.niveauVie<=0) {
            this.dead=true;
            System.out.println("Tu as tué ton ennemi!");
        } else {
            System.out.println("Le niveau de vie de "+this.name+ " passe à "+this.niveauVie);
        }
    }

    public void interagir(Hero hero) {
       hero.attaquer(this);
       this.attaquer(hero);
    }
}