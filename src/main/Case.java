package main;

import personnages.*;

/**
 * L'interface Case permet d'avoir la méthode "interagir" à toute les cases. <br>
 * Comme cette interface est commune à toutes les cases,
 * elle simplifie la création du plâteau et le déroulement du jeu.<br>
 */
public interface Case {
    public String getName();
    public void interagir(Hero hero);
}
