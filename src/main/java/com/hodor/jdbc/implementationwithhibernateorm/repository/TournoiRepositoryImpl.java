package com.hodor.jdbc.implementationwithhibernateorm.repository;

import com.hodor.jdbc.implementationwithhibernateorm.DataSourceProvider;
import com.hodor.jdbc.implementationwithhibernateorm.HibernateUtil;
import com.hodor.jdbc.implementationwithhibernateorm.dto.TournoiDTO;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Joueur;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Tournoi;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TournoiRepositoryImpl {

    public TournoiDTO create(TournoiDTO dto) {
        Session session = null;
        Transaction tx = null;
        Tournoi tournoi = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            tournoi = new Tournoi();
            tournoi.setNom(dto.getNom());
            tournoi.setCode(dto.getCode());
            session.persist(tournoi);
            System.out.println("Tournoi créé: " + tournoi);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return dto;
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
        TournoiDTO dto = getById(id);

        Tournoi tournoi = new Tournoi();
        tournoi.setId(dto.getId());
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.delete(tournoi);
        System.out.println("Tournoi supprimé id: " + id);
    }

    public TournoiDTO getById(Long id) {
        Session session = null;
        Tournoi tournoi = null;
        TournoiDTO dto = null;
        try {
            dto = new TournoiDTO();
            session = HibernateUtil.getSessionFactory().openSession();
            tournoi = session.get(Tournoi.class, id);
            dto.setNom(tournoi.getNom());
            dto.setId(tournoi.getId());
            dto.setCode(tournoi.getCode());
            System.out.println("Tournoi récupéré: " + dto);

        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return dto;
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
