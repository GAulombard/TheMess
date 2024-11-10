package com.hodor.jdbc.implementationwithhibernateorm.service;

import com.hodor.jdbc.implementationwithhibernateorm.entity.Match;
import com.hodor.jdbc.implementationwithhibernateorm.repository.MatchRepositoryImpl;
import com.hodor.jdbc.implementationwithhibernateorm.repository.ScoreRepositoryImpl;

public class MatchService {

    private MatchRepositoryImpl matchRepository;
    private ScoreRepositoryImpl scoreRepository;
    /*private MatchDAO matchDAO;*/

    public MatchService() {
        this.matchRepository = new MatchRepositoryImpl();
        this.scoreRepository = new ScoreRepositoryImpl();
        /*this.matchDAO = new MatchDAO();*/
    }

    public void enregistrerNouveauMatch(Match match) {
        /*matchDAO.createMatchWithScore(match);*/
        matchRepository.create(match);
        scoreRepository.create(match.getScore());
    }
}
