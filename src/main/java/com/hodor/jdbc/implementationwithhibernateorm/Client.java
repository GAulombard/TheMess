package com.hodor.jdbc.implementationwithhibernateorm;

import com.hodor.jdbc.implementationwithhibernateorm.controller.*;

public class Client {
    public static void main(String[] args) {


        JoueurController joueurController = new JoueurController();
        //joueurController.afficheDetailJoueur();
        //joueurController.creerJoueur();
        //joueurController.renommerJoueur();
        //joueurController.changerSexe();
        //joueurController.supprimerJoueur();

        TournoiController tournoiController = new TournoiController();
        //tournoiController.afficheDetailTournoi();
        //tournoiController.creerTournoi();
        //tournoiController.supprimerTournoi();

        ScoreController scoreController = new ScoreController();
        //scoreController.afficheDetailScore();

        EpreuveController epreuveController = new EpreuveController();
        //epreuveController.afficheDetailEpreuveAvecTournoi();
        //epreuveController.afficheDetailEpreuveSansTournoi();

        MatchController matchController = new MatchController();
        matchController.afficheDetailMatch();
    }
}
