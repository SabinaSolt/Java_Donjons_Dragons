package potions;

public class PotionStandard extends Potion {

    public PotionStandard() {
        this(0);
    }

    public PotionStandard(int numeroCase) {
        this.name="Potion Standard";
        this.healingPower=2;
        this.numeroCase=numeroCase;
    }
}
