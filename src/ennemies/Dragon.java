package ennemies;

public class Dragon extends Ennemi {
    public Dragon() {
        this(0);
    }

    public Dragon(int numeroCase) {
        this.name = "Dragon";
        this.niveauVie = 15;
        this.force = 4;
        this.numeroCase = numeroCase;
    }
}
