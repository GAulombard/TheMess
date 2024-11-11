package com.hodor.jdbc.implementationwithhibernateorm.service;

import com.hodor.jdbc.implementationwithhibernateorm.HibernateUtil;
import com.hodor.jdbc.implementationwithhibernateorm.dto.EpreuveEagerDTO;
import com.hodor.jdbc.implementationwithhibernateorm.dto.EpreuveLazyDTO;
import com.hodor.jdbc.implementationwithhibernateorm.dto.TournoiDTO;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Epreuve;
import com.hodor.jdbc.implementationwithhibernateorm.repository.EpreuveRepositoryImpl;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EpreuveService {

    private EpreuveRepositoryImpl epreuveRepository;

    public EpreuveService() {
        this.epreuveRepository = new EpreuveRepositoryImpl();
    }

    public EpreuveEagerDTO getEpreuveAvecTournoi(Long id) {
        Session session = null;
        Transaction tx = null;
        Epreuve epreuve = null;
        EpreuveEagerDTO dto = new EpreuveEagerDTO();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            epreuve = epreuveRepository.getById(id);
            //Hibernate.initialize(epreuve.getTournoi());

            TournoiDTO tournoiDTO = new TournoiDTO();
            tournoiDTO.setId(epreuve.getTournoi().getId());
            tournoiDTO.setCode(epreuve.getTournoi().getCode());
            tournoiDTO.setNom(epreuve.getTournoi().getNom());

            dto.setTournoi(tournoiDTO);
            dto.setAnnee(epreuve.getAnnee());
            dto.setTypeEpreuve(epreuve.getTypeEpreuve());
            dto.setId(epreuve.getId());

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        System.out.println("Epreuve récupéré: " + dto);
        return dto;
    }

    public EpreuveLazyDTO getEpreuveSansTournoi(Long id) {
        Session session = null;
        Transaction tx = null;
        Epreuve epreuve = null;
        EpreuveLazyDTO dto = new EpreuveLazyDTO();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            epreuve = epreuveRepository.getById(id);

            dto.setAnnee(epreuve.getAnnee());
            dto.setTypeEpreuve(epreuve.getTypeEpreuve());
            dto.setId(epreuve.getId());

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        System.out.println("Epreuve récupéré: " + dto);
        return dto;
    }
}
