package ennemies;

public class Sorcier extends Ennemi{
    public Sorcier() {
        this(0);
    }

    public Sorcier(int numeroCase) {
        this.name="Sorcier";
        this.niveauVie=9;
        this.force=2;
        this.numeroCase=numeroCase;
    }
}
