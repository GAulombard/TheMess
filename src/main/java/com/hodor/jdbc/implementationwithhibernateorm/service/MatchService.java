package com.hodor.jdbc.implementationwithhibernateorm.service;

import com.hodor.jdbc.implementationwithhibernateorm.HibernateUtil;
import com.hodor.jdbc.implementationwithhibernateorm.dto.*;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Joueur;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Match;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Score;
import com.hodor.jdbc.implementationwithhibernateorm.repository.EpreuveRepositoryImpl;
import com.hodor.jdbc.implementationwithhibernateorm.repository.JoueurRepositoryImpl;
import com.hodor.jdbc.implementationwithhibernateorm.repository.MatchRepositoryImpl;
import com.hodor.jdbc.implementationwithhibernateorm.repository.ScoreRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MatchService {

    private final MatchRepositoryImpl matchRepository;
    private final ScoreRepositoryImpl scoreRepository;
    private final EpreuveRepositoryImpl epreuveRepository;
    private final JoueurRepositoryImpl joueurRepository;
    /*private MatchDAO matchDAO;*/

    public MatchService() {
        this.matchRepository = new MatchRepositoryImpl();
        this.scoreRepository = new ScoreRepositoryImpl();
        this.epreuveRepository = new EpreuveRepositoryImpl();
        this.joueurRepository = new JoueurRepositoryImpl();
        /*this.matchDAO = new MatchDAO();*/
    }

    public void enregistrerNouveauMatch(Match match) {
        /*matchDAO.createMatchWithScore(match);*/
        matchRepository.create(match);
        scoreRepository.create(match.getScore());
    }

    public void createMatch(MatchDTO dto) {
        Session session = null;
        Match match = null;
        Transaction tx = null;
        try {

            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();

            match = new Match();
            match.setEpreuve(epreuveRepository.getById(dto.getEpreuve().getId()));
            match.setVainqueur(joueurRepository.getById(dto.getVainqueur().getId()));
            match.setFinaliste(joueurRepository.getById(dto.getFinaliste().getId()));

            Score score = new Score();
            score.setMatch(match);
            match.setScore(score);
            score.setSet1(dto.getScore().getSet1());
            score.setSet2(dto.getScore().getSet2());
            score.setSet3(dto.getScore().getSet3());
            score.setSet4(dto.getScore().getSet4());
            score.setSet5(dto.getScore().getSet5());

            matchRepository.create(match);

            System.out.println("Match ajouté: " + match);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public void deleteMatch(Long id) {
        Session session = null;
        Match match = null;
        Transaction tx = null;
        try {

            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            matchRepository.delete(id);
            System.out.println("Match supprimé: " + id);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void tapisVert(Long id) {
        Session session = null;
        Match match = null;
        Transaction tx = null;
        try {

            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            match = matchRepository.getById(id);

            Joueur ancienVainqueur = match.getVainqueur();
            match.setVainqueur(match.getFinaliste());
            match.setFinaliste(ancienVainqueur);

            match.getScore().setSet1((byte) 0);
            match.getScore().setSet2((byte) 0);
            match.getScore().setSet3((byte) 0);
            match.getScore().setSet4((byte) 0);
            match.getScore().setSet5((byte) 0);

            System.out.println("Match tapis vert: " + match);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public MatchDTO getMatch(Long id) {
        Session session = null;
        Match match = null;
        MatchDTO dto = null;
        Transaction tx = null;
        try {
            dto = new MatchDTO();
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();

            match = matchRepository.getById(id);
            dto.setId(match.getId());
            JoueurDTO vainqueur = new JoueurDTO();
            vainqueur.setId(match.getVainqueur().getId());
            vainqueur.setNom(match.getVainqueur().getNom());
            vainqueur.setPrenom(match.getVainqueur().getPrenom());
            vainqueur.setSexe(match.getVainqueur().getSexe());
            JoueurDTO finaliste = new JoueurDTO();
            finaliste.setId(match.getFinaliste().getId());
            finaliste.setNom(match.getFinaliste().getNom());
            finaliste.setPrenom(match.getFinaliste().getPrenom());
            finaliste.setSexe(match.getFinaliste().getSexe());
            dto.setFinaliste(finaliste);
            dto.setVainqueur(vainqueur);

            TournoiDTO tournoi = new TournoiDTO();
            tournoi.setCode(match.getEpreuve().getTournoi().getCode());
            tournoi.setNom(match.getEpreuve().getTournoi().getNom());
            tournoi.setId(match.getEpreuve().getTournoi().getId());

            EpreuveEagerDTO epreuve = new EpreuveEagerDTO();
            epreuve.setId(match.getEpreuve().getId());
            epreuve.setAnnee(match.getEpreuve().getAnnee());
            epreuve.setTypeEpreuve(match.getEpreuve().getTypeEpreuve());
            epreuve.setTournoi(tournoi);

            ScoreEagerDTO scoreEagerDTO = new ScoreEagerDTO();
            scoreEagerDTO.setSet1(match.getScore().getSet1());
            scoreEagerDTO.setSet2(match.getScore().getSet2());
            scoreEagerDTO.setSet3(match.getScore().getSet3());
            scoreEagerDTO.setSet4(match.getScore().getSet4());
            scoreEagerDTO.setSet5(match.getScore().getSet5());
            scoreEagerDTO.setId(match.getScore().getId());
            dto.setScore(scoreEagerDTO);

            dto.setEpreuve(epreuve);
            System.out.println("Match récupéré: " + dto);

            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return dto;
    }
}
