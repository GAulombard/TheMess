package com.hodor.jdbc.implementationwithjpaentitymanager.repository;

import com.hodor.jdbc.implementationwithjpaentitymanager.EntityManagerHolder;
import com.hodor.jdbc.implementationwithjpaentitymanager.HibernateUtil;
import com.hodor.jdbc.implementationwithjpaentitymanager.entity.Epreuve;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class EpreuveRepositoryImpl {


    public Epreuve getById(Long id) {
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        return em.find(Epreuve.class, id);
    }

    public List<Epreuve> list(String code) {
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        TypedQuery<Epreuve> query = em.createQuery("""
                select e from Epreuve e
                join fetch e.tournoi
                where e.tournoi.code = :code
                """, Epreuve.class);
        query.setParameter("code", code);
        return query.getResultList();
    }
}
