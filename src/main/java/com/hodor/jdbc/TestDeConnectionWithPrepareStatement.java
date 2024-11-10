package com.hodor.jdbc;

import java.sql.*;

public class TestDeConnectionWithPrepareStatement {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris", "root", "rootroot");
            System.out.println("Connected to the database successfully");

            PreparedStatement stmt = con.prepareStatement("""
                                        SELECT ID, NOM, PRENOM
                                        FROM JOUEUR
                                        WHERE ID = ?
                    """);
            long id = 12L;
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println(rs.getLong("ID") + " " + rs.getString("NOM") + " " + rs.getString("PRENOM"));
            } else {
                System.out.println("No records found for id: "+id);
            }

            stmt.close();
            rs.close();

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
