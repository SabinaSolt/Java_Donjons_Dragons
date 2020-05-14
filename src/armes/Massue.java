package armes;

import personnages.Guerrier;
import personnages.Hero;

public class Massue extends Arme{
    public Massue() {
        this.name="Massue";
        this.forceAttack=3;
    }

    public void interagir(Hero hero) {
        if(hero instanceof Guerrier) {
            hero.augmenterAttaque(this);
        } else {
            System.out.println("Pas de bol! Tu ne sais pas manier une massue!");
        }
    }
}
