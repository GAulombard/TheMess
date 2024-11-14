package com.hodor.jdbc.implementationwithhibernateorm.repository;

import com.hodor.jdbc.implementationwithhibernateorm.DataSourceProvider;
import com.hodor.jdbc.implementationwithhibernateorm.HibernateUtil;
import com.hodor.jdbc.implementationwithhibernateorm.dto.EpreuveEagerDTO;
import com.hodor.jdbc.implementationwithhibernateorm.dto.JoueurDTO;
import com.hodor.jdbc.implementationwithhibernateorm.dto.MatchDTO;
import com.hodor.jdbc.implementationwithhibernateorm.dto.TournoiDTO;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Match;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Tournoi;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
