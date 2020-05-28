package main;

import java.util.Scanner;
import personnages.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        menu.menuDemarrage(sc);
    }
}

