package personnages;

public class Magicien extends Hero {


    //constructor method
    public Magicien() {
        this.name="Magicien";
        this.niveauVie=3+(int)(Math.random()*3);
        this.force=8+(int)(Math.random()*7);
        this.forceMax=15;
        this.vieMax =6;
    }
    public Magicien(String name) {
        this(name,3+(int)(Math.random()*3),8+(int)(Math.random()*7));
//        this.name=name;
//        this.niveauVie=3+(int)(Math.random()*3);
//        this.force=8+(int)(Math.random()*7);
//        this.forceMax=6;
    }
    public Magicien(String name, int niveauVie, int force){
        super(name, niveauVie, force);
        this.forceMax=15;
        this.vieMax =6;

    }

    //behavior of an object
    @Override
    public String toString() {
        String str=super.toString()+"\nSort: "
                +this.arme +"\nPhiltre: "+this.protection;
        return str;

    }
}
