package armes;

import main.Case;
import personnages.*;

public class BouleFeu extends Arme  {

    public BouleFeu() {
        this.name = "Boule de feu";
        this.forceAttack = 7;
    }

    public void interagir(Hero hero) {
        if (hero instanceof Magicien) {
            this.augmenterAttaque(hero);
        } else {
            System.out.println("Pas de bol! Tu ne sais pas faire de sorts!");
        }
    }



}
