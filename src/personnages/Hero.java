package personnages;

import armes.*;
import potions.*;
import ennemies.*;

public abstract class Hero {
    //state of an object
    protected String name;
    protected String image="image.jpg";
    protected int niveauVie;
    protected int force;
    protected Arme arme;
    protected String protection;
    protected  int forceMax;
    protected int vieMax;
    protected boolean dead;

    //constructor method
    public Hero() {
    }
    public Hero(String name) {
        this(name, 0, 0);
//        this.name=name;

    }

    public Hero(String name, int niveauVie, int force)
    {
        this.name=name;
        this.niveauVie=niveauVie;
        this.force=force;
    }


    public Hero(String name, String image, int niveauVie, int force)
    {
        this.name=name;
        this.image=image;
        this.niveauVie=niveauVie;
        this.force=force;
    }

//Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setNiveauVie(int niveauVie) {
        this.niveauVie = niveauVie;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }

    public void setProtection(String protection) {
        this.protection = protection;
    }


// Getters

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
    public int getNiveauVie() {
        return niveauVie;
    }
    public int getForce() {
        return force;
    }

    public Arme getArme() {
        return arme;
    }

    public String getProtection() {
        return protection;
    }

    public boolean isDead() {
        return dead;
    }

    //behavior of an object
    @Override
    public String toString() {
        String str="Name: "+this.name+"\nVie: "+this.niveauVie+"\nForce: "+this.force;
        return str;
    }

     public void augmenterAttaque(Arme arme) {
        this.arme =arme;
        this.force=this.force+arme.getForceAttack();
        if(this.force>this.forceMax) {
            this.force=this.forceMax;
            System.out.println("Tu es gonflé à bloc. Ta force est à son max "+this.force);
        } else {
            System.out.println("Wow, tu es devenu super balaise! Ta force passe à "+this.force);
        }

     }

     public void seguerir(int healing) {
        this.niveauVie=this.niveauVie+healing;
        if(this.niveauVie>this.vieMax) {
            this.niveauVie=this.vieMax;
            System.out.println("Tu es au top de ta forme! Ta vie est au zenith: "+this.niveauVie);
        } else {
            System.out.println("Ton niveau de vie passe à "+this.niveauVie);
        }

     }


     public void attaquer(Ennemi ennemi) {
        System.out.println("Tu attaques "+ennemi.getName()+" avec la force de " +this.force);
        ennemi.subirDommage(this.force);
     }

    public void subirDommage(int force) {

        this.niveauVie-=force;
        if (this.niveauVie<=0) {
            this.dead=true;
            System.out.println("Mince, tu es mort!");
        } else {
            System.out.println("Ton niveau de vie passe à "+this.niveauVie);
        }
    }

}


