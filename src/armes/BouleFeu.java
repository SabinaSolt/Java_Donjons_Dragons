package armes;

import personnages.*;

public class BouleFeu extends Arme {
    public BouleFeu() {
        this(0);
    }

    public BouleFeu(int numeroCase) {
        this.numeroCase = numeroCase;
        this.name = "Boule de feu";
        this.forceAttack = 7;
    }

    public void interagir(Hero hero) {
        if (hero instanceof Magicien) {
            hero.augmenterAttaque(this);
        } else {
            System.out.println("Pas de bol! Tu ne sais pas faire de sorts!");
        }
    }

}
