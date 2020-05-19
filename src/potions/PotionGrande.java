package potions;

public class PotionGrande extends Potion {
    public PotionGrande() {
        this(0);
    }

    public PotionGrande(int numeroCase) {
        this.name="Grande potion de vie";
        this.healingPower=5;
        this.numeroCase=numeroCase;
    }
}
