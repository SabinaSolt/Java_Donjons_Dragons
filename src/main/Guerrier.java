package main;

public class Guerrier extends Hero{
    //state of an object
   protected String name="Guerrier";

   protected int niveauVie=5+(int)(Math.random()*5);
   protected int force=5+(int)(Math.random()*5);

    //constructor method
//    public Guerrier() {
//    }
    public Guerrier(String name) {
        this.name=name;
    }
//    public Guerrier(String name, String image, int niveauVie, int force)
//    {
//        this.name=name;
//        this.image=image;
//        this.niveauVie=niveauVie;
//        this.force=force;
//    }


    //behavior of an object
    public void printValues() {
        System.out.println("Name: "+this.name);
        System.out.println("Vie: "+this.niveauVie);
        System.out.println("Force: "+this.force);
        System.out.println("Arme: "+this.attack);
        System.out.println("Bouclier: "+this.protection);
    }

}
