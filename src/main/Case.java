package main;

import personnages.*;

/**
 * l'interface Case permet d'avoir la méthode "interagir" à toute les cases
 * Comme cette interface est commune à toutes les cases,
 * elle simplifie la création du plâteau et le déroulement du jeu
 */
public interface Case {
    public String getName();
    public void interagir(Hero hero);
}
