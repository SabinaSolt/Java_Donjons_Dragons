package personnages;

import armes.*;
import exceptions.PersonnageHorsPlateauException;
import ennemies.*;
import main.Plateau;

import java.util.Scanner;

/**
 * La classe abstraite Hero sert à créer le personnage du jeu
 * et définit ses comportements.<br>
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
    protected int caseCourante = 0;
    protected int derniereCase = 64;
    protected  boolean droitLancerDe;

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
        this.droitLancerDe=true;
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

    public void setDroitLancerDe(boolean droitLancerDe) {
        this.droitLancerDe = droitLancerDe;
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

    public boolean isDroitLancerDe() {
        return droitLancerDe;
    }

    //behavior of an object
    @Override
    public String toString() {
        String str = "id: "+this.id+"\nName: " + this.name + "\nType: " + this.type + "\nVie: " + this.niveauVie + "\nForce: " + this.force;
        return str;
    }



    public void fuir() {
        int caseRecule = 1 + (int) (Math.random() * 6);
        System.out.println("Tu fuis ton ennemi. Le destin te fais reculer de " + caseRecule + " cases");
        this.caseCourante = this.caseCourante - caseRecule;
        if (this.caseCourante < 1) {
            this.caseCourante = 1;
        }
        this.droitLancerDe=false;
        System.out.println("Tu retournes à la case " + this.caseCourante);

    }

    /**
     *
     * @param ennemi
     */
    public void decisionHero(Ennemi ennemi) {
        if(ennemi.isDead()) {
            System.out.println("Tu retrouve le cadavre de ton ennemi");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Si tu veux te battre, tape Y. \nTape autre chose pour fuir");
            String response = sc.nextLine();
            if (response.equals("Y")) {
                ennemi.subirDommage(this);
                this.subirDommage(ennemi);
            } else {
                fuir();
            }
        }

    }

    /**
     *
     * @param ennemi
     */
    public void subirDommage(Ennemi ennemi) {
        System.out.println(ennemi.getName() + " t'a attaqué avec la force de " + ennemi.getForce());
        this.niveauVie -= ennemi.getForce();
        if (this.niveauVie <= 0) {
            this.dead = true;
            this.niveauVie = 0;
            System.out.println("Mince, tu es mort!");
        } else {
            System.out.println("Ton niveau de vie passe à " + this.niveauVie);
        }
    }

}


