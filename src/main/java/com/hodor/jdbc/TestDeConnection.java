package com.hodor.jdbc;

import java.sql.*;

public class TestDeConnection {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris", "root", "rootroot");
            System.out.println("Connected to the database successfully");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("""
                    SELECT ID, NOM, PRENOM
                    FROM TENNIS.JOUEUR
                    """);
            while (rs.next()) {
                System.out.println(rs.getLong("ID") + " " + rs.getString("NOM") + " " + rs.getString("PRENOM"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
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
