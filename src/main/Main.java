package main;

import java.util.Scanner;
import personnages.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConnectionBD conn = new ConnectionBD();
        //conn.getHeroes();
        //conn.getHero(1);
        //conn.updateHero(1,sc);
        //conn.deleteHero(2, sc);


        Menu menu = new Menu();
        Hero personnage= menu.ChoixPersonnage(sc);
        conn.createHero(personnage);

//        menu.ModifierPersonnage(personnage, sc);
//        menu.DemarrerPartie(personnage, sc);
    }
}

