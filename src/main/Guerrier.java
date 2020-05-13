package main;

public class Guerrier extends Hero{

    //constructor method
    public Guerrier() {
        this.name="Guerrier";
        this.niveauVie=5+(int)(Math.random()*5);
        this.force=5+(int)(Math.random()*5);

    }
    public Guerrier(String name) {
        this.name=name;
        this.niveauVie=5+(int)(Math.random()*5);
        this.force=5+(int)(Math.random()*5);
    }


    //behavior of an object
    @Override
    public String toString() {
        String str=super.toString()+"\nArme: "
                +this.attack+"\nBouclier: "+this.protection;;

        return str;

    }

}
