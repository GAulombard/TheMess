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
        //joueurController.afficheListeJoueur();

        TournoiController tournoiController = new TournoiController();
        //tournoiController.afficheDetailTournoi();
        //tournoiController.creerTournoi();
        //tournoiController.supprimerTournoi();

        ScoreController scoreController = new ScoreController();
        //scoreController.afficheDetailScore();
        //scoreController.supprimerScore();

        EpreuveController epreuveController = new EpreuveController();
        //epreuveController.afficheDetailEpreuve();
        //epreuveController.afficheDetailEpreuveSansTournoi();
        epreuveController.afficheListeEpreuve();

        MatchController matchController = new MatchController();
        //matchController.afficheDetailMatch();
        //matchController.tapidVert();
        //matchController.ajouterMatch();
        //matchController.supprimerMatch();
    }
}
