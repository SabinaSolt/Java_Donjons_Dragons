package main;

import armes.*;
import personnages.*;

import java.sql.*;
import java.util.Scanner;

/**
 * La classe ConnectionBD établit la connection à la base de données et
 * assure l'interaction avec la BDD : lecture, écriture, suppression.
 */
public class ConnectionBD {

    protected Connection conn = null;


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

    /**
     * @param id
     */
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

    /**
     * @param sc
     * @return
     */
    public Hero chooseHero(Scanner sc) {
        System.out.println("Pour choisir un personnage depuis la base tapez son id");
        int response = sc.nextInt();
        sc.nextLine();
        Hero personnage = new Guerrier();

        try {

            //Création d'un objet Statement
            Statement state = this.conn.createStatement();
            String query = "SELECT * FROM hero WHERE id=" + response;
            ResultSet result = state.executeQuery(query);
            ResultSetMetaData resultMeta = result.getMetaData();

            while (result.next()) {
                String type = result.getString("Type");
                String nom = result.getString("Nom");
                int vie = result.getInt("NiveauVie");
                int force = result.getInt("NiveauForce");
                String armeNom = result.getString("Arme");
                String bouclier = result.getString("Bouclier");

                if (type.equals("Guerrier")) {
                    personnage = new Guerrier(nom, vie, force, response, bouclier, armeNom);

                } else {
                    personnage = new Magicien(nom, vie, force, response, bouclier, armeNom);
                }
            }
            result.close();
            state.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(personnage.toString());
        return personnage;

    }

    /**
     * @param id
     * @param newName
     */
    public void updateHero(int id, String newName) {

        try {
            String query = "UPDATE `hero` SET `Nom` = ? WHERE `hero`.`id` = ?";
            PreparedStatement prepare = this.conn.prepareStatement(query);
            prepare.setString(1, newName);
            prepare.setInt(2, id);
            prepare.executeUpdate();
            System.out.println("Après la modification:");
            this.getHero(id);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param sc
     */
    public void deleteHero(Scanner sc) {
        System.out.println("Pour supprimer le personnage tapez son id");
        int id = sc.nextInt();
        sc.nextLine();
        try {
            //Création d'un objet Statement
            String query = "DELETE FROM hero WHERE id=?";
            PreparedStatement prepare = this.conn.prepareStatement(query);
            prepare.setInt(1, id);
            System.out.println("Vous etes sur le point de supprimer personnage id " + id);
            System.out.println("Pour confirmer tapez Y ");
            String reponse = sc.nextLine();
            if (reponse.equals("Y")) {
                //L'objet ResultSet contient le résultat de la requête SQL
                prepare.executeUpdate();
                System.out.println("Après la modification:");
            } else {
                System.out.println("La base n'a pas été modifiée:");
            }
            this.getHeroes();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param personnage
     */
    public void createHero(Hero personnage) {
        try {
            String query = "INSERT INTO hero (Type, Nom, NiveauVie, NiveauForce, Arme, Bouclier)  VALUES (?,?,?,?,?,?)";

            PreparedStatement prepare = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            prepare.setString(1, personnage.getType());
            prepare.setString(2, personnage.getName());
            prepare.setInt(3, personnage.getNiveauVie());
            prepare.setInt(4, personnage.getForce());
            prepare.setString(5, personnage.getArme().getName());
            prepare.setString(6, personnage.getProtection());

            prepare.executeUpdate();
            ResultSet generatedKeys = prepare.getGeneratedKeys();
            if (generatedKeys.next()) {
                int newId = generatedKeys.getInt(1);
                personnage.setId(newId);
                this.getHero(newId);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
