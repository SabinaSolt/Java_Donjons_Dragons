package armes;

import personnages.*;

public class Eclair extends Arme {
    public Eclair() {
        this.name="Eclair";
        this.forceAttack=2;
    }
    public void interagir(Hero hero) {
        if(hero instanceof Magicien) {
            hero.augmenterAttaque(this);
        } else {
            System.out.println("Pas de bol! Tu ne sais pas faire de sorts!");
        }
    }
}
