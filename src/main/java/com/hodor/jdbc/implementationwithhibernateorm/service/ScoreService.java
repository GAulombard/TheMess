package com.hodor.jdbc.implementationwithhibernateorm.service;

import com.hodor.jdbc.implementationwithhibernateorm.HibernateUtil;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Joueur;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Score;
import com.hodor.jdbc.implementationwithhibernateorm.repository.ScoreRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ScoreService {

    private ScoreRepositoryImpl scoreRepository;

    public ScoreService() {
        this.scoreRepository = new ScoreRepositoryImpl();
    }

    public Score getScore(Long id) {
        Session session = null;
        Transaction tx = null;
        Score score = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            score = scoreRepository.getById(id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return score;
    }
}
