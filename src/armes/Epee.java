package armes;

import personnages.Guerrier;
import personnages.Hero;
import personnages.Magicien;

public class Epee extends Arme{
    public Epee() {
        this.name="Epee";
        this.forceAttack=5;
    }
    public void interagir(Hero hero) {
        if(hero instanceof Guerrier) {
            hero.augmenterAttaque(this);
        } else {
            System.out.println("Pas de bol! Tu ne sais pas manier une epée!");
        }
    }
}
