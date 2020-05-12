package main;

public class Magicien extends Hero{
    //state of an object
    protected String name="Magicien";
    protected int niveauVie=3+(int)(Math.random()*3);
    protected int force=8+(int)(Math.random()*7);
    //constructor method
    public Magicien() {
    }
    public Magicien(String name) {
        this.name=name;
    }
    public Magicien(String name, String image, int niveauVie, int force)
    {
        this.name=name;
        this.image=image;
        this.niveauVie=niveauVie;
        this.force=force;
    }
    //


    //behavior of an object
    public void printValues() {
        System.out.println("Name: "+this.name);
        System.out.println("Vie: "+this.niveauVie);
        System.out.println("Force: "+this.force);
        System.out.println("Sort: "+this.attack);
        System.out.println("Philtre: "+this.protection);
    }
}
