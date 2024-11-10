package com.hodor.jdbc.implementationwithhibernateorm.repository;

import com.hodor.jdbc.implementationwithhibernateorm.DataSourceProvider;
import com.hodor.jdbc.implementationwithhibernateorm.HibernateUtil;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Tournoi;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TournoiRepositoryImpl {

    public Tournoi create(Tournoi tournoi) {
        Connection con = null;
        try {
            con = DataSourceProvider.getInstance().getConnection();

            PreparedStatement ps = con.prepareStatement("""
                                        INSERT INTO TOURNOI (NOM,CODE)
                                        VALUES (?,?)
                    """, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, tournoi.getNom());
            ps.setString(2, tournoi.getCode());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                tournoi.setId(rs.getLong(1));
            }

            ps.close();

            System.out.println("Tournoi créé: " + tournoi);

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
        return tournoi;
    }

    public void update(Tournoi tournoi) {
        Connection con = null;
        try {
            con = DataSourceProvider.getInstance().getConnection();

            PreparedStatement ps = con.prepareStatement("""
                                        UPDATE TOURNOI 
                                        SET NOM=?,CODE=?
                                        WHERE ID=?
                    """);

            ps.setString(1, tournoi.getNom());
            ps.setString(2, tournoi.getCode());
            ps.setLong(3, tournoi.getId());
            ps.executeUpdate();
            ps.close();

            System.out.println("Tournoi mis à jour: " + tournoi);

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
            con = DataSourceProvider.getInstance().getConnection();

            PreparedStatement ps = con.prepareStatement("""
                                        DELETE FROM TOURNOI         
                                        WHERE ID=?
                    """);


            ps.setLong(1, id);
            ps.executeUpdate();
            ps.close();

            System.out.println("Tournoi supprimé id: " + id);

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

    public Tournoi getById(Long id) {
        Session session = null;
        Tournoi tournoi = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tournoi = session.get(Tournoi.class, id);
            System.out.println("Tournoi récupéré: " + tournoi);

        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return tournoi;
    }

    public List<Tournoi> list() {
        Connection con = null;
        List<Tournoi> tournois = new ArrayList<>();
        try {
            con = DataSourceProvider.getInstance().getConnection();

            PreparedStatement ps = con.prepareStatement("""
                         SELECT ID, NOM,CODE
                         FROM TOURNOI         
                    """);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tournoi tournoi = new Tournoi();
                tournoi.setId(rs.getLong("ID"));
                tournoi.setNom(rs.getString("NOM"));
                tournoi.setCode(rs.getString("CODE"));
                tournois.add(tournoi);
            }
            System.out.println("Tournois récupérés: " + tournois.size());
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
        return tournois;
    }
}
