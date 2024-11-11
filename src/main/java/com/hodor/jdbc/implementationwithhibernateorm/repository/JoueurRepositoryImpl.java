package com.hodor.jdbc.implementationwithhibernateorm.repository;

import com.hodor.jdbc.implementationwithhibernateorm.DataSourceProvider;
import com.hodor.jdbc.implementationwithhibernateorm.HibernateUtil;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Joueur;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JoueurRepositoryImpl {


    public Joueur create(Joueur joueur) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.persist(joueur);
        System.out.println("Joueur créé: " + joueur);

        return joueur;
    }

    public void delete(Long id) {

        Joueur joueur = getById(id);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.delete(joueur);
        System.out.println("Joueur supprimé id: " + id);
    }

    public Joueur getById(Long id) {

        Joueur joueur = null;
        Session session = null;

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        joueur = session.get(Joueur.class, id);
        System.out.println("Joueur récupéré: " + joueur);

        return joueur;
    }

    public List<Joueur> list() {
        Connection con = null;
        List<Joueur> joueurs = new ArrayList<>();
        try {
            con = DataSourceProvider.getInstance().getConnection();

            PreparedStatement ps = con.prepareStatement("""
                         SELECT ID, NOM,PRENOM,SEXE
                         FROM JOUEUR         
                    """);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Joueur joueur = new Joueur();
                joueur.setId(rs.getLong("ID"));
                joueur.setNom(rs.getString("NOM"));
                joueur.setPrenom(rs.getString("PRENOM"));
                joueur.setSexe(rs.getString("SEXE").charAt(0));
                joueurs.add(joueur);
            }
            System.out.println("Joueurs récupérés: " + joueurs.size());
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
        return joueurs;
    }
}
