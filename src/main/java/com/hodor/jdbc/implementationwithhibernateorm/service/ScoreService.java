package com.hodor.jdbc.implementationwithhibernateorm.service;

import com.hodor.jdbc.implementationwithhibernateorm.HibernateUtil;
import com.hodor.jdbc.implementationwithhibernateorm.dto.EpreuveEagerDTO;
import com.hodor.jdbc.implementationwithhibernateorm.dto.MatchDTO;
import com.hodor.jdbc.implementationwithhibernateorm.dto.ScoreEagerDTO;
import com.hodor.jdbc.implementationwithhibernateorm.dto.TournoiDTO;
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

    public ScoreEagerDTO getScore(Long id) {
        Session session = null;
        Transaction tx = null;
        Score score = null;
        ScoreEagerDTO dto = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            score = scoreRepository.getById(id);
            dto = new ScoreEagerDTO();
            dto.setSet1(score.getSet1());
            dto.setSet2(score.getSet2());
            dto.setSet3(score.getSet3());
            dto.setSet4(score.getSet4());
            dto.setSet5(score.getSet5());
            dto.setId(score.getId());
            MatchDTO matchDTO = new MatchDTO();
            matchDTO.setId(score.getMatch().getId());
            EpreuveEagerDTO epreuveEagerDTO = new EpreuveEagerDTO();
            epreuveEagerDTO.setAnnee(score.getMatch().getEpreuve().getAnnee());
            epreuveEagerDTO.setTypeEpreuve(score.getMatch().getEpreuve().getTypeEpreuve());
            TournoiDTO tournoiDTO = new TournoiDTO();
            tournoiDTO.setNom(score.getMatch().getEpreuve().getTournoi().getNom());
            epreuveEagerDTO.setTournoi(tournoiDTO);
            matchDTO.setEpreuve(epreuveEagerDTO);
            dto.setMatchDTO(matchDTO);

            System.out.println("Score récupéré: " + dto);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return dto;
    }
}
