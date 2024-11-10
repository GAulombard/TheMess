package com.hodor.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestUpdate {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris", "root", "rootroot");
            System.out.println("Connected to the database successfully");
            con.setAutoCommit(false);
            System.out.println("Autocommit is set to "+con.getAutoCommit());

            PreparedStatement ps = con.prepareStatement("""
                                        UPDATE JOUEUR
                                        SET NOM=?, PRENOM=?
                                        WHERE ID = ?
                    """);
            long id = 24L;
            ps.setString(1, "Errani");
            ps.setString(2, "Sara");
            ps.setLong(3, id);

            int nbrResult = ps.executeUpdate();
            con.commit();

            System.out.println("Updated " + nbrResult + " line(s)");

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
