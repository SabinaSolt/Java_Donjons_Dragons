package personnages;

public class Guerrier extends Hero {

    //constructor method
    public Guerrier() {
        this.name = "Guerrier";
        this.niveauVie = 5 + (int) (Math.random() * 5);
        this.force = 5 + (int) (Math.random() * 5);
        this.forceMax = 10;
        this.vieMax = 10;

    }

    public Guerrier(String name) {
        this(name, 5 + (int) (Math.random() * 5), 5 + (int) (Math.random() * 5));
//        this.name=name;
//        this.niveauVie=5+(int)(Math.random()*5);
//        this.force=5+(int)(Math.random()*5);
//        this.forceMax=10;
//        this.vieMax =10;
    }

    public Guerrier(String name, int niveauVie, int force) {
        super(name, niveauVie, force);
        this.forceMax = 10;
        this.vieMax = 10;

    }


    //behavior of an object
    @Override
    public String toString() {
        String str = super.toString() + "\nArme: "
                + this.arme + "\nBouclier: " + this.protection;
        ;

        return str;

    }


}
