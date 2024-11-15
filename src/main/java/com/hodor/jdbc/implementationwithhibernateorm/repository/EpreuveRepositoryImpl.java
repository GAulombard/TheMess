package com.hodor.jdbc.implementationwithhibernateorm.repository;

import com.hodor.jdbc.implementationwithhibernateorm.HibernateUtil;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Epreuve;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Joueur;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EpreuveRepositoryImpl {


    public Epreuve getById(Long id) {

        Epreuve epreuve = null;
        Session session = null;

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        epreuve = session.get(Epreuve.class, id);

        return epreuve;
    }

    public List<Epreuve> list(String code) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Query<Epreuve> query = session.createQuery("""
                select e from Epreuve e
                where e.tournoi.code = :code
                """, Epreuve.class);
        query.setParameter("code", code);
        return query.getResultList();
    }
}
