package com.hodor.jdbc.implementationwithjpaentitymanager.repository;

import com.hodor.jdbc.implementationwithjpaentitymanager.HibernateUtil;
import com.hodor.jdbc.implementationwithjpaentitymanager.entity.Match;
import org.hibernate.Session;


public class MatchRepositoryImpl {

    public void create(Match match) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.persist(match);
    }

    public Match getById(Long id) {
        Match match = null;
        Session session = null;

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        match = session.get(Match.class, id);

        return match;
    }

    public void delete(Long id) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Match match = session.get(Match.class, id);
        session.delete(match);
        System.out.println("Match supprimé id: " + id);
    }
}
