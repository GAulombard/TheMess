package com.hodor.jdbc.repository;

import com.hodor.jdbc.entity.Joueur;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JoueurRepositoryImpl {

    public void create(Joueur joueur) {
        Connection con = null;
        try {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setInitialSize(5); // nbr de pools
            dataSource.setUrl("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris");
            dataSource.setUsername("root");
            dataSource.setPassword("rootroot");
            con = dataSource.getConnection();

            PreparedStatement ps = con.prepareStatement("""
                                        INSERT INTO JOUEUR (NOM,PRENOM,SEXE)
                                        VALUES (?,?,?)
                    """);

            ps.setString(1, joueur.getNom());
            ps.setString(2, joueur.getPrenom());
            ps.setString(3, joueur.getSexe().toString());
            ps.executeUpdate();
            ps.close();

            System.out.println("Joueur créé: " + joueur);

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

    public void update(Joueur joueur) {
        Connection con = null;
        try {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setInitialSize(5); // nbr de pools
            dataSource.setUrl("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris");
            dataSource.setUsername("root");
            dataSource.setPassword("rootroot");
            con = dataSource.getConnection();

            PreparedStatement ps = con.prepareStatement("""
                                        UPDATE JOUEUR 
                                        SET NOM=?,PRENOM=?,SEXE=?
                                        WHERE ID=?
                    """);

            ps.setString(1, joueur.getNom());
            ps.setString(2, joueur.getPrenom());
            ps.setString(3, joueur.getSexe().toString());
            ps.setLong(4, joueur.getId());
            ps.executeUpdate();
            ps.close();

            System.out.println("Joueur mis à jour: " + joueur);

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

    public void delete(Long id) {
        Connection con = null;
        try {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setInitialSize(5); // nbr de pools
            dataSource.setUrl("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris");
            dataSource.setUsername("root");
            dataSource.setPassword("rootroot");
            con = dataSource.getConnection();

            PreparedStatement ps = con.prepareStatement("""
                                        DELETE FROM JOUEUR         
                                        WHERE ID=?
                    """);


            ps.setLong(1, id);
            ps.executeUpdate();
            ps.close();

            System.out.println("Joueur supprimé id: " + id);

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

    public Joueur getById(Long id) {
        Connection con = null;
        Joueur joueur = null;
        try {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setInitialSize(5); // nbr de pools
            dataSource.setUrl("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris");
            dataSource.setUsername("root");
            dataSource.setPassword("rootroot");
            con = dataSource.getConnection();

            PreparedStatement ps = con.prepareStatement("""
                                        SELECT NOM,PRENOM,SEXE
                                        FROM JOUEUR         
                                        WHERE ID=?
                    """);

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                joueur = new Joueur();
                joueur.setId(rs.getLong("ID"));
                joueur.setNom(rs.getString("NOM"));
                joueur.setPrenom(rs.getString("PRENOM"));
                joueur.setSexe(rs.getString("SEXE").charAt(0));
                System.out.println("Joueur récupéré: " + joueur);
            }

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
        return joueur;
    }
}
