package com.hodor.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestWithDataSource {
    public static void main(String[] args) {
        Connection con = null;
        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            //dataSource.setURL("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris");
            dataSource.setServerName("localhost");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("tennis");
            dataSource.setUseSSL(false);
            dataSource.setServerTimezone("Europe/Paris");
            dataSource.setUser("root");
            dataSource.setPassword("rootroot");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris", "root", "rootroot");
            con = dataSource.getConnection();
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
