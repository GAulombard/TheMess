package com.hodor.jdbc.implementationwithhibernateorm.repository;

import com.hodor.jdbc.implementationwithhibernateorm.DataSourceProvider;
import com.hodor.jdbc.implementationwithhibernateorm.HibernateUtil;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Joueur;
import org.hibernate.Session;
import org.hibernate.query.Query;

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

    public List<Joueur> list(char sexe) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //Query<Joueur> query = session.createQuery("select j from Joueur j where j.sexe=?1", Joueur.class);
        Query<Joueur> query = session.createNamedQuery("given_sex", Joueur.class);
        query.setParameter(1, sexe);
        return query.getResultList();
    }

}
