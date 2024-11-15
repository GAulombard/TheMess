package com.hodor.jdbc.implementationwithjpaentitymanager.repository;


import com.hodor.jdbc.implementationwithjpaentitymanager.EntityManagerHolder;
import com.hodor.jdbc.implementationwithjpaentitymanager.HibernateUtil;
import com.hodor.jdbc.implementationwithjpaentitymanager.entity.Joueur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        TypedQuery<Joueur> query = em.createNamedQuery("given_sex", Joueur.class);
        query.setParameter(1, sexe);
        return query.getResultList();
    }

}
