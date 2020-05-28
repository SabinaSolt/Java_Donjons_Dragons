package main;

import personnages.*;

import java.sql.*;
import java.util.Scanner;

public class ConnectionBD {

    Connection conn = null;

    ConnectionBD() {
        try {

            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/donjons_dragons" +
                            "?useUnicode=true" +
                            "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" +
                            "serverTimezone=UTC",
                    "Sabina", "Sabina1");
            System.out.println("Connexion établie");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public void getHeroes() {
        try {

            //Création d'un objet Statement
            Statement state = this.conn.createStatement();
            //L'objet ResultSet contient le résultat de la requête SQL
            ResultSet result = state.executeQuery("SELECT * FROM hero");
            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();

            for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
            System.out.println("\n");
            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                    if (result.getObject(i) != null) {
                        System.out.print("\t" + result.getObject(i).toString() + "\t |");
                    } else {
                        System.out.print("\t" + "NULL" + "\t |");
                    }
                System.out.println("\n");
            }

            result.close();
            state.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getHero(int id) {
        try {

            //Création d'un objet Statement
            Statement state = this.conn.createStatement();
            String query = "SELECT * FROM hero WHERE id=" + id;

            //L'objet ResultSet contient le résultat de la requête SQL
            ResultSet result = state.executeQuery(query);
            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();

            for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
            System.out.println("\n");
            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                    if (result.getObject(i) != null) {
                        System.out.print("\t" + result.getObject(i).toString() + "\t |");
                    } else {
                        System.out.print("\t" + "NULL" + "\t |");
                    }
                System.out.println("\n");
            }

            result.close();
            state.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateHero(int id, Scanner sc) {

        try {
            //Création d'un objet Statement
            Statement state = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM hero WHERE id=" + id;

            //L'objet ResultSet contient le résultat de la requête SQL
            ResultSet result = state.executeQuery(query);

            result.first();
            System.out.println("Avant la modification:");
            this.getHero(id);
            System.out.println("Entrez le nouveau nom du personnage"
                    + result.getString("Nom") + " (max 45 car):");
            String newName = sc.nextLine();
            //On met à jour les champs
            result.updateString("Nom", newName);
            //On valide
            result.updateRow();
            System.out.println("Après la modification:");
            this.getHero(id);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void deleteHero(int id, Scanner sc) {
        try {
            //Création d'un objet Statement
            Statement state = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "DELETE FROM hero WHERE id=" + id;
            System.out.println("Vous etes sur le point de supprimer personnage id " + id);
            System.out.println("Pour confirmer tapez Y ");
            String reponse = sc.nextLine();
            if (reponse.equals("Y")) {
                //L'objet ResultSet contient le résultat de la requête SQL
                state.executeUpdate(query);
                System.out.println("Après la modification:");
            } else {
                System.out.println("La base n'a pas été modifiée:");
            }
            this.getHeroes();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void createHero(Hero personnage) {
        try {


            String query = "INSERT INTO hero (Type, Nom, NiveauVie, NiveauForce, Arme, Bouclier)  VALUES (?,?,?,?,?,?)";

            PreparedStatement prepare = this.conn.prepareStatement(query);
            prepare.setString(1, personnage.getType());
            prepare.setString(2, personnage.getName());
            prepare.setInt(3, personnage.getNiveauVie());
            prepare.setInt(4, personnage.getForce());
            prepare.setString(5, personnage.getArme().getName());
            prepare.setString(6, personnage.getProtection());


            prepare.executeUpdate();
            System.out.println("Après la modification:");
            this.getHeroes();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
