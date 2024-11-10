package com.hodor.jdbc.implementationwithhibernateorm;

import com.hodor.jdbc.implementationwithhibernateorm.controller.JoueurController;
import com.hodor.jdbc.implementationwithhibernateorm.controller.TournoiController;

public class Client {
    public static void main(String[] args) {


        JoueurController joueurController = new JoueurController();
        //joueurController.afficheDetailJoueur();
        //joueurController.creerJoueur();
        joueurController.renommerJoueur();

        TournoiController tournoiController = new TournoiController();
        //tournoiController.afficheDetailTournoi();
        //tournoiController.creerTournoi();

    }
}
