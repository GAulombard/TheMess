package com.hodor.jdbc.implementationwithhibernateorm;

import com.hodor.jdbc.implementationwithhibernateorm.controller.EpreuveController;
import com.hodor.jdbc.implementationwithhibernateorm.controller.JoueurController;
import com.hodor.jdbc.implementationwithhibernateorm.controller.ScoreController;
import com.hodor.jdbc.implementationwithhibernateorm.controller.TournoiController;

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
        epreuveController.afficheDetailEpreuveAvecTournoi();
        epreuveController.afficheDetailEpreuveSansTournoi();
    }
}
