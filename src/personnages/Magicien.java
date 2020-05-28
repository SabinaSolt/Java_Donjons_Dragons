package personnages;

import armes.Motivation;

public class Magicien extends Hero {


    //constructor method
    public Magicien() {
        this.name="Magicien";
        this.niveauVie=3+(int)(Math.random()*3);
        this.force=8+(int)(Math.random()*7);
        this.forceMax=15;
        this.vieMax =6;
        this.type="Magicien";
        this.arme = new Motivation();
    }
    public Magicien(String name) {
        this(name,3+(int)(Math.random()*3),8+(int)(Math.random()*7),0,"","Motivation");

    }
    public Magicien(String name, int niveauVie, int force, int id, String protection, String armeType){
        super(name, niveauVie, force,id, protection, armeType);
        this.forceMax=15;
        this.vieMax =6;
        this.type="Magicien";

    }

    //behavior of an object
    @Override
    public String toString() {
        String str=super.toString()+"\nSort: "
                +this.arme +"\nPhiltre: "+this.protection;
        return str;

    }
}
