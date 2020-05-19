package ennemies;

public class Gobelin extends Ennemi{
    public Gobelin() {
        this(0);
    }

    public Gobelin(int numeroCase) {
        this.name="Gobelin";
        this.niveauVie=6;
        this.force=1;
        this.numeroCase=numeroCase;
    }

}
