package main;

public class Magicien extends Hero{


    //constructor method
    public Magicien() {
        this.name="Magicien";
        this.niveauVie=3+(int)(Math.random()*3);
        this.force=8+(int)(Math.random()*7);
    }
    public Magicien(String name) {
        this.name=name;
        this.niveauVie=3+(int)(Math.random()*3);
        this.force=8+(int)(Math.random()*7);
    }


    //behavior of an object
    @Override
    public String toString() {
        String str=super.toString()+"\nSort: "
                +this.attack+"\nPhiltre: "+this.protection;
        return str;

    }
}
