package main;

public class Hero {
    //state of an object
    protected String name="Hero";
    protected String image="image.jpg";
    protected int niveauVie=5;
    protected int force=8;
    protected String attack;
    protected String protection;


    //constructor method
    public Hero() {
    }
    public Hero(String name) {
        this.name=name;
    }
//    public Hero(String name, String image, int niveauVie, int force)
//    {
//        this.name=name;
//        this.image=image;
//        this.niveauVie=niveauVie;
//        this.force=force;
//    }

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

    public void setAttack(String attack) {
        this.attack = attack;
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

    public String getAttack() {
        return attack;
    }

    public String getProtection() {
        return protection;
    }


    //behavior of an object
    public void printValues() {
        System.out.println("Name: "+this.name);
        System.out.println("Vie: "+this.niveauVie);
        System.out.println("Force: "+this.force);
        System.out.println("Attack: "+this.attack);
        System.out.println("Protection: "+this.protection);
    }
}


