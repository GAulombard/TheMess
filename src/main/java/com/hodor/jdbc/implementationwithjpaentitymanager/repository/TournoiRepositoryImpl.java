package com.hodor.jdbc.implementationwithjpaentitymanager.repository;

import com.hodor.jdbc.implementationwithjpaentitymanager.DataSourceProvider;
import com.hodor.jdbc.implementationwithjpaentitymanager.EntityManagerHolder;
import com.hodor.jdbc.implementationwithjpaentitymanager.HibernateUtil;
import com.hodor.jdbc.implementationwithjpaentitymanager.dto.TournoiDTO;
import com.hodor.jdbc.implementationwithjpaentitymanager.entity.Tournoi;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TournoiRepositoryImpl {

    public void create(Tournoi tournoi) {
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        em.persist(tournoi);
        System.out.println(tournoi);
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
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        em.remove(em.find(Tournoi.class, id));
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

    public Tournoi getByID(Long id) {
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        return em.find(Tournoi.class, id);
    }
}
