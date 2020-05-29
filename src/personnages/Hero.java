package personnages;

import armes.*;
import exceptions.PersonnageHorsPlateauException;
import ennemies.*;
import java.util.Scanner;

/**
 * la classe abstraite Hero sert à créer le personnage du jeu
 * et définit ses comportements
 */

public abstract class Hero {
    //state of an object
    protected int id;
    protected String name;
    protected String type;
    protected int niveauVie;
    protected int force;
    protected Arme arme;
    protected String protection;
    protected int forceMax;
    protected int vieMax;
    protected boolean dead;
    protected int caseCourante = 1;
    protected int derniereCase = 64;

    //constructor method
    public Hero() {
    }

    /**
     *
     * @param name
     * @param niveauVie
     * @param force
     * @param id
     * @param protection
     * @param armeType
     */
    public Hero(String name, int niveauVie, int force, int id, String protection, String armeType) {
        this.id=id;
        this.name = name;
        this.niveauVie = niveauVie;
        this.force = force;
        this.protection=protection;
        this.setArme(armeType);
    }

//Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setForceMax(int forceMax) {
        this.forceMax = forceMax;
    }

    public void setVieMax(int vieMax) {
        this.vieMax = vieMax;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public void setDerniereCase(int derniereCase) {
        this.derniereCase = derniereCase;
    }

    public void setName(String name) {
        this.name = name;
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

    /**
     *
     * @param armeType
     */
    public void setArme(String armeType) {
        switch (armeType) {
            case "BouleFeu":
                this.arme=new BouleFeu();
                break;
            case "Eclair":
                this.arme=new Eclair();
                break;
            case "Epee":
                this.arme=new Epee();
                break;
            case "Massue":
                this.arme=new Massue();
                break;
            case "Motivation":
                this.arme=new Motivation();
                break;
            default:
                this.arme=new Motivation();
                break;
        }
    }

    public void setProtection(String protection) {
        this.protection = protection;
    }

    /**
     *
     * @param nombrePas
     * @throws PersonnageHorsPlateauException
     */
    public void setCaseCourante(int nombrePas) throws PersonnageHorsPlateauException {
        this.caseCourante = this.caseCourante + nombrePas;
        if (this.caseCourante > derniereCase) {
            this.caseCourante = derniereCase;
            throw new PersonnageHorsPlateauException();
        }
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public String getType() {
        return type;
    }

    public int getForceMax() {
        return forceMax;
    }

    public int getVieMax() {
        return vieMax;
    }

    public int getCaseCourante() {
        return caseCourante;
    }

    public int getDerniereCase() {
        return derniereCase;
    }

    public boolean isDead() {
        return dead;
    }

    public int getNumeroCaseCourante() {
        return caseCourante;
    }

    //behavior of an object
    @Override
    public String toString() {
        String str = "id: "+this.id+"\nName: " + this.name + "\nType: " + this.type + "\nVie: " + this.niveauVie + "\nForce: " + this.force;
        return str;
    }

    /**
     *
     * @param arme
     */
    public void augmenterAttaque(Arme arme) {
        this.arme = arme;
        this.force = this.force + arme.getForceAttack();
        if (this.force > this.forceMax) {
            this.force = this.forceMax;
            System.out.println("Tu es gonflé à bloc. Ta force est à son max " + this.force);
        } else {
            System.out.println("Wow, tu es devenu super balaise! Ta force passe à " + this.force);
        }

    }

    /**
     *
     * @param healing
     */
    public void seguerir(int healing) {
        this.niveauVie = this.niveauVie + healing;
        if (this.niveauVie > this.vieMax) {
            this.niveauVie = this.vieMax;
            System.out.println("Tu es au top de ta forme! Ta vie est au zenith: " + this.niveauVie);
        } else {
            System.out.println("Ton niveau de vie passe à " + this.niveauVie);
        }

    }

    /**
     *
     * @param ennemi
     */
    public void attaquer(Ennemi ennemi) {
        System.out.println("Tu attaques " + ennemi.getName() + " avec la force de " + this.force);
        ennemi.subirDommage(this.force);
    }

    public void fuir() {
        int caseRecule = 1 + (int) (Math.random() * 6);
        System.out.println("Tu fuis ton ennemi. Le destin te fais reculer de " + caseRecule + " cases");
        this.caseCourante = this.caseCourante - caseRecule;
        if (this.caseCourante < 1) {
            this.caseCourante = 1;
        }

        System.out.println("Tu retournes à la case " + this.caseCourante);
    }

    /**
     *
     * @param ennemi
     */
    public void decisionHero(Ennemi ennemi) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Si tu veux te battre, tape Y. \nTape autre chose pour fuir");
        String response = sc.nextLine();
        if (response.equals("Y")) {
            attaquer(ennemi);
            ennemi.attaquer(this);
        } else {
            fuir();
        }
    }

    /**
     *
     * @param force
     */
    public void subirDommage(int force) {

        this.niveauVie -= force;
        if (this.niveauVie <= 0) {
            this.dead = true;
            this.niveauVie = 0;
            System.out.println("Mince, tu es mort!");
        } else {
            System.out.println("Ton niveau de vie passe à " + this.niveauVie);
        }
    }

}


