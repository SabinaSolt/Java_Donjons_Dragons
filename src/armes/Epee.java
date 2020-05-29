package armes;

import personnages.*;

public class Epee extends Arme {

    public Epee() {
        this.name = "Epee";
        this.forceAttack = 5;
    }

    public void interagir(Hero hero) {
        if (hero instanceof Guerrier) {
            this.augmenterAttaque(hero);
        } else {
            System.out.println("Pas de bol! Tu ne sais pas manier une epée!");
        }
    }
}
