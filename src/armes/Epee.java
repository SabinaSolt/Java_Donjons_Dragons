package armes;

import personnages.*;

public class Epee extends Arme{
    public Epee() {
        this(0);
    }

    public Epee( int numeroCase) {
        this.name="Epee";
        this.forceAttack=5;
        this.numeroCase=numeroCase;
    }

    public void interagir(Hero hero) {
        if(hero instanceof Guerrier) {
            hero.augmenterAttaque(this);
        } else {
            System.out.println("Pas de bol! Tu ne sais pas manier une epée!");
        }
    }
}
