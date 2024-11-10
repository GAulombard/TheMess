package com.hodor.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestInsert {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris", "root", "rootroot");
            System.out.println("Connected to the database successfully");
            con.setAutoCommit(false);
            System.out.println("Autocommit is set to "+con.getAutoCommit());

            PreparedStatement ps = con.prepareStatement("""
                                        INSERT INTO JOUEUR (NOM,PRENOM,SEXE)
                                        VALUES (?,?,?)
                    """);

            ps.setString(1, "Capriati");
            ps.setString(2, "Jennifer");
            ps.setString(3, "F");
            ps.executeUpdate();

            ps.setString(1, "Johannson");
            ps.setString(2, "Thomas");
            ps.setString(3, "H");
            ps.executeUpdate();

            con.commit();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
