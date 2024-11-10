package com.hodor.jdbc.firstimplementation.service;

import com.hodor.jdbc.firstimplementation.dao.MatchDAO;
import com.hodor.jdbc.firstimplementation.entity.Match;
import com.hodor.jdbc.firstimplementation.repository.MatchRepositoryImpl;
import com.hodor.jdbc.firstimplementation.repository.ScoreRepositoryImpl;

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
