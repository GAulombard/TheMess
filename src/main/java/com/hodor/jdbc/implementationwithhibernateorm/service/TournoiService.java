package com.hodor.jdbc.implementationwithhibernateorm.service;

import com.hodor.jdbc.implementationwithhibernateorm.HibernateUtil;
import com.hodor.jdbc.implementationwithhibernateorm.dto.TournoiDTO;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Tournoi;
import com.hodor.jdbc.implementationwithhibernateorm.repository.TournoiRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TournoiService {

    private TournoiRepositoryImpl tournoiRepository;

    public TournoiService() {
        this.tournoiRepository = new TournoiRepositoryImpl();
    }

    public TournoiDTO createTournoi(TournoiDTO dto) {
        return tournoiRepository.create(dto);
    }

    public TournoiDTO getTournoi(Long id) {
        return tournoiRepository.getById(id);
    }

    public void deleteTournoi(long id) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            tournoiRepository.delete(id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
